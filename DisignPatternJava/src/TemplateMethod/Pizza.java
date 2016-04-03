package TemplateMethod;

/**
 * Created by johny on 18.01.16.
 */
public class Pizza extends Meal{

    @Override
    void firstStep() {
        System.out.println("1.Take salam, tomato, onion, eggs");
    }

    @Override
    void secondStep() {
        System.out.println("2.Cut the products");
    }

    @Override
    void thirdStep() {
        System.out.println("3.Roast for 30 min ot 150 degrees");
    }
}
