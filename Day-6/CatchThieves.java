import java.util.*;

public class CatchThieves {
    public static int maxThievesCaught(char[] arr, int k) {
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();

        // Step 1: Store indices of police and thieves
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') {
                police.add(i);
            } else {
                thieves.add(i);
            }
        }

        int i = 0, j = 0, caught = 0;

        // Step 2: Greedily match police and thieves
        while (i < police.size() && j < thieves.size()) {
            int pPos = police.get(i);
            int tPos = thieves.get(j);

            // If thief is within range of policeman
            if (Math.abs(pPos - tPos) <= k) {
                caught++;  // Catch the thief
                i++;
                j++;
            } else if (pPos < tPos) {
                i++;  // Policeman can't catch this or future thieves
            } else {
                j++;  // Thief is behind the policeman, move thief pointer
            }
        }

        return caught;
    }

    // Example usage
    public static void main(String[] args) {
        char[] arr1 = {'P', 'T', 'T', 'P', 'T'};
        System.out.println(maxThievesCaught(arr1, 1)); // Output: 2

        char[] arr2 = {'T', 'T', 'P', 'P', 'T', 'P'};
        System.out.println(maxThievesCaught(arr2, 2)); // Output: 3
    }
}