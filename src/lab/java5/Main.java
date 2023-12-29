package lab.java5;

import static lab.java5.ReplaceLink.replaseLink;
import static lab.java5.ValidIP.validIP;
import static lab.java5.WordSearch.wordSearch;

public class Main {
    public static void main(String[] args) {
        NumberFinder.numberFinder("The price of the product is $19.99. The discount is 15%. " +
                "The temperature outside is -20,6°C. 5,6 is also a number.");
        ValidPassword.validPassword("12345");
        ValidPassword.validPassword("q1w2e3r4y");
        System.out.println(replaseLink("www.example.com"));
        validIP("255.255.255.255");
        validIP("x.y.z.0");
        wordSearch("And you don't seem to understand " +
                "A shame, you seemed an honest man " +
                "And all the fears you hold so dear " +
                "Will turn to whisper in your ear ", "s");
    }
}
