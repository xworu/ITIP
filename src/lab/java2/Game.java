package lab.java2;

import java.util.Arrays;

public class Game extends App{

    public Game(String name, double size, String...type){
        this.name = name;
        this.size = size;
        this.type = Arrays.toString(type);
    }

    @Override
    void helloMessage() {
        System.out.println("Hello, a)solute! Which song do you wanna play?\n");
    }

}
