import java.util.*;

/**
 * Created by praveenkumaralam on 12/24/15.
 */
public class GroupAnagrams {
    int[] primes={2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<Long,List<String>> hash = new HashMap<Long, List<String>>();
        for(String str: strs){
            long hashvalue = hashString(str);
            if(hash.containsKey(hashvalue)){
                List<String> temp = hash.get(hashvalue);
                temp.add(str);
            }
            else{
                List<String> temp = new ArrayList<String>();
                temp.add(str);
                hash.put(hashvalue, temp);
            }
        }
        for(long key:hash.keySet()){
            List<String> temp =hash.get(key);
            Collections.sort(temp);
            result.add(temp);
        }
        return result;

    }
    private long hashString(String str){
        long prod=1;
        for(char c: str.toCharArray()){
            prod*=primes[c-'a'];
        }
        return prod;
    }
    public static void main(String[] args){
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat" };
        GroupAnagrams obj = new GroupAnagrams();
        List<List<String>> lists = obj.groupAnagrams(arr);
        Iterator<List<String>> listsIter = lists.iterator();
        while(listsIter.hasNext()){
            List<String> list = listsIter.next();
            Iterator<String> listIterator = list.iterator();
            while(listIterator.hasNext()){
                String value = listIterator.next();
                System.out.print(value+" ");
            }
            System.out.println();
        }
    }
}
