import java.io.*;
import java.util.Scanner;

public class CaesarCode {
    public static void encrypt() {
        try (Scanner console = new Scanner(System.in);
             BufferedReader read = new BufferedReader(new FileReader(console.nextLine()));
             BufferedWriter write = new BufferedWriter(new FileWriter("Result/Encrypted_by_Caesar.txt"))) {
            int key = console.nextInt();
            while (read.ready()) {
                write.append(ChangeSymbol.symbolsUp(read, key));
            }
        }
        catch (IOException error) {
            throw new RuntimeException(error);
        }
    }
    public static void decrypt() {
        try (Scanner console = new Scanner(System.in);
             BufferedReader read = new BufferedReader(new FileReader(console.nextLine()));
             BufferedWriter write = new BufferedWriter(new FileWriter("Result/Decrypted_by_Caesar.txt"))) {
            int key = console.nextInt();
            while (read.ready()) {
                write.append(ChangeSymbol.symbolsDown(read, key));
            }
        }
        catch (IOException error) {
            throw new RuntimeException(error);
        }
    }
}