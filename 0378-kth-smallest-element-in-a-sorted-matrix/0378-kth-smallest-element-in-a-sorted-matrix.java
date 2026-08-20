class Solution {

    public int kthSmallest(int[][] matrix, int k) {

        int n = matrix.length;
        int m = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[n - 1][m - 1];

        while(low < high){

            int guess = low + (high - low) / 2;

            int ans = helpsme(matrix, n, m, guess);

            if(ans < k){
                low = guess + 1;
            }
            else{
                high = guess;
            }
        }

        return low;
    }

    int helpsme(int[][] matrix, int n, int m, int guess){

        int row = n - 1;
        int col = 0;
        int count = 0;

        while(row >= 0 && col < m){

            if(matrix[row][col] <= guess){
                count += row + 1;
                col++;
            }
            else{
                row--;
            }
        }

        return count;
    }
}