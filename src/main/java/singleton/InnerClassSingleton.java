package singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

// 内部类实现单例
// 本质是懒汉模式
public class InnerClassSingleton implements Serializable {

    // 不加JVM会默认生成一个，当对类进行修改则无法进行反序列化，因为版本号对应不上
    static final long serialVersionUID = 42L;

    public static void main(String[] args) {
        InnerClassSingleton instance1 = InnerClassSingleton.getInstance();
        InnerClassSingleton instance2 = InnerClassSingleton.getInstance();
        System.out.println(instance1);
        System.out.println(instance1 == instance2);
    }


    // 注意：反序列化不会使用构造方法构造实例
    private InnerClassSingleton() {
        // 解决反射攻击单例问题
        if (InnerClassSingletonHolder.instance != null){
            throw new RuntimeException("不允许存在多例");
        }
    }

    public static InnerClassSingleton getInstance() {

        return InnerClassSingletonHolder.instance;
    }

    private static class  InnerClassSingletonHolder {
        private static  InnerClassSingleton instance = new InnerClassSingleton();
    }


    // 有此方法时反序列化会使用此方法实例化
    public Object readResolve() throws ObjectStreamException {
        return InnerClassSingletonHolder.instance;
    }

}


