package factory;

// 工厂方法模式
public class FactoryMethod {
    public static void main(String[] args) {
        Application product = new ConcreteProductA();
        Product a = product.getObject();
        a.method();
    }
}

class SimpleFactory {
    public static Product createProduct(String type){
        switch (type){
            case "A":
                return new ProductA();
            default:
                return new ProductB();
        }
    }
}


abstract class Application {

    // 此处由子类进行实现，可根据不同需求灵活变动
    abstract Product createProduct();

    Product getObject(){
        return createProduct();
    }
}


class ConcreteProductA extends Application {

    @Override
    Product createProduct() {
        return SimpleFactory.createProduct("A");
    }
}


class ConcreteProductB extends Application {

    @Override
    Product createProduct() {
        return SimpleFactory.createProduct("B");
    }
}




