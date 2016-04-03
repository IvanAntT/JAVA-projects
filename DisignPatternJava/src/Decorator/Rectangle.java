package Decorator;

/**
 * Created by johny on 19.01.16.
 */
public class Rectangle {
    private int areaOfRectangle;

    public void setAreaOfRectangle(int areaOfRectangle) {
        this.areaOfRectangle = areaOfRectangle;
    }

    public void printAreaOfRectangle()
    {
        System.out.println(areaOfRectangle);
    }
}
