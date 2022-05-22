import java.util.Scanner;

public class Interface {
    public static void startProgram () {
        Scanner console = new Scanner(System.in);
        System.out.println("Выберите действие:");
        System.out.println("Для шифровки/расшифровки текста шифром Цезаря, введите: Caesar");
        System.out.println("Для расшифровки текста методом Brute Force, введите: BF");
        System.out.println("Поле ввода:");
        while (true) {
            String choice = console.nextLine();
            if (choice.equalsIgnoreCase("Caesar")) {
                caesar();
                break;
            } else  if (choice.equalsIgnoreCase("BF")){
                System.out.println("Введите путь к файлу в формате: \"C:\\User\\...\\text.txt\"");
                BruteForce.bruteForce();
                System.out.println("Вы можете посмотреть результат в файле \"Result/Decrypted_by_BF.txt\"");
                break;
            } else {
                System.out.println("Выберите одно из предложенных действий");
            }
        }
    }
    public static void caesar () {
        Scanner console = new Scanner(System.in);
            System.out.println("Если Вы хотите зашифровать текст, введите \"Encrypt\"");
            System.out.println("Если Вы хотите расшифровать текст, введите \"Decrypt\"");
            System.out.println("Поле ввода:" );
        while (true) {
            String choice = console.nextLine();
            if (choice.equalsIgnoreCase("Encrypt")) {
                System.out.println("Введите путь к файлу в формате: \"C:\\User\\...\\text.txt\"");
                Reader.encrypt();
                System.out.println("Вы можете посмотреть результат в файле \"Text/Encrypted_by_Caesar.txt\"");
                break;
            } else if (choice.equalsIgnoreCase("Decrypt")) {
                System.out.println("Введите путь к файлу в формате: \"C:\\User\\...\\text.txt\"");
                Reader.decrypt();
                System.out.println("Вы можете посмотреть результат в файле \"Text/Decrypted_by_Caesar.txt\"");
                break;
            } else {
                System.out.println("Выберите одно из предложенных действий");
            }
        }
    }
}
