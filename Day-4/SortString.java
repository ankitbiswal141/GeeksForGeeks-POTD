import java.util.*;

public class SortString {
    
    public static String sortString(String s) {
        // Separate uppercase and lowercase characters into two lists
        List<Character> uppercase = new ArrayList<>();
        List<Character> lowercase = new ArrayList<>();
        
        // Split the string into uppercase and lowercase
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                uppercase.add(c);
            } else {
                lowercase.add(c);
            }
        }
        
        // Sort both lists
        Collections.sort(uppercase);
        Collections.sort(lowercase);
        
        // Create a StringBuilder to store the result
        StringBuilder result = new StringBuilder();
        
        // Indexes to keep track of the next character in each sorted list
        int upperIndex = 0;
        int lowerIndex = 0;
        
        // Traverse the original string to maintain the case
        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                // Append the next available uppercase character
                result.append(uppercase.get(upperIndex++));
            } else {
                // Append the next available lowercase character
                result.append(lowercase.get(lowerIndex++));
            }
        }
        
        // Return the sorted string
        return result.toString();
    }

    public static void main(String[] args) {
      // Test cases here
    }
}
