function minCoinsToRemove(arr, k) {
  arr.sort((a, b) => a - b); // Sort the array
  const n = arr.length;

  // Compute prefix sums for quick coin count
  let prefixSum = Array(n + 1).fill(0);
  for (let i = 0; i < n; i++) {
      prefixSum[i + 1] = prefixSum[i] + arr[i];
  }

  let result = Number.MAX_SAFE_INTEGER;

  for (let i = 0; i < n; i++) {
      const start = arr[i];
      const upperBound = findUpperBound(arr, start + k);

      // Coins to remove from left of i (all coins)
      let coinsLeft = prefixSum[i];

      // Coins to remove from right of upperBound (remove excess)
      let coinsRight = prefixSum[n] - prefixSum[upperBound] - (n - upperBound) * (start + k);

      result = Math.min(result, coinsLeft + coinsRight);
  }

  return result;
}

// Find index of first element > val
function findUpperBound(arr, val) {
  let l = 0, r = arr.length;
  while (l < r) {
      let mid = Math.floor((l + r) / 2);
      if (arr[mid] <= val) l = mid + 1;
      else r = mid;
  }
  return l;
}
