function countSequences(n) {
  // Keypad layout
  const keypad = [
      ['1', '2', '3'],
      ['4', '5', '6'],
      ['7', '8', '9'],
      ['*', '0', '#']
  ];

  // Directions: stay, up, down, left, right
  const directions = [[0, 0], [-1, 0], [1, 0], [0, -1], [0, 1]];

  // Initialize DP table: dp[i][j][length]
  const dp = Array.from({ length: 4 }, () =>
      Array.from({ length: 3 }, () =>
          Array(n + 1).fill(0)
      )
  );

  // Base case: sequences of length 1
  for (let i = 0; i < 4; i++) {
      for (let j = 0; j < 3; j++) {
          if (keypad[i][j] !== '*' && keypad[i][j] !== '#') {
              dp[i][j][1] = 1;
          }
      }
  }

  // Fill DP table for lengths from 2 to n
  for (let len = 2; len <= n; len++) {
      for (let i = 0; i < 4; i++) {
          for (let j = 0; j < 3; j++) {
              if (keypad[i][j] === '*' || keypad[i][j] === '#') continue;

              for (const [di, dj] of directions) {
                  const ni = i + di;
                  const nj = j + dj;

                  if (
                      ni >= 0 && ni < 4 &&
                      nj >= 0 && nj < 3 &&
                      keypad[ni][nj] !== '*' &&
                      keypad[ni][nj] !== '#'
                  ) {
                      dp[i][j][len] += dp[ni][nj][len - 1];
                  }
              }
          }
      }
  }

  // Sum all sequences of length n
  let total = 0;
  for (let i = 0; i < 4; i++) {
      for (let j = 0; j < 3; j++) {
          if (keypad[i][j] !== '*' && keypad[i][j] !== '#') {
              total += dp[i][j][n];
          }
      }
  }

  return total;
}

// Example usage
console.log("Number of sequences for n = 2:", countSequences(2)); // Output: 36
console.log("Number of sequences for n = 1:", countSequences(1)); // Output: 10
console.log("Number of sequences for n = 3:", countSequences(3)); // Output: 138