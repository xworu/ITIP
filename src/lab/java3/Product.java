package lab.java3;

public class Product {
    private String name;
    private String about;
    private double price;
    private int amount;

    public Product(String name, String about, double price, int amount) {
        this.name = name;
        this.about = about;
        this.price = price;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Наименование: " + name + "; Описание: " + about + "; Цена:" + price + "₽; " +
                "Количество на складе: " + amount;
    }
}
