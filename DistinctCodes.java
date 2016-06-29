import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by praveenkumaralam on 12/26/15.
 */
public class DistinctCodes {
    public static void main(String[] args){
        BufferedReader reader;
        int tests =0;
        reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String userinput = reader.readLine();
            tests = Integer.parseInt(userinput);
        }catch(IOException e){
            System.out.println(" Read error");

        }
        while(tests>0){
            tests--;
            HashSet<String> hash = new HashSet<String>();
            String str = null;
            try {
                str = reader.readLine();
            }catch(IOException e){
                System.out.println("error occured");
            }
            int sum =0;
            if(str != null){
                for(int i=0;i<str.length()-1;i++){
                    //System.out.println(str.substring(i,i+2));
                    if(!hash.contains(str.substring(i,i+2))){

                        hash.add(str.substring(i,i+2));
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }
}
