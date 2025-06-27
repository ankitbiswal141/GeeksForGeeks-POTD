#include <iostream>
#include <vector>

using namespace std;

int countSequences(int n) {
    // Keypad layout
    char keypad[4][3] = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'},
        {'*', '0', '#'}
    };

    // Directions: stay, up, down, left, right
    int dirs[5][2] = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Initialize dp table
    int dp[4][3][16] = {0};

    // Base case: sequences of length 1
    for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 3; ++j) {
            if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                dp[i][j][1] = 1;
            }
        }
    }

    // Fill dp table
    for (int len = 2; len <= n; ++len) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (keypad[i][j] == '*' || keypad[i][j] == '#') continue;

                for (int d = 0; d < 5; ++d) {
                    int ni = i + dirs[d][0];
                    int nj = j + dirs[d][1];

                    if (ni >= 0 && ni < 4 && nj >= 0 && nj < 3 &&
                        keypad[ni][nj] != '*' && keypad[ni][nj] != '#') {
                        dp[i][j][len] += dp[ni][nj][len - 1];
                    }
                }
            }
        }
    }

    // Sum all valid sequences of length n
    int total = 0;
    for (int i = 0; i < 4; ++i) {
        for (int j = 0; j < 3; ++j) {
            if (keypad[i][j] != '*' && keypad[i][j] != '#') {
                total += dp[i][j][n];
            }
        }
    }

    return total;
}

int main() {
    int n = 2;
    cout << "Number of sequences for n = " << n << ": " << countSequences(n) <<endl;
    return 0;
}
