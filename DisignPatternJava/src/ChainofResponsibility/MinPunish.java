package ChainofResponsibility;

/**
 * Created by johny on 18.01.16.
 */
public class MinPunish extends Punishment{

    @Override
    public void speedOfVehicle(int speed) {
        if(speed >= 70 && speed<80)
        {
            System.out.println("Your speed is " + speed + " and you must to pay " + minPayment +"$");
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
