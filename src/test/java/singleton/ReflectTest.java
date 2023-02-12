package singleton;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {

    // 反射攻击实例
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<? extends InnerClassSingleton> declaredConstructor = InnerClassSingleton.getInstance().getClass().getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        InnerClassSingleton newInstance = declaredConstructor.newInstance();

        InnerClassSingleton instance = InnerClassSingleton.getInstance();
        System.out.println(newInstance == instance);
        System.out.println(newInstance);
    }
}
