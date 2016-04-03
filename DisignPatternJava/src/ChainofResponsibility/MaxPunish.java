package ChainofResponsibility;

/**
 * Created by johny on 18.01.16.
 */
public class MaxPunish extends Punishment{

    @Override
    public void speedOfVehicle(int speed) {
        if(speed >= 100)
        {
            System.out.println("Your speed is "+speed+" and you must to pay "+(minPayment+180)+"$");
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
