package pattern.singleton;

/**
 * 枚举单例模式
 */
public enum Singleton3 {
    SINGLE;
    Singleton3() {
    }
    public Singleton3 getSingle(){
        return SINGLE;
    }
}
