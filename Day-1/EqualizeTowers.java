class EqualizeTowers {
    
    private static int getTotalCost(int[] heights, int[] cost, int targetHeight) {
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += (int) Math.abs(heights[i] - targetHeight) * cost[i];
        }
        return total;
    }
    
    public int minCost(int[] heights, int[] cost) {
        // code here
        int n = heights.length;

        // Find min and max height
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        for (int h : heights) {
            minHeight = Math.min(minHeight, h);
            maxHeight = Math.max(maxHeight, h);
        }

        // Apply Binary Search over the height array
        int result = Integer.MAX_VALUE;
        while (minHeight <= maxHeight) {
            int mid = (minHeight + maxHeight) / 2;
            int cost1 = getTotalCost(heights, cost, mid);
            int cost2 = getTotalCost(heights, cost, mid + 1);

            result = Math.min(cost1, cost2);

            if (cost1 < cost2) {
                maxHeight = mid - 1;
            } else {
                minHeight = mid + 1;
            }
        }

        return result;
    }
}
