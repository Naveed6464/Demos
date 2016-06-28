/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo.netty;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.naveed.netty.core.common.RPCResponse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author naveed
 */
public class RequestHandler {

    RPCResponse rpcResponse;

    public RPCResponse handleGetRequest(String path, Map<String, String> params, Map<String, String> headers) {
        rpcResponse = new RPCResponse();

        List<String> pathList = Lists.newArrayList(Splitter.on('/')
                .trimResults()
                .omitEmptyStrings()
                .split(path));

        switch (pathList.get(0)) {
            case "job":
                rpcResponse.setContentAttribute("Its Working...");
                break;
        }
        return rpcResponse;
    }

    public RPCResponse handlePostRequest(String path, String content) {
        rpcResponse = new RPCResponse();

        List<String> pathList = Lists.newArrayList(Splitter.on('/')
                .trimResults()
                .omitEmptyStrings()
                .split(path));

        switch (pathList.get(0)) {
            case "job":
                rpcResponse.setContentAttribute("Its Working... " + content);
                break;
        }
        return rpcResponse;
    }
}
