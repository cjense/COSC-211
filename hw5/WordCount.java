import java.io.File;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        BinarySearchTree<String, Integer> wordCounter = new BinarySearchTree<>();

        try {
            File file = new File("C:\\Users\\clair\\OneDrive\\School\\SPRING 2021\\COSC-211\\hw5\\sampletext.txt");

            Scanner input = new Scanner(file);
            while(input.hasNextLine()) {
                String line = input.nextLine();
                String[] words = line.replaceAll("[^a-zA-Z]", "").toLowerCase().split(" ");
                for(String word : words) {
                    if(wordCounter.lookup(word.toLowerCase()) == null) {
                        wordCounter.add(word.toLowerCase(), 1);
                    } else {
                        int numOfOccurences = wordCounter.lookup(word.toLowerCase());
                        wordCounter.add(word.toLowerCase(), numOfOccurences + 1);
                    }
                }
            }
            input.close();
        } catch(Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        wordCounter.inOrderTraverse();
    }
}