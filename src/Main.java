import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String input = "D:/Studies/GB/Java/Picnic/src/input.txt";

        int wordsCount = wordsCount(input);
        System.out.println("Количество слов: " + wordsCount);

        String longestWord = longestWord(input);
        System.out.println("Самое длинное слово: " + longestWord);

        Map<String, Integer> sumWords = sumWords(input);
        System.out.println("Количество дубликатов:");

        for (Map.Entry<String, Integer> item : sumWords.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }

    public static int wordsCount(String filename) {
        int count = 0;

        try (FileReader fileReader = new FileReader(filename)) {
            Scanner scanner = new Scanner(fileReader);

            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static String longestWord(String filename) {
        String longest = "";

        try (FileReader fileReader = new FileReader(filename)) {
            Scanner scan = new Scanner(fileReader);

            while (scan.hasNext()) {
                String word = scan.next();

                if (word.length() > longest.length()) {
                    longest = word;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return longest;
    }

    public static Map<String, Integer> sumWords(String filename) {
        Map<String, Integer> sum = new HashMap<>();

        try (FileReader fileReader = new FileReader(filename)) {
            Scanner scan = new Scanner(fileReader);

            while (scan.hasNext()) {
                String word = scan.next().toLowerCase();

                if (sum.containsKey(word)) {

                    sum.put(word, sum.get(word) + 1);
                } else {
                    sum.put(word, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
