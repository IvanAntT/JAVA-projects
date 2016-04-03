package AbstractFactory;

/**
 * Created by johny on 13.01.16.
 * The class for software students
 */
public class Software implements Student{

    private String name;
    public Software(String name)
    {
        this.name = name;
    }

    @Override
    public void introduction() {
        System.out.println("Hello I am "+name+" i will study KST-Software");
    }
}
