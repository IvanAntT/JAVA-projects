package Singleton;

/**
 * Created by johny on 13.01.16.
 * Class to realize functionality of Singleton disign pattern
 */
public class Test {

    /**
     * Realize functionality of Singleton disign pattern
     * @param args
     */
    public static void main(String[] args) {

        SingletonClass firstInstance = SingletonClass.getSingletonInstance();
        firstInstance.setName("Ivan");
        firstInstance.printMessage();

        SingletonClass secondInstance = SingletonClass.getSingletonInstance();
        secondInstance.setName("Petur");
        secondInstance.printMessage();

        firstInstance.printMessage();
    }
}
