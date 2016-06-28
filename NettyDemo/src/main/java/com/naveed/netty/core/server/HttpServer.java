/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.netty.core.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author naveed
 */
public class HttpServer {

    EventLoopGroup bossGroup;
    EventLoopGroup workerGroup;

    /**
     * Starting HTTP server with DefaultHTTPHandler to receive Messages
     *
     * @param port
     * @param adapter
     */
    public void start(int port, SimpleChannelInboundHandler<Object> adapter) {
        // Configure the server.
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpServerInitializer(adapter));

            System.out.println("HTTP Server Started Successfully in port --> " + port);
            Channel ch = bootstrap.bind(port).sync().channel();
            ch.closeFuture().sync();
        } catch (InterruptedException ex) {
            Logger.getLogger(HttpServer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public void stop() {
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
}

class HttpServerInitializer extends ChannelInitializer<SocketChannel> {

    SimpleChannelInboundHandler<Object> handler;

    public HttpServerInitializer(SimpleChannelInboundHandler<Object> adapter) {
        this.handler = adapter;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        // Create a default pipeline implementation.
        ChannelPipeline p = ch.pipeline();
        p.addLast("decoder", new HttpRequestDecoder());
        p.addLast("encoder", new HttpResponseEncoder());
        p.addLast("handler", handler);
    }
}