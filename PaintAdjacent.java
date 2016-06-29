/**
 * Created by praveenkumaralam on 10/16/15.
 */
public class PaintAdjacent {
    int[][] adj = { {1,0,1,1,0,1},
            {0,0,1,1,0,1},
            {1,0,0,0,1,0},
            {1,0,1,1,0,0}};
    public static void main(String[] args){

        int x = 2;
        int y = 3;
//        //access color at the given location
//        int height = adj.length;
//        int width = adj[0].length;
//        if( x>  height && y > width) return;
//        int oldColor = adj[x][y];
//        int newColor = 0;
//        if(oldColor == 0) newColor = 1;
//        else newColor = 0;
//        int low_row =0;
//        int high_row = 0;
//        int low_col = 0;
//        int high_col = 0;
//        low_row = x-1 >= 0 ?x-1:0;
//        low_col = y-1 >=0 ? y-1:0;
//        high_row = x+1 < height?x+1:height;
//        high_col = y+1 <width ?y+1:width;
//        int i, j;
//        for(i= low_row;i <= high_row;i++){
//            for(j=low_col;j<=high_col;j++){
//                if(adj[i][j] == oldColor) adj[i][j] = newColor;
//            }
//        }
//
//        i = 0;
//        j= 0;
//        for(i=0;i<height;i++){
//            for(j=0;j<width;j++){
//                System.out.print(Integer.toString(adj[i][j])+" ");
//            }
//            System.out.println("\n");
//        }
        //its a funny problem. wheren you click whole row and column should turn to same color
        kaboom(x,y);
    }
    private static void kaboom(int x, int y ){
        //if
    }
}
