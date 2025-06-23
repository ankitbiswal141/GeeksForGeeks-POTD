import java.util.Arrays;

public class MinSum {
    public static String minSum(int[] arr) {
        Arrays.sort(arr);

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        // Distribute digits alternately
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }

        // Remove leading zeros (only if length > 1)
        while (num1.length() > 1 && num1.charAt(0) == '0') {
            num1.deleteCharAt(0);
        }
        while (num2.length() > 1 && num2.charAt(0) == '0') {
            num2.deleteCharAt(0);
        }

        // Add two numbers as strings
        return addStrings(num1.toString(), num2.toString());
    }

    // Helper function to add two large numbers represented as strings
    private static String addStrings(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            carry = sum / 10;
            result.append(sum % 10);
        }

        return result.reverse().toString();
    }

    // Test example
    public static void main(String[] args) {
        int[] input = {5, 3, 0, 7, 4};
        System.out.println(minSum(input));  // Output: "82"
    }
}