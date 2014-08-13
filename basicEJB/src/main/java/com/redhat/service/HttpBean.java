package com.redhat.service;

/**
 * Created by vgohel on 8/12/14.
 */
@javax.ejb.Stateless(name = "HttpEJB")
public class HttpBean implements HttpBeanInt{
    public HttpBean() {
    }

    @Override
    public String sayHello(String name) {
        return "Hello :" + name;
    }
}
