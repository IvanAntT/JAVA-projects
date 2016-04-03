package AbstractFactory;

/**
 * Created by johny on 13.01.16.
 * Factory for students which study Law in university
 */
public class LawSpec extends University {

    /**
     * Method which create students from different module of spec Law
     * @param name name of student
     * @param moduleOfLaw module of student
     * @return the created student
     */
    @Override
    public Student addStudent(String name, String moduleOfLaw) {
        Student someNewStudent;
        if(moduleOfLaw.equals("Commertional"))
        {
            someNewStudent = new CommertioalLaw(name);
        }
        else
        {
            someNewStudent = new CorporateLaw(name);
        }
        return someNewStudent;
    }
}
