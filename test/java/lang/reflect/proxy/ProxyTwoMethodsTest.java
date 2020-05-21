package java.lang.reflect.proxy;

import java.lang.reflect.Proxy;

public class ProxyTwoMethodsTest {

    public static void main(String[] args) {

        PeopleTwoMethods worker = new Worker();
        WorkerHandler handler = new WorkerHandler(worker);
        // PeopleTwoMethods peopleTwoMethods = (PeopleTwoMethods) Proxy.newProxyInstance(handler.getClass().getClassLoader(), worker.getClass().getInterfaces(), handler);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("is empty classLoader : " + (null == classLoader));
        if (null == classLoader) {
            classLoader = handler.getClass().getClassLoader();
        }
        System.out.println("class Loader name : " + classLoader.getClass().getSimpleName());
        PeopleTwoMethods peopleTwoMethods = (PeopleTwoMethods) Proxy.newProxyInstance(classLoader, worker.getClass().getInterfaces(), handler);

        System.out.println(peopleTwoMethods.saying());
        System.out.println(peopleTwoMethods.work());
    }

}
