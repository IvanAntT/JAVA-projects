package AbstractFactory;

/**
 * Created by johny on 13.01.16.
 */
public class Test {

    /**
     * Test functionality of abstract factory pattern
     * @param args
     */
    public static void main(String[] args) {
        Student a = University.addStudentTo("kst").addStudent("Ivan","Software");
        a.introduction();

        Student b = University.addStudentTo("kst").addStudent("Petur","Hardware");
        b.introduction();

        Student c = University.addStudentTo("law").addStudent("Ivelina","Commertional");
        c.introduction();

        Student d = University.addStudentTo("law").addStudent("Angel", "Corporate");
        d.introduction();

    }
}
