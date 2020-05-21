package java.lang.reflect.proxy;

public class Worker implements PeopleTwoMethods {
    @Override
    public String work() {
        System.out.println("生产，工作，劳作");
        return "生产";
    }

    @Override
    public String saying() {
        System.out.println("歌唱，唱歌，歌颂");
        return "唱歌";
    }
}
