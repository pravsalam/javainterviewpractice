/**
 * Created by praveenkumaralam on 1/21/16.
 */
public class NumberOfBitsSet {
    public static void main (String[] args) {
        int n =   214748388;
        int[] bitset = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4};
        int count = 0;
        int bitmask = 0x0001;
        int val =0;
        while(n!=0) {
            count+=bitset[n&0x0F];
            n = n>>4;
        }
        System.out.println(count);
    }
}
