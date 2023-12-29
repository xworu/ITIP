package lab.java2;

public class Weather extends Social{
    public Weather(String name, double size, String type){
        super(name, size, type);

    }

    @Override
    void helloMessage() {
        System.out.println("Today the temperature is around 23C. Have a nice day!\n");
    }
}
