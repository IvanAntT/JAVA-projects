package BuilderPattern;

/**
 * Created by johny on 19.01.16.
 */
public class TechBuilder {
    public Tech prepareGSM(String nameOfGsmBrand) {
        Tech newTech = new GsmTech(nameOfGsmBrand);
        return newTech;
    }

    public Tech preparePC(String nameOfPcBrand)
    {
        Tech newTech = new PcTech(nameOfPcBrand);
        return newTech;
    }
}
