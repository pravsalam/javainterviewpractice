/**
 * Created by praveenkumaralam on 10/20/15.
 */
public class WordReverseInString {
    public static void main(String[] args){
        String s=" i am  a bad boy";
        //remove start and end spaces
        int i=0;
        int j =0;
        char[] a = s.trim().toCharArray();
        i=0;
        j= a.length-1;
        int len = a.length;
        while (i<j){
            char temp =a[i];
            a[i] =a[j];
            a[j] =temp;
            i++;
            j--;
        }
        int wordBeg = 0;
        while(i<len){
            if(a[i] == ' '){
                int k=wordBeg;
                int l = i-1;
                while(k<l){
                    char temp = a[l];
                    a[l] = a[k];
                    a[k] =temp;
                    l--;
                    k++;
                }
                while(i<len && a[i] ==' ')i++;
                wordBeg= i;
            }
            else i++;
        }
        String result = new String(a);
        System.out.println("a"+result+"b");
    }
}
