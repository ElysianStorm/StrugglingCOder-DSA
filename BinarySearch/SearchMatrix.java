package BinarySearch;

class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = matrix[0].length-1;
        int low = 0;
        int high = row;
        
        while(low<high){
            int mid = low + (high-low)/2;
            if(target == matrix[mid][0]){
                return true;
            }
            else if(target < matrix[mid][0]){
                high = mid-1;
            }
            else if(target > matrix[mid][col]){
                low = mid+1;
            }
            else if(target >= matrix[mid][0] && target <= matrix[mid][col]){
                low = mid;
                high = mid;
            }
            else{
                return false;
            }
        }

        return binarySearch(matrix, low, target);
    }

    public boolean binarySearch(int[][] matrix, int row, int target){
        int low = 0;
        int high = matrix[row].length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target == matrix[row][mid]){
                return true;
            }
            else if(target < matrix[row][mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}