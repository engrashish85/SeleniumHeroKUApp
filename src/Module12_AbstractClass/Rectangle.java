package Module12_AbstractClass;

public class Rectangle extends GraphicObject {
    void draw() {
        System.out.println("Rectangle draw is called");
    }

    void resize() {
        System.out.println("Rectangle resize is called");
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.draw();
        rectangle.resize();
        rectangle.moveTo(10, 5);
    }
}
