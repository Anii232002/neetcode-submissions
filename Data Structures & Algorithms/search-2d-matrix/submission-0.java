class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean found = false;
        for(int i = 0; i< matrix.length; i++){
            if(target <= matrix[i][matrix[i].length-1] && target >= matrix[i][0])
            {
                return find(matrix[i],target);
            }
        }
        return false;
    }

    public boolean find(int[] arr, int target){
        int i = 0;
        int j = arr.length-1;
        while(i<=j){
            int mid = i + ((j-i)/2);
            if(arr[mid] == target)return true;
            if(arr[mid] > target)j = mid-1;
            else i = mid+1;
        }
        return false;
    }
}
