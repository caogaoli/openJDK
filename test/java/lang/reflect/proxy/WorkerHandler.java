package java.lang.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WorkerHandler implements InvocationHandler {

    private PeopleTwoMethods peopleTwoMethods;

    /*public WorkerHandler() {

    }*/

    public WorkerHandler(PeopleTwoMethods peopleTwoMethods) {
        this.peopleTwoMethods = peopleTwoMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoker ...");
        Object invoke = method.invoke(peopleTwoMethods, args);
        System.out.println("after invoker ...");
        return invoke;
    }
}
