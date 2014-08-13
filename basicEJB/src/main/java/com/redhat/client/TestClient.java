package com.redhat.client;

import com.redhat.service.HttpBeanInt;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;


/**
 * Created by vgohel on 8/12/14.
 */
public class TestClient {

    public static void main(String[] args) {
        invokeService();
    }

    private static void invokeService() {
        final String jndiName="/basicEJB-1.0-SNAPSHOT/HttpEJB!com.redhat.service.HttpBeanInt";
        Properties properties=new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
        properties.put(Context.PROVIDER_URL,"remote://localhost:4447");
        properties.put(Context.SECURITY_PRINCIPAL,"welcome");
        properties.put(Context.SECURITY_CREDENTIALS,"welcome123$");
        properties.put("jboss.naming.client.ejb.context",true);
        try {
            InitialContext ctx=new InitialContext(properties);
            HttpBeanInt httpBeanInt =(HttpBeanInt)ctx.lookup(jndiName);
            System.out.println(httpBeanInt.sayHello("Viral"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
