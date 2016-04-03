package TemplateMethod;

/**
 * Created by johny on 18.01.16.
 */
public class Test {

    public static void main(String[] args) {
        Meal firstMeal = new Pizza();
        Meal secondMeal = new Omlet();
        Meal thirdMeal = new Spaghetti();

        firstMeal.making();
        System.out.println("===========================");
        secondMeal.making();
        System.out.println("===========================");
        thirdMeal.making();
    }
}
