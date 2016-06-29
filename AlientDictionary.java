import java.util.*;

/**
 * Created by praveenkumaralam on 10/12/15.
 */
public class AlientDictionary {
    public static void main(String[] args){
        String[] words = {"aac","aabb","aabaa"};
        //create a dependency pairs (b,a) means be occurs after a
        //find total number of independent characters

        int[] alphabets = new int[26];
        int numOfWords = words.length;
        int i;
        int j;
        int alphabetCount = 0;
        // num of chars
        for(i=0;i<numOfWords;i++){
            for(j=0;j<words[i].length();j++){
                alphabets[words[i].charAt(j) - 'a'] =1;
            }

        }
        for(i=0;i<26;i++){
            if(alphabets[i] ==1 ){
                alphabetCount++;
            }
        }

        System.out.println(Integer.toString(alphabetCount));
        int[][] depMatrix = new int[alphabetCount][alphabetCount];
        int[][] adjMatrix = new int[alphabetCount][alphabetCount];
        for(i=0;i<numOfWords-1;i++){
            //create tuples of dependency between two words
            for(j=0;j< words[i].length() && j <words[i+1].length();j++){
                if(words[i].charAt(j) != words[i+1].charAt(j)){
                    adjMatrix[words[i].charAt(j)-'a'][words[i+1].charAt(j)]  = 1;
                    depMatrix[words[i+1].charAt(j) - 'a'][words[i].charAt(j)- 'a'] =1;
                }
            }
        }
        for(i=0;i<alphabetCount;i++){
            for(j=0;j<alphabetCount;j++){
                if(depMatrix[i][j] !=0){
                    System.out.print((char)('a'+i)+" ");
                    System.out.println((char)('a'+j));
                }
            }
        }
        //we have dependency matrix. perform topological sort

        //find one letter that has no dependency. that is first
        int firstChar = -1;
        for(i=0;i<alphabetCount;i++){
            boolean flag = true;
            for(j=0;j<alphabetCount;j++){
                if(depMatrix[i][j] == 1){
                    flag = false;
                }
            }
            if(flag){
                System.out.println((char)(i+'a'));
                firstChar = i;
                break;
            }
        }
        ArrayList<Integer> visited = new ArrayList<Integer>();
        Deque<Integer> queue = new ArrayDeque<>();
        if(firstChar <0) return;
        queue.add(firstChar);
        while (!queue.isEmpty()){
            boolean flag = false;
            int node = queue.getFirst();
            //find its dependencies
            for(j =0;j<alphabetCount;j++){
                if(depMatrix[node][j] == 1){
                    if(!visited.contains(j)){
                        flag = false;
                    }
                }
            }
        }
    }
}
