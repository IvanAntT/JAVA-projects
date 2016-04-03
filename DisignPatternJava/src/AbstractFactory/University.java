package AbstractFactory;

/**
 * Created by johny on 13.01.16.
 * Abstract factory
 */
public abstract class University {
    public abstract Student addStudent(String name,String module);
    public static University addStudentTo(String specToAddStudent){
        if(specToAddStudent.equals("kst"))
        {
            return new KstSpec();
        }
        else
        {
            return new LawSpec();
        }
    }
}
