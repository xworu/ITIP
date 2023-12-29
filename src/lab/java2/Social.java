package lab.java2;

public class Social extends App{
    private static int COUNT = 0;

    public Social(String name, double size, String type){
        this.name = name;
        this.size = size;
        this.type = type;
        COUNT ++;
    }

    @Override
    void helloMessage() {
        super.helloMessage();
    }

    protected static int getCOUNT() {
        return COUNT;
    }
}
