/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.netty.core.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author naveed
 */
public class RPCMessage implements Serializable {

    
    public String content;
    
    public Map<String, Object> attributes = new HashMap<>();

    public void addAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public RPCMessage() {
    }

    public RPCMessage(String message) {
        this.content = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, Object> attributes) {
        this.attributes = attributes;
    }
}
