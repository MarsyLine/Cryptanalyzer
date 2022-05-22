import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class BruteForce {
    private BruteForce () {}
    public static void bruteForce () {
        Scanner console = new Scanner(System.in);
        String txt = console.nextLine();
        int step = rightKey(txt);
        decoding(step, txt);
    }
    public static String line (int step, String path) {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
                 StringBuilder symbols = new StringBuilder();
            for (int i = 0; i < 50; i++) {
                if (read.ready()) {
                    char symbol = (char)read.read();
                    if (CaesarCode.contains(symbol)) {
                        symbol = CaesarCode.getSymbol(CaesarCode.indexOf(symbol) + step);
                        symbols.append(symbol);
                    } else {
                        symbols.append(symbol);
                    }
                } else {
                    break;
                }
            }
            return symbols.toString();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void decoding (int step, String path) {
        try (BufferedReader read = new BufferedReader(new FileReader(path));
             BufferedWriter write = new BufferedWriter(new FileWriter("Result/Decrypted_by_BF.txt"))) {
            while (read.ready()) {
                char symbol = (char)read.read();
                if (CaesarCode.contains(symbol)) {
                    symbol = CaesarCode.getSymbol(CaesarCode.indexOf(symbol) + step);
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
    public static int rightKey (String path) {
        Path link = Path.of ("Vocabulary/russian-words.txt");
        List<String> vocabulary = null;
        try {
            vocabulary = Files.readAllLines(link);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int step = 1;
        for (int i = step; i <= CaesarCode.size() - 1;) {
            String text = line (step, path);
            int rightWords = 0;
            String[] words = text.split(" ");
            for (String word : words) {
                if (vocabulary.contains(word)) {
                    rightWords++;
                }
            }
            if (rightWords > words.length / 2) {
                break;
            } else {
                step++;
            }
        }
        return step;
    }
}

