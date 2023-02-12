package singleton;


import java.io.*;

/**
 * 序列化测试
 */
public class SerializableTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // 使用内部类
//        InnerClassSingleton instance = InnerClassSingleton.getInstance();
//        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("test"));
//        os.writeObject(instance);
//        os.close();

//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test"));
//        InnerClassSingleton singleton = (InnerClassSingleton) ois.readObject();
//
//        System.out.println(instance == singleton);

        // 使用枚举
        EnumSingleton instance = EnumSingleton.getInstance();
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("serialize"));
        os.writeObject(instance);
        os.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("serialize"));
        EnumSingleton singleton = (EnumSingleton) ois.readObject();
        System.out.println(instance == singleton);


    }

    // 使用单例模式的例子
    // JDK的 RunTime的内部currentRuntime实例
    // Spring的DefaultSingletonBeanRegistry的singletonObjects实例
    // ProxyFactoryBean# getSingletonInstance方法

}
