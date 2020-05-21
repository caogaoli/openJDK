package java.lang.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        // reality proxy class
        People people = new Teacher();
        InvocationHandler handler = new WorkHandler(people);
        People peopleProxy = (People) Proxy.newProxyInstance(handler.getClass().getClassLoader(), people.getClass().getInterfaces(), handler);
        System.out.println(peopleProxy.work());
    }

}
