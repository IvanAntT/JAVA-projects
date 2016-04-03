package ObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by johny on 19.01.16.
 */
public class ExchangeRate extends Observable{

    private List<Observer> listWithObserv;
    private int rate;

    public ExchangeRate(){
        listWithObserv = new ArrayList<Observer>();
    }

    public void addObserver(Observer ob)
    {
        listWithObserv.add(ob);
    }

    public void deleteObserver(Observer observerForDel)
    {
        listWithObserv.remove(observerForDel);
    }

    public void setRate(int rateValue){
        this.rate = rateValue;
        notifyAllObserv();
    }

    private void notifyAllObserv() {
        for(Observer obs :listWithObserv)
        {
            obs.update(this, rate);
        }
    }
}
