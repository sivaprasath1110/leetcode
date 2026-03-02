class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailing = new int[n];
        
        // Step 1: count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailing[i] = count;
        }
        
        int swaps = 0;
        
        // Step 2: greedy placement
        for (int i = 0; i < n; i++) {
            int needed = n - i - 1;
            int j = i;
            
            // find suitable row
            while (j < n && trailing[j] < needed) {
                j++;
            }
            
            if (j == n) return -1; // not possible
            
            // bring row j to position i using swaps
            while (j > i) {
                int temp = trailing[j];
                trailing[j] = trailing[j - 1];
                trailing[j - 1] = temp;
                j--;
                swaps++;
            }
        }
        
        return swaps;
    }
}