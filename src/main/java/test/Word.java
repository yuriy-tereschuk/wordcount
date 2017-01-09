package test;

/**
 * Created by Yuriy Tereshchuk on 09.01.2017.
 */
public class Word implements Comparable{
    int count = 1;
    String word;

    public Word(String w) {
        this.word = w;
    }

    void setWord(String word) {
        this.word = word;
    }

    void increase() {
        count++;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Word))
            return false;

        Word w = (Word) o;

        return word.equals(w.word);
    }

    @Override
    public int hashCode() {
        return count + word.hashCode();
    }

    @Override
    public String toString() {
        return word + " " + count;
    }

    @Override
    public int compareTo(Object o) {
        Word w = (Word) o;
        return this.count > w.count ? 1 : this.count < w.count ? -1 : 0;
    }
}
