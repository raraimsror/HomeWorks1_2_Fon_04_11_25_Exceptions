import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Add e-mail: ");
        String eMail = scanner.nextLine();

        try {
            checkEmail(eMail);
            System.out.println(eMail + " is correct.");
        } catch (NotCorrectEmailFormatException e) {
            System.out.println("Error: " + e.getMessage());
        }finally {
            System.out.println("строка короче 5 символов, @ не должна быть первым или последним ");
        }
    }

    public static void checkEmail(String mail) throws NotCorrectEmailFormatException {
        if (mail.length() < 5) {
            throw new NotCorrectEmailFormatException("Email is too short (less than 5 characters).");
        }
        int atIndex = mail.indexOf('@');
        int lastAtIndex = mail.lastIndexOf('@');

        if (atIndex != lastAtIndex || atIndex == -1) {
            throw new NotCorrectEmailFormatException("Email must contain exactly one '@' symbol.");
        }
        if (atIndex == 0 || atIndex == mail.length() - 1) {
            throw new NotCorrectEmailFormatException("'@' cannot be the first or last character.");
        }



    }
}
