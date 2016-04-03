package ObserverPattern;

import java.util.Observer;

/**
 * Created by johny on 19.01.16.
 */
public class Test {

    public static void main(String[] args) {
        ExchangeRate bank = new ExchangeRate();
        Observer dolar = new Dollar();
        Observer euro = new Euro();
        Observer paund = new Paund();

        bank.addObserver(dolar);
        bank.addObserver(euro);
        bank.addObserver(paund);

        bank.setRate(3);

        System.out.println("==========================");
        bank.deleteObserver(dolar);

        bank.setRate(9);
    }
}
