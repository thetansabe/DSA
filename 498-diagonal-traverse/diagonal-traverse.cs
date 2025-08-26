public class Solution {
    public int[] FindDiagonalOrder(int[][] mat) {
        if (mat.Length == 0) return new int[0];

        int rows = mat.Length;
        int cols = mat[0].Length;
        int[] res = new int[rows * cols];

        int r = 0, c = 0;
        for (int i = 0; i < res.Length; i++) {
            res[i] = mat[r][c];

            // Determine the direction of traversal
            if ((r + c) % 2 == 0) { // Going up
                if (c == cols - 1) { // Hit the upper bound
                    r++; // Move down
                } else if (r == 0) { // Hit the left bound
                    c++; // Move right
                } else { // Move diagonally up
                    r--;
                    c++;
                }
            } else { // Going down
                if (r == rows - 1) { // Hit the lower bound
                    c++; // Move right
                } else if (c == 0) { // Hit the upper bound
                    r++; // Move down
                } else { // Move diagonally down
                    r++;
                    c--;
                }
            }
        }
        
        return res;
    }
}