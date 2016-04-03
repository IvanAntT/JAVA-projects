package AbstractFactory;

/**
 * Created by johny on 13.01.16.
 * Factory for students which study KST in university
 */
public class KstSpec extends University {

    /**
     * Method which create students from different module of spec KST
     * @param name name of students
     * @param moduleOfKst module of students that will be created
     * @return the created student
     */
    @Override
    public Student addStudent(String name,String moduleOfKst) {
        Student someNewStudent;
        if(moduleOfKst.equals("Software"))
        {
            someNewStudent = new Software(name);
        }
        else
        {
            someNewStudent = new Hardware(name);
        }
        return someNewStudent;
    }
}
