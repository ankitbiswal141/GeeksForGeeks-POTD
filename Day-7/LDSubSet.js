function largestDivisibleSubset(nums) {
  nums.sort((a, b) => a - b); // Step 1: Sort the array

  let dp = new Array(nums.length).fill().map(() => []);
  let maxSubset = [];

  for (let i = 0; i < nums.length; i++) {
      let maxList = [];
      for (let j = 0; j < i; j++) {
          if (nums[i] % nums[j] === 0) {
              if (dp[j].length > maxList.length) {
                  maxList = dp[j];
              } else if (dp[j].length === maxList.length) {
                  let candidate = [...dp[j], nums[i]];
                  let current = [...maxList, nums[i]];
                  if (isLexGreater(candidate, current)) {
                      maxList = dp[j];
                  }
              }
          }
      }
      dp[i] = [...maxList, nums[i]];

      // Track the maximum subset
      if (dp[i].length > maxSubset.length) {
          maxSubset = dp[i];
      } else if (dp[i].length === maxSubset.length) {
          if (isLexGreater(dp[i], maxSubset)) {
              maxSubset = dp[i];
          }
      }
  }

  return maxSubset;
}

function isLexGreater(a, b) {
  for (let i = 0; i < Math.min(a.length, b.length); i++) {
      if (a[i] !== b[i]) {
          return a[i] > b[i];
      }
  }
  return a.length > b.length; // If all elements are equal, the longer list is greater
}

let input = [51, 7, 6, 5, 88, 4, 81, 15, 74];
console.log(largestDivisibleSubset(input)); // Expected: [5, 15]
