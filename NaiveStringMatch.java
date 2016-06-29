/**
 * Created by praveenkumaralam on 10/31/15.
 */
public class NaiveStringMatch {
    public static void main(String[] args){
        String s1 = "This is the main string where pattern will be matched";
        String s2 = "notmatched";
        if(stringMatch(s1,s2)){
            System.out.println("Pattern was found");
        }
        else{
            System.out.println(" pattern not found");
        }
    }
    private static boolean stringMatch(String thread, String needle){
        int i,j;
        int tlen = thread.length();
        int nlen = needle.length();
        for(i=0;i<=tlen-nlen;i++){
            for(j=0;j < nlen;j++){
                if(thread.charAt(i+j) != needle.charAt(j))break;
            }
            if(j == nlen)return true;
        }
        return false;
    }
}
