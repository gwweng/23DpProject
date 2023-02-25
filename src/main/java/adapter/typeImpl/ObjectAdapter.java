package adapter.typeImpl;

/**
 * 对象适配器 使用组合实现适配器
 */
public class ObjectAdapter {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(adaptee);
        target.output5v();
    }
}


class Adaptee {
    int output220V() {
        return 220;
    }
}

interface Target {
    int output5v();
}


class Adapter implements Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public int output5v() {
        int i = adaptee.output220V();
        System.out.printf("原电压：%d -> 适配后电压：%d", i, 5);
        return 5;
    }
}
