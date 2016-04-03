package ObserverPattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by johny on 19.01.16.
 */
public class Euro implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        int currentRate = Integer.parseInt(arg.toString());
        double currentValue = currentRate * 2.3;
        System.out.println("The Euro value is "+currentValue);
    }
}
