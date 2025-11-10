package IO06Now02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> list = readFile();
        System.out.println(list);
        List<String> list2 = readFile();
        System.out.println(list2);

    }

    public static List<String> readFile() {
        String fileName = "names.txt";
        List<String> result = new ArrayList<>();
        try (FileReader reader = new FileReader(fileName)) {
            int data;
            StringBuilder sb = new StringBuilder();
            while ((data = reader.read()) != -1) {
                char ch = (char) data;
                sb.append(ch);
            }
             String resString  = sb.toString();
            return Arrays.asList(resString.split("\\*")); // ! Simboliem nepieciesami \\


                /*   if (ch == '*') {
                    result.add(sb.toString());
                    sb.setLength(0);
                } else {
                    sb.append(ch);
                }
            }
            if (sb.length()>0){
                result.add(sb.toString());
                sb.setLength(0);
            }*/
        } catch (FileNotFoundException e) {
            System.out.println("Fail ne naiden");

        } catch (IOException e) {
            System.out.println("osibka cnenia");
        }
        return result;
    }


}
