package abstractFactory;

// 抽象工厂方法实现，区分与工厂方法模式的区别
// 通常适用于不对产品等级结构调整频繁的需求，因为需要修改到抽象工厂类，不符合开闭原则
public class AbstractFactoryMethod {
    public static void main(String[] args) {
        PhoneFactory apple = new AppleFactory();
        IPaid iPaid = apple.createIPaid();
        IPhone iPhone = apple.createIPhone();

        iPaid.method();
        iPhone.method();

        PhoneFactory huawei = new HuaweiFactory();
        IPhone huaweiIPhone = huawei.createIPhone();
        IPaid huaweiIPaid = huawei.createIPaid();
        huaweiIPhone.method();
        huaweiIPaid.method();
    }
}



// 手机类产品接口
interface IPhone {
    void method();
}
// 平板类产品接口
interface IPaid {
    void method();
}
// 抽象工厂接口
abstract class PhoneFactory {
   abstract IPhone createIPhone();

   abstract IPaid createIPaid();
}


class Apple14 implements IPhone {

    @Override
    public void method() {
        System.out.println("生产苹果iphone14");
    }
}

class IPaid3 implements IPaid {
    @Override
    public void method() {
        System.out.println("生产苹果IPaid3");
    }
}

class HuaweiMate40 implements IPhone{

    @Override
    public void method() {
        System.out.println("生产华为Mate40");
    }
}

class HuaweiMatePad implements IPaid {

    @Override
    public void method() {
        System.out.println("生产华为matepad");
    }
}


class AppleFactory extends PhoneFactory {


    @Override
    public IPhone createIPhone() {
        return new Apple14();
    }

    @Override
    public IPaid createIPaid() {
        return new IPaid3();
    }
}

class HuaweiFactory extends PhoneFactory {


    @Override
    public IPhone createIPhone() {
        return new HuaweiMate40();
    }

    @Override
    public IPaid createIPaid() {
        return new HuaweiMatePad();
    }
}


