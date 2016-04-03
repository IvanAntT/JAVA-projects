package BuilderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johny on 19.01.16.
 */
public class PcTech extends Tech{

    private Pc createdPc;

    public PcTech (String nameOfBrand)
    {
        if(nameOfBrand.equals("Hp"))
        {
            String brand = "Hp";
            List<String> spec = new ArrayList<String>();
            spec.add("5 ram");
            spec.add("250gb hard-disk");
            createdPc = new Pc(brand,spec,1400);
        }
        else
        {
            String brand = "Toshiba";
            List<String> spec = new ArrayList<String>();
            spec.add("3 ram");
            spec.add("500gb hard-disk");
            createdPc = new Pc(brand,spec,1800);
        }
    }

    @Override
    public void printSpecification() {
        List<String> specs = createdPc.getSpecification();
        System.out.println("Specification of PC is ");
        for(String spec:specs)
        {
            System.out.println(spec);
        }
        System.out.println();

    }

    @Override
    public void printNameOfBrand() {
        System.out.println("The brand of PC is " + createdPc.getNameOfBranch());
        System.out.println();
    }

    @Override
    public void printPrice() {
        System.out.println("The price of this PC is " + createdPc.getPrice());
        System.out.println();
    }
}
