package Module12_AbstractClass;

abstract class GraphicObject {
    private int x =10;
    private int y= 10;
    void moveTo(int newX, int newY) {
        System.out.println("the mouse us moved to " + x + " and " + y + "position");
    }

    abstract void draw();
    abstract void resize();

    static void design() {
        System.out.println("Design method is called");
        System.out.println("Design method is called");
    }

}
