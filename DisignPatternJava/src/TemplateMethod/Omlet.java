package TemplateMethod;

/**
 * Created by johny on 18.01.16.
 */
public class Omlet extends Meal {
    @Override
    void firstStep() {
        System.out.println("1.Take eggs, onion, cheese");
    }

    @Override
    void secondStep() {
        System.out.println("2.Put the product in pan");
    }

    @Override
    void thirdStep() {
        System.out.println("3.Roast and stir for 20 min 120 degrees");
    }
}
