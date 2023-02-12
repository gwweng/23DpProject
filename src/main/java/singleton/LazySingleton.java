package singleton;

//  懒汉单例模式
public class LazySingleton {

    // volatile 防止指令重排
    private volatile static LazySingleton instance;

    public static void main(String[] args) {
//        LazySingleton instance = LazySingleton.getInstance();
//        LazySingleton instance1 = LazySingleton.getInstance();
//        System.out.println(instance == instance1);

        // 多线程问题
        new Thread(() -> {
            LazySingleton instance = LazySingleton.getInstance2();
            System.out.println(instance);
        }).start();

        new Thread(() -> {
            LazySingleton instance2 = LazySingleton.getInstance2();
            System.out.println(instance2);
        }).start();
    }


    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            try {
                // 避免运行过快无法复现多线程问题
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new LazySingleton();
        }
        return instance;
    }

    // 双重检查
    public static LazySingleton getInstance2() {
        if (instance == null) {
           synchronized (LazySingleton.class){
               if (instance == null) {
                   instance = new LazySingleton();
               }
           }
        }
        return instance;
    }
}
