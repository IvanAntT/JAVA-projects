package BuilderPattern;

import java.util.List;

/**
 * Created by johny on 19.01.16.
 */
public class Pc {
    private String nameOfBranch;
    private List<String> specification;
    private int price;

    public Pc(String nameOfBranch, List<String> specification, int price)
    {
        this.nameOfBranch = nameOfBranch;
        this.specification = specification;
        this.price = price;
    }

    public List<String> getSpecification() {
        return specification;
    }

    public void setSpecification(List<String> specification) {
        this.specification = specification;
    }

    public String getNameOfBranch() {
        return nameOfBranch;
    }

    public void setNameOfBranch(String nameOfBranch) {
        this.nameOfBranch = nameOfBranch;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
