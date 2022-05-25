import java.util.ArrayList;
import java.util.Arrays;

public class Alphabet {
    private static ArrayList<Character> alphabet = new ArrayList<Character>(Arrays.asList('А', 'Б', 'В', 'Г', 'Д',
                                                                                          'Е', 'Ё', 'Ж', 'З', 'И',
                                                                                          'Й', 'К', 'Л', 'М', 'Н',
                                                                                          'О', 'П', 'Р', 'С', 'Т',
                                                                                          'У', 'Ф', 'Х', 'Ц', 'Ч',
                                                                                          'Ш', 'Щ', 'Ъ', 'Ы', 'Ь',
                                                                                          'Э', 'Ю', 'Я', 'а', 'б',
                                                                                          'в', 'г', 'д', 'е', 'ё',
                                                                                          'ж', 'з', 'и', 'й', 'к',
                                                                                          'л', 'м', 'н', 'о', 'п',
                                                                                          'р', 'с', 'т', 'у', 'ф',
                                                                                          'х', 'ц', 'ч', 'ш', 'щ',
                                                                                          'ъ', 'ы', 'ь', 'э', 'ю',
                                                                                          'я', '.', ',', '!', '?',
                                                                                          ':', '-', ' ', '"'));
    public static char getSymbol (int key) {
        if (key > alphabet.size() - 1) {
            key = (key - alphabet.size());
        } else if (key < 0) {
            key = (key + alphabet.size());
        }
        return alphabet.get(key);
    }
    public static boolean contains (char symbol) {
        return alphabet.contains(symbol);
    }
    public static int indexOf (char symbol) {
        return alphabet.indexOf(symbol);
    }
    public static int size () {
        return alphabet.size();
    }
}
