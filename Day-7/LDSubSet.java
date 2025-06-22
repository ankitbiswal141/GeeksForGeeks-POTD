class LDSubSet {
    
    private static boolean isLexGreater(ArrayList<Integer> a, ArrayList<Integer> b) {
        int n = a.size(), m = b.size();
        for (int i = 0; i < Math.min(n, m); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) > b.get(i);
            }
        }
        return n > m;  // If all elements are equal, the longer list is greater
    }
    
    public ArrayList<Integer> largestSubset(int[] nums) {
        // code here
        int n = nums.length;
        Arrays.sort(nums);  // Step 1: Sort the array

        // DP table to store the largest divisible subset ending at each index
        List<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dp.add(new ArrayList<>());
        }

        ArrayList<Integer> maxSubset = new ArrayList<>();

        // Step 2: Build the dp table and track the largest subsets
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> maxList = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp.get(j).size() > maxList.size()) {
                        maxList = dp.get(j);
                    } else if (dp.get(j).size() == maxList.size()) {
                        ArrayList<Integer> candidate = new ArrayList<>(dp.get(j));
                        candidate.add(nums[i]);
                        ArrayList<Integer> current = new ArrayList<>(maxList);
                        current.add(nums[i]);
                        if (isLexGreater(candidate, current)) {
                            maxList = dp.get(j);
                        }
                    }
                }
            }
            dp.get(i).addAll(maxList);
            dp.get(i).add(nums[i]);

            // Track the maximum subset
            if (dp.get(i).size() > maxSubset.size()) {
                maxSubset = dp.get(i);
            } else if (dp.get(i).size() == maxSubset.size()) {
                if (isLexGreater(dp.get(i), maxSubset)) {
                    maxSubset = dp.get(i);
                }
            }
        }

        return maxSubset;
    }
}