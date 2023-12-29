package lab.java3;

public class Main {
    public static void main(String[] args) {
        //создаем три объекта класса Product и один класса Hashtable
        Product p1 = new Product("Подвеска", "Универсальное украшение на любой случай.", 356.3,
                3467);
        Product p2 = new Product("Фруктовое драже", "Конфеты без сахара, без ГМО, с натуральным составом.",
                155, 56438);
        Product p3 = new Product("Ночник", "Светильник выполнен в виде хрустального шара с " +
                "проекцией млечного пути.", 1903.5, 92);
        Hashtable<Integer, Product> hashtable = new Hashtable<>(10);

        //добавляем элементы в хэш-таблицу
        hashtable.put(151946825, p1);
        hashtable.put(169877179, p2);
        hashtable.put(156327161, p3);

        System.out.println((hashtable.get(151946825))); //выводим товар с артикулом 151946825
        System.out.println("Table size: " + hashtable.size()); //выводим количество элементов в таблице
        hashtable.remove(151946825); //удаляем товар с артикулом 151946825
        System.out.println("Table size: " + hashtable.size()); //выводим количество элементов в таблице после удаления
        // одного элемента
        System.out.println((hashtable.get(151946825))); //пытаемся вывести удаленный элемент
        System.out.println(hashtable.get(169877179)); //выводим товар с артикулом 169877179
        System.out.println(hashtable.get(156327161)); //выводим товар с артикулом 156327161
        System.out.println("Is empty: " + hashtable.isEmpty()); //проверяем, пустая ли таблица
        hashtable.remove(169877179); //удаляем товар с артикулом 169877179
        hashtable.remove(156327161); //удаляем товар с артикулом 156327161
        System.out.println("Table size: " + hashtable.size()); //выводим количество элементов в таблице после удаления
        // всех элементов
        System.out.println("Is empty: " + hashtable.isEmpty()); //проверяем, пустая ли таблица
    }
}
