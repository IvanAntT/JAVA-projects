package BuilderPattern;

/**
 * Created by johny on 19.01.16.
 */
public class Test {

    public static void main(String[] args) {

        //Phone created
        TechBuilder market = new TechBuilder();
        Tech samsungPhone =  market.prepareGSM("Samsung");
        samsungPhone.printNameOfBrand();
        samsungPhone.printSpecification();
        samsungPhone.printPrice();

        //PC created
        Tech hpPc = market.preparePC("Hp");
        hpPc.printNameOfBrand();
        hpPc.printSpecification();
        hpPc.printPrice();
    }
}
