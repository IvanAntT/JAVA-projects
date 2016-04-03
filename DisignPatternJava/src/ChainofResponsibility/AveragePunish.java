package ChainofResponsibility;

/**
 * Created by johny on 18.01.16.
 */
public class AveragePunish extends Punishment{

    @Override
    public void speedOfVehicle(int speed) {
        if(speed >= 80 && speed<100)
        {
            System.out.println("Your speed is "+speed+" and you must to pay "+(minPayment+80)+"$");
        }
        else
        {
            if(nextPunish != null)
            {
                nextPunish.speedOfVehicle(speed);
            }
        }
    }
}
