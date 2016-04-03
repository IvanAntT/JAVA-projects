package ChainofResponsibility;

/**
 * Created by johny on 18.01.16.
 */
public class Test {
    public static void main(String[] args) {
        Punishment min = new MinPunish();
        Punishment avg = new AveragePunish();
        Punishment max = new MaxPunish();

        min.setNextPunish(avg);
        avg.setNextPunish(max);

        min.speedOfVehicle(80);
    }
}
