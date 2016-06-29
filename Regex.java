import java.util.HashMap;

/**
 * Created by praveenkumaralam on 10/13/15.
 */
public class Regex {
    public static void main(String[] args){
        //Given list of words, and a regex return all words that satisify the regex
        String input = "aaa";
        String pattern = ".*";
        //pattern matches the input
        int len = input.length();
        int patLen = pattern.length();
        int i = 0;
        int j =0;
        for(i=0;i<len;i++){
            if(pattern.charAt(j)!= '.'&& pattern.charAt(j) != '*') {
                if (pattern.charAt(j) != input.charAt(i)) {
                    System.out.println(" pat 1 False "+pattern.charAt(j)+" "+input.charAt(i));
                    return;
                }
                else j++;
            }
            else{
                    if(pattern.charAt(j) =='.'){
                        //don't do the checking.
                        //move to next char on pattern
                        j++;
                    }
                    if(pattern.charAt(j) == '*'){
                        //problem comes here.The previous character can come 0 or more times.
                        if(j == 0) {System.out.println("pat 2 False");return;}
                        char prevChar = pattern.charAt(j-1);
                        if(prevChar != '.'){
                            //previous character is an alphabet. now go over input until we find non matching character
                            while(i<len && input.charAt(i) == prevChar) i++;
                            i--;
                            j++;
                        }
                        else if(prevChar == '.'){
                            //any type of character can match any number of times.
                            if(j < patLen -1){
                                char nextChar = pattern.charAt(j+1);
                                int remPatLen = patLen -1 - j;
                                //move i to that
                                i = len -1 - remPatLen;
                                j++;
                            }
                        }
                    }
                }
        }
        System.out.println("True");
    }

}
