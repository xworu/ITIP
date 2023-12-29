package lab.java2;

public class Main {
    public static void main(String[] args) {
        Social s1 = new Social("Telegram", 121.1, "Social Network");
        s1.displayInfo();
        s1.helloMessage();

        System.out.printf("Social initialization amount: %d\n\n", Social.getCOUNT());

        Game g1 = new Game("BanG Dream!", 417.3, "Music", "Game");
        g1.displayInfo();
        g1.helloMessage();

        Weather w1 = new Weather("Weather", 9.2, "Weather");
        w1.displayInfo();
        w1.setSize(10.3);
        w1.displayInfo();
        w1.helloMessage();
    }
}
