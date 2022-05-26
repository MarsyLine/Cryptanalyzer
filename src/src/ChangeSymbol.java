import java.io.BufferedReader;
import java.io.IOException;

public class ChangeSymbol {
    public static char symbolsUp (BufferedReader read, int key) {
        char symbol = 0;
        try {
            symbol = (char)read.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (Alphabet.contains(symbol)) {
            return Alphabet.getSymbol(Alphabet.indexOf(symbol) + key);
        } else {
            return symbol;
        }
    }
    public static char symbolsDown (BufferedReader read, int key) {
        char symbol = 0;
        try {
            symbol = (char)read.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (Alphabet.contains(symbol)) {
            return Alphabet.getSymbol(Alphabet.indexOf(symbol) - key);
        } else {
            return symbol;
        }
    }
}
