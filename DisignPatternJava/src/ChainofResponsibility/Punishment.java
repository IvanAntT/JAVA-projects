package ChainofResponsibility;

/**
 * Created by johny on 18.01.16.
 */
public abstract class Punishment {
    protected final int minPayment = 20;
    protected Punishment nextPunish;

    public void setNextPunish(Punishment nextPunish)
    {
        this.nextPunish = nextPunish;
    }

    abstract public void speedOfVehicle(int speed);
}
