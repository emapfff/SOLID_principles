//Emil Davlityarov
//e.davlityarov@innopolis.university
import java.util.List;
//1) Solo responsibility and Liskov substitution principles are violated
//2) First of all, solo responsibility is violated in class Calculator should modify sides and don't return area of shapes, therefore
// I added new interface Modification, which change sides.
// Secondly, Liskov substitution is violated when we change sides for rectangle and square (incorrect changing, because
// modified provided for rectangle, but not quite for qube) and solution how I understand add Modification and delete
// class Calculator.
//3) Below
class Runner {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3, 7);
        Square square = new Square(5);
        System.out.println("Area of original rectangle: " + rectangle.getArea());
        rectangle.doModification(List.of(5, 3));
        System.out.println("Area of rectangle after modifications: " + rectangle.getArea());

        System.out.println("\nArea of original square: " + square.getArea());
        square.doModification(List.of(3));
        System.out.println("Area of square after modifications: " + square.getArea());
    }
}
class Rectangle implements Shape, Modification{
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    @Override
    public double getArea() {
        return height * width;
    }
    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }
    @Override
    public void doModification(List<Integer> changes){
        this.height = changes.get(0);
        this.width = changes.get(1);
    }
}
class Square implements Shape, Modification {
    private double height;
    private double width;
    public Square(double side) {
        this.height = side;
        this.width = side;
    }
    public void setHeight(double height) {
        this.height = height;
        this.width = this.height;
    }
    public void setWidth(double width){
        this.width = width;
        this.height = this.width;
    }
    @Override
    public double getArea() {
        return this.width * this.height;
    }
    @Override
    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }
    @Override
    public void doModification(List<Integer> changes){
        this.height = this.width = changes.get(0);
    }
}
interface Shape{
    double getArea();
    double getPerimeter();
}
interface Modification{
    void doModification(List<Integer> changes);
}