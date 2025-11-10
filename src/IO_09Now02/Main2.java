package IO_09Now02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/*
file.dat
По ссылке https://drive.google.com
находится файл file.dat  Сохраните этот файл  на диск (просто “ручками”, не из программы).
 Этот файл содержит сразу 3 файла: картинку  gif, картинку jpg и скомпилированный .class
 файл. Для определения “кто есть кто” операционная система использует так называемые
 сигнатуры файлов т.е. характерные последовательности.
Например:
gif должен начинаться с шестнадцатеричной  последовательности байт 47 49 46 38 39 61
jpeg с последовательности ff d8
java .class файл с шестнадцатеричной  последовательности ca fe ba be

Итак:
Ваша программа  должна записать в отдельный файл первые 601 байт,
затем в отдельный файл записать следующие 57053 байта и оставшиеся
22494 байта записать в следующий файл. Если все сделано правильно,
у вас должно получиться 3 файла.

 */
public class Main2 {
    public static void main(String[] args) {

        String sourse = "file.dat";
        String target1 = "gifFile.gif";
        String target2 = "jpegFile.jpeg";
        String target3 = "javaClassFile.java";

        // fileExtractor(sourse, target1,0,601);
      //  fileExtractor(sourse, target2,601,601+57053);
       // fileExtractor(sourse, target3,601+57053,(601+57053)+22494);

        try (FileReader fr = new FileReader("file.dat")) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            System.out.println("ERROR by readen "+ e.getMessage()); ;
        }


    }
    public static void fileExtractor(String file, String target, int start,int end) {
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(target)) {

            fis.skip(start);

            int totalBytes = end - start;
            for (int i = 0; i < totalBytes; i++) {
                int copyData = fis.read();
                if (copyData == -1) break;
                fos.write(copyData);

            }
        } catch (IOException e) {
            System.out.println("ERROR by Extrakt proces :" + e.getMessage());
        }
    }



}
