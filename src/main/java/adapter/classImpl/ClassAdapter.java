package adapter.classImpl;


/**
 * 类适配器
 * 使用继承实现
 */
public class ClassAdapter {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.output5v();
        /**
         * 使用类适配器（继承实现）的缺点是违背迪米特原则，方法污染，例如这里适配器可以输出220v
         */
        //adapter.output220v();
    }
}

class Adaptee {
    int output220v(){
        return 220;
    }
}

interface Target {
    int output5v();
}

class Adapter extends Adaptee implements Target {

    @Override
    public int output5v() {
        int i = output220v();
        System.out.printf("原始电压：%d -> 适配电压：%d", i, 5);
        return 0;
    }
}
