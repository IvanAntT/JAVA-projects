package DataObjectPatterns;

/**
 * Created by johny on 16.01.16.
 * POJO class helps to show functionality of DTO and DAO
 */
public class Child {

    private String egn;
    private String motherEgn;
    private String fatherEgn;
    private String name;
    private int age;
    private String family;

    public Child(String egn, String motherEgn, String fatherEgn, int age, String name, String family) {
        this.egn = egn;
        this.motherEgn = motherEgn;
        this.fatherEgn = fatherEgn;
        this.age = age;
        this.name = name;
        this.family = family;
    }

    public String getEgn() {
        return egn;
    }

    public void setEgn(String egn) {
        this.egn = egn;
    }

    public String getMotherEgn() {
        return motherEgn;
    }

    public void setMotherEgn(String motherEgn) {
        this.motherEgn = motherEgn;
    }

    public String getFatherEgn() {
        return fatherEgn;
    }

    public void setFatherEgn(String fatherEgn) {
        this.fatherEgn = fatherEgn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }
}
