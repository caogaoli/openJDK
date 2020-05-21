package java.lang.reflect.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ProxySample {

    public static void main(String[] args) {

        People people = new Teacher();
        WorkHandler workHandler = new WorkHandler(people);
        People teacher = (People) Proxy.newProxyInstance(workHandler.getClass()
                .getClassLoader(), people.getClass().getInterfaces(), workHandler);
        teacher.work();

        System.out.println("*****************************************************");
        System.out.println("******" + People.class.getSimpleName());
        for (Class<?> anInterface : People.class.getInterfaces()) {
            System.out.println("interface : " + anInterface.getSimpleName());
        }
        System.out.println("******" + Teacher.class.getSimpleName());
        for (Class<?> anInterface : Teacher.class.getInterfaces()) {
            System.out.println("interface : " + anInterface.getSimpleName());
        }

        People peopleProxy = (People) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                Teacher.class.getInterfaces(), (proxy, method, args1) -> people.work());
        peopleProxy.work();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        List<Class> classes = new ArrayList<>();
        classes.add(People.class);
        Class[] tmpArray = new Class[1];
        tmpArray[0] = People.class;
        People tmpPeople = (People) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                tmpArray,
                /*SampleTeacher.class.getInterfaces(),*/
                (proxy, method, args12) -> people.work());
        tmpPeople.work();
    }
}
