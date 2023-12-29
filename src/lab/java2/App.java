package lab.java2;

import java.text.DecimalFormat;

public abstract class App {
    protected String name;
    protected double size;
    protected String type;

    void displayInfo() {
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.printf("App name: %s\nSize: %s MB\nApp type: %s\n", name, df.format(size), type);
    }
    void helloMessage() {
        System.out.println("Hello!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
