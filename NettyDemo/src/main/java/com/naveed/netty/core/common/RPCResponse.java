/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.netty.core.common;


import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author naveed
 */
public class RPCResponse implements Serializable {
    
    public HashMap<String, Object> attributes = new HashMap<String, Object>();

    public void addAttribute(String key, Object value) {
        attributes.put(key, value);
    }

    public Object getAttribute(String key) {
        return attributes.get(key);
    }

    public void setContentAttribute(Object value) {
        attributes.put("content", value);
    }

    public Object getContentAttribute() {
        return attributes.get("content");
    }

    public RPCResponse() {
    }

    public HashMap<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, Object> attributes) {
        this.attributes = attributes;
    }
}
