package com.redhat.service;
import javax.ejb.Remote;
/**
 * Created by vgohel on 8/12/14.
 */
@Remote
public interface HttpBeanInt {
    public String sayHello(String name);
}
