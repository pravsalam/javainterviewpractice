import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by praveenkumaralam on 12/17/15.
 */
public class Top10Elements {
    private Integer[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
    public static void main(String[] args){
        Top10Elements obj = new Top10Elements();
        obj.top10elements();
        obj.twominimatwomaxima();
    }
    private void top10elements(){

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10);
        for(Integer e:a) {
            if (pq.size() < 10) {
                pq.add(e);
            } else {
                Integer oldelem = pq.poll();
                pq.add(e);
            }
        }
        while(pq.size()>0){
            System.out.print(" "+pq.poll().toString());
        }
    }
    private void twominimatwomaxima(){
        PriorityQueue<Integer> minpq = new PriorityQueue<Integer>(2);
        for(Integer e:a){
            if(minpq.size()<2){
                minpq.add(e);
            }
            else{
                minpq.poll();
                minpq.add(e);
            }
        }
        System.out.println("\n");
        Integer max1 = minpq.poll();
        Integer max2 = minpq.poll();
        Integer min1=a[0];
        Integer min2= a[0];
        Integer maxIndex1 = 0;
        Integer maxIndex2 = 0;
        for(Integer i=0;i<a.length;i++){
            if(a[i] == max1) maxIndex1 = i;
            if(a[i] == max2) maxIndex2 = i;
        }
        for(Integer i=0;i<maxIndex1;i++){
            if(min1 >a[i]) min1 = a[i];
        }
        min2 = a[maxIndex1];
        for(Integer i= maxIndex1+1;i<maxIndex2;i++){
            if(min2<a[i]) min2 = a[i];
        }
        System.out.println(min1.toString()+" "+max1.toString()+" "+min2.toString()+" "+max2.toString());
        System.out.println(" max sum = "+ Integer.toString(max1-min1+max2-min2));
    }

}
