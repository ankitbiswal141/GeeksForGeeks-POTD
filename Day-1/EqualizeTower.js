function minCost(heights, cost) {
  const getTotalCost = (target) => {
      let total = 0;
      for (let i = 0; i < heights.length; i++) {
          total += Math.abs(heights[i] - target) * cost[i];
      }
      return total;
  };

  let low = Math.min(...heights);
  let high = Math.max(...heights);
  let result = Infinity;

  while (low <= high) {
      const mid = Math.floor((low + high) / 2);
      const cost1 = getTotalCost(mid);
      const cost2 = getTotalCost(mid + 1);
      result = Math.min(result, cost1, cost2);

      if (cost1 < cost2) {
          high = mid - 1;
      } else {
          low = mid + 1;
      }
  }

  return result;
}