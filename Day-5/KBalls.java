import java.util.*;

public class KBalls {
    public static boolean canArrange(int[] arr, int k) {
        // Step 1: Check if total number of balls is divisible by k
        if (arr.length % k != 0) return false;

        // Step 2: Count frequency of each number
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 3: Try to form groups starting from smallest number
        for (int num : countMap.keySet()) {
            int freq = countMap.get(num);
            if (freq > 0) {
                for (int i = 0; i < k; i++) {
                    int current = num + i;
                    if (countMap.getOrDefault(current, 0) < freq) {
                        return false; // Not enough to form a consecutive group
                    }
                    countMap.put(current, countMap.get(current) - freq);
                }
            }
        }

        return true;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr1 = {10, 1, 2, 11};
        int k1 = 2;
        System.out.println(canArrange(arr1, k1)); // true

        int[] arr2 = {7, 8, 9, 10, 11};
        int k2 = 2;
        System.out.println(canArrange(arr2, k2)); // false
    }
}
