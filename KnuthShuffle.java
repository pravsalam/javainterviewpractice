import java.util.Random;

/**
 * Created by praveenkumaralam on 12/20/15.
 */
public class KnuthShuffle {
    public static void main(String[] args){
        Integer[] a = new Integer[52];
        for(int i=0;i<52;i++) a[i] = i+1;
        Random randGen = new Random();
        for(int i= a.length-1;i>0;i--){
            int randomNumber = randGen.nextInt(i);
            //System.out.println("i = "+Integer.toString(i)+ " Random number"+Integer.toString(randomNumber));
            int temp = a[i];
            a[i] = a[randomNumber];
            a[randomNumber]= temp;
        }
        for(int num:a){
            System.out.print(" "+Integer.toString(num));
        }
    }
}
