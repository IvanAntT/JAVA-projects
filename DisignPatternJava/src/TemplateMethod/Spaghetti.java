package TemplateMethod;

/**
 * Created by johny on 18.01.16.
 */
public class Spaghetti extends Meal{
    @Override
    void firstStep() {
        System.out.println("1.Take pasta, tomatoes, meat");
    }

    @Override
    void secondStep() {
        System.out.println("2.Cut the products and mix it");
    }

    @Override
    void thirdStep() {
        System.out.println("3.Wait until brewing in saucepan ot 150 degrees");
    }
}
