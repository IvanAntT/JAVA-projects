package BuilderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johny on 19.01.16.
 */
public class GsmTech extends Tech{

    private Gsm createdGSM;

    public GsmTech (String nameOfBrand)
    {
        if(nameOfBrand.equals("Samsung"))
        {
            String brand = "Samsung";
            List<String> spec = new ArrayList<String>();
            spec.add("1 ram");
            spec.add("25gb hard-disk");
            createdGSM = new Gsm(brand,spec,400);
        }
        else
        {
            String brand = "Iphone";
            List<String> spec = new ArrayList<String>();
            spec.add("3 ram");
            spec.add("10gb hard-disk");
            createdGSM = new Gsm(brand,spec,800);
        }
    }

    @Override
    public void printSpecification() {
        List<String> specs = createdGSM.getSpecification();
        System.out.println("Specification of GSM is ");
        for(String spec:specs)
        {
            System.out.println(spec);
        }
        System.out.println();

    }

    @Override
    public void printNameOfBrand() {
        System.out.println("The brand of Gsm is " + createdGSM.getNameOfBranch());
        System.out.println();
    }

    @Override
    public void printPrice() {
        System.out.println("The price of this Gsm is " + createdGSM.getPrice());
        System.out.println();
    }
}
