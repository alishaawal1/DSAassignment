package Question8;

//Given 2D matrix of 1 and 0s. Using stack, find maximum area of square made by 0s.
//        INPUT: 1 0 1 0 0
//        0 1 1 1 1
//        0 0 0 0 1
//        0 0 0 1 1
//        0 1 0 1 1
//        OUTPUT: 4

public class TwoDMatrix {
    public static int TwoDMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int maxArea = 0;

        // Initialize the first row of dp matrix
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j] == 0 ? 1 : 0;
            maxArea = Math.max(maxArea, dp[0][j]);
        }

        // Initialize the first column of dp matrix
        for (int i = 0; i < n; i++) {
            dp[i][0] = matrix[i][0] == 0 ? 1 : 0;
            maxArea = Math.max(maxArea, dp[i][0]);
        }

        // Fill the remaining entries of dp matrix
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxArea = Math.max(maxArea, dp[i][j] * dp[i][j]);
                }
            }
        }

        return maxArea;
    }



    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 1, 0, 1, 1},
                {0, 1, 0, 1, 1},
        };
        System.out.println(TwoDMatrix(matrix));
    }

}