public class MobileKeypadDP {

    // Directions: stay, left, right, up, down
    private static final int[][] DIRS = {{0, 0}, {0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    
    public static int countSequences(int n) {
        // Keypad layout
        char[][] keypad = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'},
            {'*', '0', '#'}
        };

        // dp[i][j][k] = number of sequences of length k ending at (i,j)
        int[][][] dp = new int[4][3][n + 1];

        // Base case: sequences of length 1
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                    dp[i][j][1] = 1;
                }
            }
        }

        // Fill dp for lengths from 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (keypad[i][j] == '*' || keypad[i][j] == '#') continue;

                    // Try all 5 directions
                    for (int[] dir : DIRS) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];

                        if (ni >= 0 && ni < 4 && nj >= 0 && nj < 3 &&
                            keypad[ni][nj] != '*' && keypad[ni][nj] != '#') {
                            dp[i][j][len] += dp[ni][nj][len - 1];
                        }
                    }
                }
            }
        }

        // Sum all sequences of length n starting from any valid key
        int total = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                    total += dp[i][j][n];
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println("Number of sequences of length " + n + ": " + countSequences(n));
    }
}