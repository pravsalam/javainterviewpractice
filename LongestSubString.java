/**
 * Created by praveenkumaralam on 10/29/15.
 */
public class LongestSubString {
    public static void main(String[] args){
        String s1 = "NenuPuttindiPulipadu";
        String s2 = "NenuPerigindiPulipadu";
        int max=0;
        //get longest common subsequence
        int l = s1.length();
        int m = s2.length();
        int[][] mat = new int[l][m];
        //we should fill basecase

        int i=0,j=0;
        for(i=0;i<l;i++) {
            for (j = 0; j < m; j++) {
                mat[i][j] =0;
            }
        }
        for(i=0;i<l;i++){
            if(s1.charAt(i) == s2.charAt(0)){
                mat[i][0]= 1;
            }
            else{
                mat[i][0] =0;
            }
        }
        for(j=0;j<l;j++){
            if(s1.charAt(0) == s2.charAt(j)){
                mat[0][j]= 1;
            }
            else{
                mat[0][j] =0;
            }
        }
        for(i=1;i<l;i++){
            for(j=1;j<m;j++){
                System.out.println(" s1 char ="+s1.charAt(i)+" s2char "+s2.charAt(j));
                if(s1.charAt(i)== s2.charAt(j)){
                    System.out.println("Insideif");
                    mat[i][j] =1+mat[i-1][j-1];
                    System.out.println(" mat ij ="+ Integer.toString(mat[i][j]));
                    if(max < mat[i][j]) max = mat[i][j];
                }
            }
        }
        System.out.println(Integer.toString(max));
    }
}
