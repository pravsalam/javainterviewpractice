/**
 * Created by praveenkumaralam on 7/25/15.
 */
class StringMatch {
    public static void main(String[] args)
    {
        String str1 = "Hello World";
        String str2 = "Hello World";
        System.out.println("Are they same "+stringMatching(str1, str2));
    }
    private static boolean stringMatching(String str1, String str2){
        char[] string1 = str1.toCharArray();
        char[] string2 = str2.toCharArray();
        Integer str1Length = string1.length;
        Integer str2Length = string2.length;
        if(str1Length != str2Length){
            return false;
        }
        else{
            //check if the strings are same
            Integer i;
            for(i=0;i<str1Length;i++){
                if(string1[i] != string2[i]){
                    return false;
                }
            }
        }
        return true;
    }

}
