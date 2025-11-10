package Exceptions06Nov01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> list = inputList();
        System.out.println(list);
saveStrings(list);

    }

    public static List<String> inputList() {
        List<String> result = new ArrayList<>();
        System.out.println("Stop program:'exit': ");
        try (Scanner scanner = new Scanner(System.in)) {
            String inputString = "";
            while (true) {
                inputString = scanner.nextLine();
                if (inputString.trim().equals("exit")) {
                    return result;
                } else {
                    result.add(inputString);
                }
            }
        }
    }

    public static void saveStrings(List<String> list) {

        try (Writer filleWriter = new FileWriter("strings.txt",true)) {  // vazna napisats: true stob programma neperepisovala prezde sosdannij fail!!
for (var str: list){
    filleWriter.write(str+System.lineSeparator());  // Perenos stroki = println
}


        } catch (IOException e) {
            System.out.println("Error: file writer");
        }

    }
}
