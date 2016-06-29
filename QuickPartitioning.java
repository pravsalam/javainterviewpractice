/**
 * Created by praveenkumaralam on 12/17/15.
 */
public class QuickPartitioning {
    public static void main(String[] args){
        Integer a[] = {19,18,17,16,15,14,13,12,11,10};
        int i=1;
        int j=a.length-1;;
        int pivot = a[0];
        while(i<j){
            while(i<a.length&& a[i] <=pivot) i++;
            while(j>0 && a[j] > pivot) j--;
            if(i<j){
                Integer temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        System.out.println("i = "+Integer.toString(i)+" j ="+Integer.toString(j));
        Integer temp;
        a[0] = a[i-1];
        a[i-1] = pivot;
        for(i=0;i<a.length;i++){
            System.out.print(a[i].toString()+" ");
        }
    }

}
