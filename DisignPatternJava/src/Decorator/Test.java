package Decorator;

/**
 * Created by johny on 19.01.16.
 */
public class Test {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Triangle triangle = new Triangle();

        rectangle.setAreaOfRectangle(40);
        triangle.setAreaOfTriangle(50);

        FigureAreaDecorator decorator = new FigureAreaDecorator();
        decorator.printFigureArea(rectangle);
        decorator.printFigureArea(triangle);
    }
}
