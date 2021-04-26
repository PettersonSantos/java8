package lambdas;

import java.util.ArrayList;
import java.util.Comparator;

public class OrdenaStrings {
    public static void main(String[] args) {

        ArrayList<String> palavras = new ArrayList<>();
        palavras.add("menor");
        palavras.add("um pouco maior");
        palavras.add("o maior dos tres");

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        palavras.sort(Comparator.comparing(String::length));

        System.out.println(palavras);

        for (String p: palavras) {
            System.out.println(p);
        }

        palavras.forEach(s -> System.out.println(s));

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Executando um Runnable");
            }

        }).start();


        new Thread(() -> System.out.println("Executando um Runnable")).start();
    }
}

