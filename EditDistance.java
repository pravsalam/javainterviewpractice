/**
 * Created by praveenkumaralam on 10/22/15.
 */
public class EditDistance {
    public static void main(String[] args){
        String s1 = "dinitro"; //pravn
        String s2 = "acetyl";
        int l = s1.length();
        int m = s2.length();
        int[][] dp = new int[l][m];
        int i,j;
        for(i=0;i<l;i++){
            dp[i][0] =i;
        }
        //for(i=0;i<m;)
    }
    private static int findEditStance(String s1, String s2){
        System.out.println(s1+" "+s2);
        int l = s1.length();
        int m = s2.length();
        if(l==0 || m ==0 )return l>m?l:m;
        int i;
        int j;
        int edistance = 0;
        if(s1.charAt(0) == s2.charAt(0)){
            //need to check what happens if the string length is 1;
            edistance +=findEditStance(s1.substring(1),s2.substring(1));
            return edistance;
        }
        else{
            edistance =1;
            if(l>0 && m >0){
                //1. insert, iEdit;
                //2. delete character, dEdit;
                //3. substitute,sEdit
                int iEdit = findEditStance(s1.substring(0),s2.substring(1));
                int dEdit = findEditStance(s1.substring(1),s2.substring(0));
                int sEdit = findEditStance(s1.substring(1),s2.substring(1));
                int min = iEdit;
                if(min > dEdit) min = dEdit;
                if(min > sEdit ) min = sEdit;
                edistance +=min;
            }
        }
        return edistance;
    }
}
