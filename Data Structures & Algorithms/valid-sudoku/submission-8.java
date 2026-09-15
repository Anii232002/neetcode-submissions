class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,HashSet> row = new HashMap<>();
        HashMap<Integer,HashSet> col = new HashMap<>();
        HashMap<Integer,HashSet> matrix = new HashMap<>();
         for(int i = 0; i< 9; i++){
            col.put(i,new HashSet<Integer>());
            row.put(i,new HashSet<Integer>());
            matrix.put(i,new HashSet<Integer>());
        }

        for(int i = 0; i< 9; i++){
            for(int j = 0; j< 9; j++){
                char val = board[i][j];
                if(val == '.')continue;
                if(col.get(j).contains(val)){
                    return false;
                }
                if(row.get(i).contains(val)){
                    return false;
                }
                int idx = calculateMatrixIndex(i,j);
                if(matrix.get(idx).contains(val)){
                    return false;
                }
                col.get(j).add(val);
                row.get(i).add(val);
                matrix.get(idx).add(val);
               
            }
        }

        return true;

    }

    private int calculateMatrixIndex(int i,int j){
       return (i/3)*3 + (j/3);
    }

}
