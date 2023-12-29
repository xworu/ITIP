package lab.java3;

import java.util.LinkedList;

public class Hashtable<K,V> {
    //массив списков корзин для хранения элементов
    private final LinkedList<Entry<K, V>>[] table;
    //размер массива
    private final int capacity;
    //количество элементов в массиве
    private int size;

    //Конструктор хеш-таблицы
    @SuppressWarnings("unchecked")
    public Hashtable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new LinkedList[capacity];
        //инициализация каждой корзины пустым списком
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }

    //возвращаем количество элементов в таблице
    public int size() {
        return size;
    }

    //проверка на пустую таблицу
    public boolean isEmpty() {
        return size == 0;
    }

    // Добавление элементов в хеш-таблицу
    public void put(K key, V value) {
        //получаем индекс корзины для данного ключа
        int index = getIndex(key);
        //получаем корзину по индексу
        LinkedList<Entry<K, V>> chain = table[index];
        //обновляем значение, если запись уже существует
        for (Entry<K, V> entry : chain) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        //создаем новую запись
        chain.add(new Entry<>(key, value));
        size++;
    }

    // Проверяем, существует ли ключ в хеш-таблице. Если ключ существует, возвращаем его значение,
    // если нет -- возвращаем ноль
    public V get(K key) {
        //получаем индекс корзины для данного ключа
        int index = getIndex(key);
        //получаем корзину по индексу
        LinkedList<Entry<K, V>> chain = table[index];
        //если нашли ключ -- возвращаем его значение
        for (Entry<K, V> entry : chain) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        //если нет -- возвращаем ноль
        return null;
    }

    //Удаляем пары
    public void remove(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> chain = table[index];
        for (Entry<K, V> entry : chain) {
            if (entry.getKey().equals(key)) {
                chain.remove(entry);
                size--;
                return;
            }
        }
    }

    private int getIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode % capacity);
    }

    // Класс для представления пары ключ-значение
    private static class Entry<K, V> {
        private K key;
        private V value;
        //Конструктор для создания новой записи
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public  void setValue(V value) {
            this.value = value;
        }
    }
}
