package Module12_AbstractClass;

import Module5.C;

class Circle extends GraphicObject{
    void draw() {
        System.out.println("circle draw is called");
    }

    void resize() {
        System.out.println("circle resize is called");
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();
        circle.resize();

        circle.moveTo(5, 10);
        GraphicObject.design();
    }
}
