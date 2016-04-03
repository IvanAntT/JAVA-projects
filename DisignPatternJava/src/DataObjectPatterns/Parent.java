package DataObjectPatterns;

/**
 * Created by johny on 16.01.16.
 * POJO class helps to show functionality of DTO and DAO
 */
public class Parent {

    private String egn;
    private String name;
    private String family;
    private int age;
    private String childEgn;
    private String gender;


    public Parent(String egn, String name, String family, int age, String gender, String childEgn) {
        this.egn = egn;
        this.name = name;
        this.family = family;
        this.age = age;
        this.gender = gender;
        this.childEgn = childEgn;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getChildEgn() {
        return childEgn;
    }

    public void setChildEgn(String childEgn) {
        this.childEgn = childEgn;
    }
}
