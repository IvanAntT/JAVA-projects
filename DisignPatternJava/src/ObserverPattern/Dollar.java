package ObserverPattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by johny on 19.01.16.
 */
public class Dollar implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        int currentRate = Integer.parseInt(arg.toString());
        double currentValue = currentRate * 4.3;
        System.out.println("The Dollar value is "+currentValue);
    }
}
