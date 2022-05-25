import java.util.Scanner;

public class ProgramRun {

    public static String wrongAction = "Выберите одно из предложенных действий";
    public static String way = "Введите путь к файлу в формате: \"C:\\User\\...\\text.txt\"";
    public static String result = "Вы можете посмотреть результат в файле";

    public static void startProgram () {
        Scanner console = new Scanner(System.in);
        System.out.println("Выберите действие: \n" +
                "Для шифровки/расшифровки текста шифром Цезаря, введите: Caesar\n" +
                "Для расшифровки текста методом Brute Force, введите: BF\n" +
                "Поле ввода:");
        while (true) {
            String choice = console.nextLine();
            if (choice.equalsIgnoreCase("Caesar")) {
                caesar();
                break;
            } else  if (choice.equalsIgnoreCase("BF")){
                System.out.println(way);
                BruteForce.bruteForce();
                System.out.println(result + " \"Result/Decrypted_by_BF.txt\"");
                break;
            } else {
                System.out.println(wrongAction);
            }
        }
    }
    public static void caesar () {
        Scanner console = new Scanner(System.in);
            System.out.println("Если Вы хотите зашифровать текст, введите \"Encrypt\"\n" +
                    "Если Вы хотите расшифровать текст, введите \"Decrypt\"\n" +
                    "Поле ввода:" );
        while (true) {
            String choice = console.nextLine();
            if (choice.equalsIgnoreCase("Encrypt")) {
                System.out.println(way + " и ключ");
                CaesarCode.encrypt();
                System.out.println(result + " \"Text/Encrypted_by_Caesar.txt\"");
                break;
            } else if (choice.equalsIgnoreCase("Decrypt")) {
                System.out.println(way + " и ключ");
                CaesarCode.decrypt();
                System.out.println(result + " \"Text/Decrypted_by_Caesar.txt\"");
                break;
            } else {
                System.out.println(wrongAction);
            }
        }
    }
}
