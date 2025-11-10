package IO_09Now01;

import java.io.*;

/*
Возьмите какой-нибудь большой файл (например, видео запись).
 Используя FileInputStream и FileOutputStream, реализуйте 2
 метода копирования этого файла. В первом случае используйте
 побайтное чтение\запись. Во втором случае используйте Buffered
 чтение и запись. Сравните время копирования.
 PS По желанию можете реализовать третий вариант  чтение и
 запись через массив. Внимательно сравните размер исходного
 файла и копии, убедитесь, что копия полностью соответствует
        оригиналу.
.

 */
public class Main {
    public static void main(String[] args) {
/*
Bit by bit copy Time:75259
Bit by bit copy Time:27
Bit by bit copy Time:25
 */
        String sourse = "FullBody90.pdf";
        String target1 = "bitBitcopyFullBody90.pdf";
        String target2 = "buferCopyFullBody90.pdf";
        String target3 = "MasivCopyFullBody90.pdf";

        long start1 = System.currentTimeMillis();
        byBiteCopy(sourse, target1);
        long finis1 = System.currentTimeMillis();
        System.out.println("Bit by bit copy Time:" + (finis1 - start1));

        long start2 = System.currentTimeMillis();
        bufferCopy(sourse, target2);
        long finis2 = System.currentTimeMillis();
        System.out.println("Bufer copy Time:" + (finis2 - start2));

        long start3 = System.currentTimeMillis();
        copyViaArray(sourse, target3);
        long finis3 = System.currentTimeMillis();
        System.out.println("Masiv copy Time:" + (finis3 - start3));

    }

    public static void byBiteCopy(String file, String target) {
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(target)) {
            int copyData;
            while ((copyData = fis.read()) != -1) {
                fos.write(copyData);
            }
        } catch (IOException e) {
            System.out.println("ERROR by bite by bite copy proces :" + e.getMessage());
        }
    }

    public static void bufferCopy(String file, String target) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target))) {

            int length;
            byte[] buffer = new byte[8192]; // 8 KB bufer eta standart dlja normalnij raboti.
            while ((length = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, length);
            }
        } catch (IOException e) {
            System.out.println("ERROR by buffered copy:" + e.getMessage());
        }
    }

    public static void copyViaArray(String file, String target) {
        try (FileInputStream fis = new FileInputStream(file);
             FileOutputStream fos = new FileOutputStream(target)) {

            byte[] data = fis.readAllBytes();
            fos.write(data);

        } catch (IOException e) {
            System.out.println("ERROR Copy by masiv: " + e.getMessage());
        }
    }


}
