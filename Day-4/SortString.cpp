#include <iostream>
#include <vector>
#include <algorithm>
#include <cctype>

using namespace std;

string sortString(string s) {
    // Separate uppercase and lowercase characters
    vector<char> upper, lower;

    for (char c : s) {
        if (isupper(c)) {
            upper.push_back(c);
        } else {
            lower.push_back(c);
        }
    }

    // Sort both arrays
    sort(upper.begin(), upper.end());
    sort(lower.begin(), lower.end());

    // Rebuild the string by placing characters back in the original order
    string result = "";
    int upperIndex = 0, lowerIndex = 0;
    for (char c : s) {
        if (isupper(c)) {
            result += upper[upperIndex++];
        } else {
            result += lower[lowerIndex++];
        }
    }

    return result;
}

int main() {
    // Test cases here
    return 0;
}
