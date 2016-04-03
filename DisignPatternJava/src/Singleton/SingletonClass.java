package Singleton;

/**
 * Created by johny on 16.01.16.
 * Realize logic ot Singleton disign pattern
 */
public class SingletonClass {
    private static SingletonClass singletonInstance = new SingletonClass();
    private String name;

    /**
     * Disallow access to default constructor of Singleton class
     */
    private SingletonClass(){};

    /**
     * return the only instance of the class
     * @return
     */
    public static SingletonClass getSingletonInstance()
    {
        return singletonInstance;
    }

    /**
     * Set name to the only instance of class
     * @param name the name of the instance
     */
    public void setName(String name){
        singletonInstance.name = name;
    }

    /**
     * Print massage from only instance of class
     */
    public void printMessage(){
        System.out.println("Hello from the only instance of class SingletonClass my name is:"+singletonInstance.name);
    }
}
