function canArrange(arr, k) {
  if (arr.length % k !== 0) return false;

  const count = {};
  for (let num of arr) {
      count[num] = (count[num] || 0) + 1;
  }

  const keys = Object.keys(count).map(Number).sort((a, b) => a - b);

  for (let num of keys) {
      let freq = count[num];
      if (freq > 0) {
          for (let i = 0; i < k; i++) {
              let current = num + i;
              if (!count[current] || count[current] < freq) {
                  return false;
              }
              count[current] -= freq;
          }
      }
  }

  return true;
}

// Test cases here