package hw5;

import java.io.File;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        BinarySearchTree<String, Integer> wordCounter = new BinarySearchTree<>();

        try {
            // source file of text document to search
            File file = new File("C:\\Users\\clair\\OneDrive\\School\\SPRING 2021\\COSC-211\\hw5\\sampletext.txt");

            Scanner input = new Scanner(file);
            // while there are more words to parse through
            while (input.hasNextLine()) {
                String line = input.nextLine();
                // split all the words by space
                String[] words = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");
                for (String word : words) {
                    // add the word to count
                    if (wordCounter.lookup(word) == null) {
                        wordCounter.add(word, 1);
                    } else {
                        int numOfOcurrences = wordCounter.lookup(word);
                        wordCounter.add(word, numOfOcurrences + 1);
                    }
                }
            }
            input.close();

        } catch (Exception exception) {
            System.out.println("Error -> " + exception.getLocalizedMessage());
        }

        wordCounter.inOrderTraverse();
    }
}
