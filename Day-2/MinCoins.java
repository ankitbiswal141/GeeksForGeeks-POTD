mport java.util.*;

public class MinCoins {

    public static int minCoinsToRemove(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        // Compute prefix sums for quick coin count
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        long result = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int start = arr[i];
            int upperBound = upperBound(arr, start + k);

            // Coins to remove from left of i (all coins)
            long coinsLeft = prefixSum[i];

            // Coins to remove from right of upperBound (remove excess)
            long coinsRight = prefixSum[n] - prefixSum[upperBound] - 1L * (n - upperBound) * (start + k);

            result = Math.min(result, coinsLeft + coinsRight);
        }

        return (int) result;
    }

    // Find index of first element > val
    private static int upperBound(int[] arr, int val) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] <= val)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }