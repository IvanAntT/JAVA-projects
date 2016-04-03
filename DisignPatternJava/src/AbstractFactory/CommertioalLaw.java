package AbstractFactory;

/**
 * Created by johny on 13.01.16.
 * The class for students which study commertional law
 */
public class CommertioalLaw implements Student {
    private String name;

    public CommertioalLaw(String name)
    {
        this.name = name;
    }

    @Override
    public void introduction() {
        System.out.println("Hello I am "+name+" i will study Commertioanal LAW");
    }
}
