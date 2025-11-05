import java.util.Scanner;

/*
Создайте метод,
* который просит пользователя ввести email.
* Email считается корректным, если:
* в нем не менее 5 символов,
есть один символ  ‘@’,
 он не должен быть первым или последним
Создайте свой NotCorrectEmailFormatException
Если пользователь ввел некорректную строку метод должен
выкидывать  NotCorrectEmailFormatException.
В main сделайте обработку Exception
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Add e-mail: ");

        String eMail = scanner.nextLine();


        if (mailChek(eMail)) {
            System.out.println(eMail + " is correct.");
        } else {
            System.out.println(eMail + " is inCorrect.");
        }


    }

    public static boolean mailChek(String mail) {

        if (mail == null || mail.length() < 5) {
            return false;
        }
//          kolicestvo @. c max length atnemaem dlinu v katorei udalili(zamenili) simbol @ !
        int atCount = mail.length() - mail.replace("@", "").length();
        if (atCount != 1) {
            return false;}

//   isem @ po indeksu v strocke.
        int atIndex = mail.indexOf('@');
        if (atIndex == 0 || atIndex == mail.length() - 1) {
            return false;
        }
        return true;
    }


}