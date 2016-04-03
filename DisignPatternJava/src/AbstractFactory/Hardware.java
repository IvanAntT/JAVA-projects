package AbstractFactory;

/**
 * Created by johny on 13.01.16.
 * The class for hardware students
 */
public class Hardware implements Student {
    private String name;

    public Hardware(String name)
    {
        this.name = name;
    }

    @Override
    public void introduction() {
        System.out.println("Hello I am " + name+" i will study KST-Hardware");
    }
}
