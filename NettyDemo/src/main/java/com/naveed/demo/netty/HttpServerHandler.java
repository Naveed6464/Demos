/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo.netty;

import com.naveed.netty.core.common.RPCResponse;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.DecoderResult;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONNECTION;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_LENGTH;
import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpHeaders.is100ContinueExpected;
import static io.netty.handler.codec.http.HttpHeaders.isKeepAlive;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import static io.netty.handler.codec.http.HttpResponseStatus.BAD_REQUEST;
import static io.netty.handler.codec.http.HttpResponseStatus.CONTINUE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.codec.http.QueryStringDecoder;
import io.netty.util.CharsetUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author naveed
 */
@Sharable
public class HttpServerHandler extends SimpleChannelInboundHandler<Object> {

    private HttpRequest request;
    RequestHandler requestHandler = new RequestHandler();
    RPCResponse rpcResponse;
    /**
     * Buffer that stores the response content
     */
    private final StringBuilder buf = new StringBuilder();

    /**
     * Previously this method is messageRecieved
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

        if (msg instanceof HttpRequest) {
            request = (HttpRequest) msg;
            String uri = request.getUri();
            Map<String, String> headers = new HashMap<>();
            Map<String, String> params = new HashMap<>();

            System.out.println("Request From URL ---> " + uri + " Time : " + new Date());

            if (msg instanceof HttpContent) {
                System.out.println("^^#########################################################################################");
                HttpContent httpContent = (HttpContent) msg;
                if (httpContent.content().isReadable()) {
                    String content = httpContent.content().toString(CharsetUtil.UTF_8);
                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + content);
                }
            }
            if (is100ContinueExpected(request)) {
                send100Continue(ctx);
            }

            buf.setLength(0);
            //Get Headers
            if (!request.headers().isEmpty()) {
                for (Map.Entry<String, String> h : request.headers().entries()) {
                    System.out.println("Header : " + h.getKey() + " : " + h.getValue());
                    headers.put(h.getKey(), h.getValue());
                }
            }
            //Get Parameters
            QueryStringDecoder queryString = new QueryStringDecoder(request.getUri());
            if (!queryString.parameters().isEmpty()) {
                for (Entry<String, List<String>> p : queryString.parameters().entrySet()) {
                    String key = p.getKey();
                    List<String> vals = p.getValue();
                    for (String val : vals) {
                        params.put(key, val);
                    }
                }
            }

            if (request.getMethod().name().equals("GET")) {
                rpcResponse = requestHandler.handleGetRequest(uri, params, headers);
                buf.append(rpcResponse.getContentAttribute()).append("\r\n");
            }
            appendDecoderResult(buf, request);
        }
        if (msg instanceof HttpContent) {
            System.out.println("^^#########################################################################################");
            HttpContent httpContent = (HttpContent) msg;
            if (httpContent.content().isReadable()) {
                String content = httpContent.content().toString(CharsetUtil.UTF_8);
                System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + content);
                rpcResponse = requestHandler.handlePostRequest(request.getUri(), content);
                buf.append(rpcResponse.getContentAttribute()).append("\r\n");
                appendDecoderResult(buf, request);
            }
            if (msg instanceof LastHttpContent) {
                LastHttpContent trailer = (LastHttpContent) msg;
                writeResponse(ctx, trailer);
            }
            System.out.println("^^#########################################################################################");
        }
    }

    private static void appendDecoderResult(StringBuilder buf, HttpObject o) {
        DecoderResult result = o.getDecoderResult();
        if (result.isSuccess()) {
            return;
        }
        buf.append(".. WITH DECODER FAILURE: ");
        buf.append(result.cause());
        buf.append("\r\n");
    }

    private static void send100Continue(ChannelHandlerContext ctx) {
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, CONTINUE);
        ctx.writeAndFlush(response);
    }

    private boolean writeResponse(ChannelHandlerContext ctx, HttpObject currentObj) {
        // Decide whether to close the connection or not.
        boolean keepAlive = isKeepAlive(request);
        // Build the response object.
        FullHttpResponse response = new DefaultFullHttpResponse(
                HTTP_1_1, currentObj.getDecoderResult().isSuccess() ? OK : BAD_REQUEST,
                Unpooled.copiedBuffer(buf.toString(), CharsetUtil.UTF_8));

        response.headers().set(CONTENT_TYPE, "text/plain; charset=UTF-8");

        if (keepAlive) {
            // Add 'Content-Length' header only for a keep-alive connection.
            response.headers().set(CONTENT_LENGTH, response.content().readableBytes());
            response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
        }

        // Write the response.
        ctx.writeAndFlush(response);
        // Close the non-keep-alive connection after the write operation is done.        
        return keepAlive;
    }

    /*public String convertToJson(Object obj) throws JsonProcessingException {
     mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
     return mapper.writeValueAsString(obj);
     }*/
}
