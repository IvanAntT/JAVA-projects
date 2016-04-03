package TemplateMethod;

/**
 * Created by johny on 18.01.16.
 */
public abstract class Meal {
    abstract void firstStep();
    abstract void secondStep();
    abstract void thirdStep();

    public void making(){
        System.out.println(this.getClass().getSimpleName());
        firstStep();
        secondStep();
        thirdStep();
    }
}
