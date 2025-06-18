import java.util.*;

class PallindromicPartition {
    
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    private void backtrack(String s, int start, ArrayList<String> temp, ArrayList<ArrayList<String>> result) {
        // If we've reached the end of the string, add the current partition to result
        if (start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }

        // Try every possible partition starting from index 'start'
        for (int i = start + 1; i <= s.length(); i++) {
            String substring = s.substring(start, i);
            // If the substring is a palindrome, add it to the current partition
            if (isPalindrome(substring)) {
                temp.add(substring);
                backtrack(s, i, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        backtrack(s, 0, temp, result);
        return result;
    }
}
