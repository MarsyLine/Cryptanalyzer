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
    public static String line (int key, String path) {
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
                 StringBuilder symbols = new StringBuilder();
            for (int i = 0; i < 50; i++) {
                if (read.ready()) {
                    symbols.append(ChangeSymbol.symbolsUp(read, key));
                } else {
                    break;
                }
            }
            return symbols.toString();
        }
        catch (IOException error) {
            throw new RuntimeException(error);
        }
    }
    public static void decoding (int step, String path) {
        try (BufferedReader read = new BufferedReader(new FileReader(path));
             BufferedWriter write = new BufferedWriter(new FileWriter("Result/Decrypted_by_BF.txt"))) {
            while (read.ready()) {
                write.append(ChangeSymbol.symbolsUp(read, step));
            }
        }
        catch (IOException error) {
            throw new RuntimeException(error);
        }
    }
    public static int rightKey (String path) {
        int step = 1;
        for (int i = step; i <= Alphabet.size() - 1;) {
            String text = line (step, path);
            int rightWords = foundWords(text);
            if (rightWords > text.split(" ").length / 2) {
                break;
            } else {
                step++;
            }
        }
        return step;
    }
    private static int foundWords (String text) {
        Path link = Path.of ("Vocabulary/russian-words.txt");
        List<String> vocabulary = null;
        try {
            vocabulary = Files.readAllLines(link);
        } catch (IOException error) {
            throw new RuntimeException(error);
        }
        String[] words = text.split(" ");
        int rightWords = 0;
        for (String word : words) {
            if (vocabulary.contains(word)) {
                rightWords++;
            }
        }
        return rightWords;
    }
}

