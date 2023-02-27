package facade;

import org.apache.catalina.Server;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.doSomething();
        client.doSth();
    }


    /**
     * 没有使用外观模式，客户端需要处理复杂的调用逻辑
     */
    private void doSomething(){
        System1.method();
        System2.method();
        System3.method();
    }

    /**
     * 使用外观模式，简化客户端调用
     */
    private void doSth(){
        Facade facade = new ReqFacade();
        facade.doSomething();
    }
}

interface Facade {
    void doSomething();
}

class ReqFacade implements Facade {
    @Override
    public void doSomething() {
        System1.method();
        System2.method();
        System3.method();
    }
}
class System1 {
    public static void method(){
        System.out.println("调用子系统1");
    }
}

class System2 {
    public static void method(){
        System.out.println("调用子系统2");
    }
}

class System3 {
    public static void method(){
        System.out.println("调用子系统3");
    }
}
