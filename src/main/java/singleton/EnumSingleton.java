package singleton;

// 枚举实现，可防止反射创建
// 本质上会标记成private，
// 天然支持反序列化
public enum EnumSingleton {
    INSTANCE;

    EnumSingleton() {

    }

    public static EnumSingleton getInstance(){
        return INSTANCE;
    }


}
