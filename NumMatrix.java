public class NumMatrix {
    Integer[][] _matrix;
    public NumMatrix(int[][] matrix) {
        if(matrix == null) return;
        if(matrix.length == 0) return;
        Integer rows = matrix.length;
        Integer cols = matrix[0].length;
        _matrix = new Integer[rows][cols];

        int i,j;

        _matrix[0][0] = matrix[0][0];
        for(i=1;i<rows;i++){
            _matrix[i][0] = _matrix[i-1][0]+matrix[i][0];
        }
        for(j=1;j<cols;j++){
            _matrix[j][0] = _matrix[0][j-1]+matrix[0][j];
        }
        for(i=1;i<rows;i++){
            for(j=1;j<cols;j++){
                _matrix[i][j] +=_matrix[i-1][j-1]+matrix[i][j-1]+matrix[i-1][j];
            }
        }
    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return _matrix[row2][col2];

    }
    public static void main(String[] args){
        int[][] matrix ={ {3,0,1,4,2},
                                {5,6,3,2,1},
                                {1,2,0,1,5},
                                {4,1,0,1,7},
                                {1,0,3,0,5}};
        NumMatrix Obj = new NumMatrix(matrix);
        System.out.println(" Sum range 2,2"+ Integer.toString(Obj.sumRegion(2,2,0,0)));
    }
}