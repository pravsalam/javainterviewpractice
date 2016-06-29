import java.util.Arrays;
import java.util.Comparator;

public class MaxProdOfWords {
    public static void main(String[] args){
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return -1;
                else if(o1.length() <o2.length()) return 1;
                return 0;
            }
        });
        int max =0;
        int[] masks = new int[words.length];
        for(int i=0;i<words.length;i++){
            for(char c:words[i].toCharArray()){
                masks[i] |=1<<c-'a';
            }
        }
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((masks[i] & masks[j]) ==0){
                    int prod = words[i].length()*words[j].length();
                    if(prod >max) max = prod;
                }
            }
        }
        System.out.print("max = "+Integer.toString(max));

    }
}
