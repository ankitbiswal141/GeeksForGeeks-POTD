#include <bits/stdc++.h>
using namespace std;

// Function to add two large numbers represented as strings
string addStrings(string a, string b) {
    int i = a.size() - 1, j = b.size() - 1;
    int carry = 0;
    string result;

    while (i >= 0 || j >= 0 || carry > 0) {
        int sum = carry;
        if (i >= 0)
            sum += a[i--] - '0';
        if (j >= 0)
            sum += b[j--] - '0';
        carry = sum / 10;
        result.push_back(sum % 10 + '0');
    }

    reverse(result.begin(), result.end());
    return result;
}

string minSum(vector<int>& arr) {
    // Step 1: Sort the digits in ascending order
    sort(arr.begin(), arr.end());

    string num1, num2;

    // Step 2: Distribute digits alternately
    for (int i = 0; i < arr.size(); ++i) {
        if (i % 2 == 0)
            num1 += to_string(arr[i]);
        else
            num2 += to_string(arr[i]);
    }

    // Step 3: Remove leading zeros (but keep at least one '0' if needed)
    if (num1.size() > 1)
        num1.erase(0, min(num1.find_first_not_of('0'), num1.size() - 1));
    if (num2.size() > 1)
        num2.erase(0, min(num2.find_first_not_of('0'), num2.size() - 1));

    // Handle all-zero cases
    if (num1.empty()) num1 = "0";
    if (num2.empty()) num2 = "0";

    // Step 4: Add the two numbers as strings
    return addStrings(num1, num2);
}

// Example usage
int main() {
    vector<int> arr = {5, 3, 0, 7, 4};
    cout << minSum(arr) << endl; // Output: "82"
    return 0;
}