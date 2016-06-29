import java.util.ArrayList;

/**
 * Created by praveenkumaralam on 8/13/15.
 */
public class DungeonGame {
    public static void main(String[] args) {
        int[][] dungeonGrid = new int[][]{{100}};
        int height = dungeonGrid.length;
        int width = dungeonGrid[0].length;
        // take the greedy approach, here we care only local optimum. we need maximum of the negatives, minimum of positives.
        int currentBestSum = 0;
        int i = height -1;
        int j = width -1;
        int[][] health = new int[height][width];
        //health[height -1][width -1] = max(dungeonGrid[height-1][width-1],1);
        for(i = height -1;i>=0;i--){
            for(j = width -1; j>=0;j--){
                if( i == height -1 && j == width -1){
                    health[i][j] =  max(1-dungeonGrid[i][j],1);
                }
                else{
                    if(j ==width -1){
                        //this i,j could have influenced only i+1,j
                        health[i][j] = max(health[i+1][j] -dungeonGrid[i][j], 1);
                    }
                    else if(i ==height -1){
                        health[i][j] = max(health[i][j+1] - dungeonGrid[i][j], 1);
                    }
                    else{
                        int right = max(health[i][j+1] - dungeonGrid[i][j],1);
                        int down = max(health[i+1][j] - dungeonGrid[i][j],1);
                        // find minimum of these two. It is the health at this place
                        health[i][j] = min(right, down);
                    }
                }
            }
        }
//        if( health[0][0] < 0){
//            health[0][0] = 1- health[0][0];
//        }
//        else{
//            health[0][0] =1;
//        }
        for(i=0;i<height;i++){
            for(j=0;j<width;j++){
                System.out.print((new Integer(health[i][j])).toString() + " ");
            }
            System.out.println(" ");
        }
    }
    public static int min(int a, int b){
        if(a>b){
            return b;
        }
        else{
            return a;
        }
    }
    public static int max(int a, int b){
        if(a > b) return a;
        else return b;
    }
}
