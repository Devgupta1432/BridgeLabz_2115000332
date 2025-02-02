class Circle {
    private double radius;

    public Circle() {
        this(1.0);
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        System.out.println("Default Circle: Radius = " + defaultCircle.getRadius());

        Circle customCircle = new Circle(5.0);
        System.out.println("Custom Circle: Radius = " + customCircle.getRadius());
    }
}
