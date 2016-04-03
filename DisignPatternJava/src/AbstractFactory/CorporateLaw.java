package AbstractFactory;

/**
 * Created by johny on 13.01.16.
 * The class for students which study corporate law
 */
public class CorporateLaw implements Student {
    private String name;

    public CorporateLaw(String name)
    {
        this.name = name;
    }

    @Override
    public void introduction() {
        System.out.println("Hello I am " + name+" i will study Corporate LAW");
    }
}
