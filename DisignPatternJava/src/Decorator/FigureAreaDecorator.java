package Decorator;

/**
 * Created by johny on 19.01.16.
 */
public class FigureAreaDecorator {
    public void printFigureArea(Object figure){
        if(figure.getClass().getSimpleName().equals("Rectangle"))
        {
            Rectangle currentRect = (Rectangle)figure;
            System.out.print("The area of Rectangle is ");
            currentRect.printAreaOfRectangle();
        }
        else
        {
            Triangle currentTriang = (Triangle)figure;
            System.out.print("The area of Triangle is ");
            currentTriang.printAreaOfTriangle();
        }
    }
}
