import java.io.*;
import java.util.Scanner;

public class Reader {
    public static void encrypt() {
        try (Scanner console = new Scanner(System.in);
             BufferedReader read = new BufferedReader(new FileReader(console.nextLine()));
             BufferedWriter write = new BufferedWriter(new FileWriter("Text/Result.txt"))) {
            while (read.ready()) {
                char symbol = (char)read.read();
                if (CaesarCode.contains(symbol)) {
                    symbol = CaesarCode.getSymbol(CaesarCode.indexOf(symbol) + 3);
                    write.append(symbol);
                } else {
                    write.append(symbol);
                }
            }
        }
        catch (IOException error) {
            throw new RuntimeException(error);
        }
    }
    public static void decrypt() {
        try (Scanner console = new Scanner(System.in);
             BufferedReader read = new BufferedReader(new FileReader(console.nextLine()));
             BufferedWriter write = new BufferedWriter(new FileWriter("Text/Result.txt"))) {
            while (read.ready()) {
                char symbol = (char)read.read();
                if (CaesarCode.contains(symbol)) {
                    symbol = CaesarCode.getSymbol(CaesarCode.indexOf(symbol) - 3);
                    write.append(symbol);
                } else {
                    write.append(symbol);
                }
            }
        }
        catch (IOException error) {
            throw new RuntimeException(error);
        }
    }
}