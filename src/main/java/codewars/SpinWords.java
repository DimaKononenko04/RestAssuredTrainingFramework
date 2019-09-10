package codewars;

public class SpinWords {

    public String spinWords(String sentence){
        return String.valueOf(new StringBuilder().append(sentence).reverse());
    }
}


