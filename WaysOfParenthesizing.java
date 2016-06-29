import java.util.ArrayList;

/**
 * Created by praveenkumaralam on 12/19/15.
 */
public class WaysOfParenthesizing {
    public static void main(String[] args){
        //ways u can parenthesize i  = (i-1)*()i-1;
        // numway_i = (numways_i-1)*()numways_i-1;
        //iterative
        int n = 4;
        ArrayList<ArrayList<String>> paranths = new ArrayList<ArrayList<String>>(n);
        int i=1;
        ArrayList<String> parstr = new ArrayList<String>();
        parstr.add("()");
        paranths.add(parstr);
        while(i<n){
            ArrayList<String> curPar = new ArrayList<String>();
            ArrayList<String> prev = paranths.get(i-1);
            for(String oldparanth:prev){
                curPar.add("("+oldparanth+")");
                curPar.add("()"+oldparanth);
                curPar.add(oldparanth+"()");

            }
            paranths.add(curPar);
            i++;
        }
        ArrayList<String> maxpaths = paranths.get(n-1);
        for(String paranth: maxpaths){
            System.out.println(paranth);
        }

    }
}
