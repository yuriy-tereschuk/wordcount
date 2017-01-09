package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Yuriy Tereshchuk on 09.01.2017.
 */
public class WordCount {

    public static void main(String[] args) {

        Path fileName = Paths.get(args[0]);
        Map<String, Word> wordCount = new HashMap<>();

        try (BufferedReader is = Files.newBufferedReader(fileName)) {

            String line = null;

            while( (line = is.readLine()) != null) {
                String[] strings = line.split(" ");

                for (String word: strings) {
                    if (word.length() > 0) {
                        Word w = new Word(word);

                        if (wordCount.get(word) == null ) {
                            wordCount.put(word, w);
                        } else {
                            w = wordCount.get(word);
                            w.increase();
                            wordCount.put(word, w);
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Word> words = new ArrayList<>(wordCount.values());
        Collections.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                return o2.compareTo(o1);
            }
        });

        Iterator iterator = words.iterator();
        for (int i=0; i<10 && iterator.hasNext(); i++) {
            Word w = (Word) iterator.next();
            System.out.println(w);
        }

        String[] palindromes = new String[]{"1221", "77566577", "2211", "332212233"};

        for (String s: palindromes)
            System.out.println(s + " " + (isPalindrome(s) ? "is palindrome" : "is not palindrome"));
    }

    public static boolean isPalindrome(String string) {
        char[] characters = string.toCharArray();

        for (int i = 0, j=characters.length-1; i<characters.length; i++, j--) {
            if(characters[i]!= characters[j])
                return false;
        }

        return true;
    }

}
