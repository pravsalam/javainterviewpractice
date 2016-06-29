import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by praveenkumaralam on 12/18/15.
 */
public class PlaneDiv {
    public static void main(String[] args){
        Integer testcases=0;
        Integer tests =0;
        Scanner sc = new Scanner(System.in);
        testcases = sc.nextInt();
        //System.out.println("testcases "+testcases.toString());
        while(testcases-->0){
            tests = sc.nextInt();
            Integer max=0;
            ArrayList<Cordinate> cordList = new ArrayList<>(tests);
            for(Integer i=0;i<tests;i++){
                Cordinate cordinate = new Cordinate();
                cordinate.x = sc.nextInt();
                cordinate.y = sc.nextInt();
                cordinate.c = sc.nextInt();
                cordList.add(cordinate);
            }
            HashMap<Double, ArrayList<Cordinate>> hashMap = new HashMap<Double, ArrayList<Cordinate>>();
            for(Integer i=0;i<tests;i++){
                Cordinate cordinate = cordList.get(i);
                Double slope =  (cordinate.x)/(double)cordinate.y;
                //System.out.println(" slope = "+slope.toString());
                if(!hashMap.containsKey(slope)){
                    ArrayList<Cordinate> arrayList = new ArrayList<Cordinate>();
                    arrayList.add(cordinate);
                    hashMap.put(slope,arrayList);
                    //1arrayList.removeAll(arrayList);

                }else{
                    //System.out.println(" hi");
                    ArrayList<Cordinate> arrayList = hashMap.get(slope);
                    boolean shouldInsert = true;
                    for(Cordinate cord: arrayList){
                        if(cord.x*cordinate.c == cord.c*cordinate.x){
                            //System.out.print("should not insert");
                            shouldInsert = false;
                        }
                    }
                    if(shouldInsert){
                        arrayList.add(cordinate);
                    }
                    hashMap.put(slope,arrayList);
                    //arrayList.removeAll(arrayList);
                }
            }
            for(Double key: hashMap.keySet()){
//                System.out.println(key.toString());
//                for(Cordinate e:hashMap.get(key)){
//                    System.out.println(e.x+ " "+e.y+" "+e.c);
//                }
                if(hashMap.get(key).size() > max){
                    max = hashMap.get(key).size();
                }
            }
            System.out.print(max.toString());

        }


    }
}
class Cordinate{
    public Integer x;
    public Integer y;
    public Integer c;
}
