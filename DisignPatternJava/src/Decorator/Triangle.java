package Decorator;

/**
 * Created by johny on 19.01.16.
 */
public class Triangle {
    private int areaOfTriangle;

    public void setAreaOfTriangle(int areaOfTriangle) {
        this.areaOfTriangle = areaOfTriangle;
    }

    public void printAreaOfTriangle()
    {
        System.out.println(areaOfTriangle);
    }
}
