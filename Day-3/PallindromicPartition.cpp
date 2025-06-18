#include <iostream>
#include <vector>
#include <string>

using namespace std;

bool isPalindrome(const string& s) {
    int left = 0, right = s.length() - 1;
    while (left < right) {
        if (s[left] != s[right]) return false;
        left++;
        right--;
    }
    return true;
}

void backtrack(const string& s, int start, vector<string>& temp, vector<vector<string>>& result) {
    if (start == s.length()) {
        result.push_back(temp);
        return;
    }

    for (int i = start + 1; i <= s.length(); i++) {
        string substr = s.substr(start, i - start);
        if (isPalindrome(substr)) {
            temp.push_back(substr);
            backtrack(s, i, temp, result);
            temp.pop_back(); // Backtrack
        }
    }
}

vector<vector<string>> partition(string s) {
    vector<vector<string>> result;
    vector<string> temp;
    backtrack(s, 0, temp, result);
    return result;
}

int main() {
    // Test cases
    string s1 = "geeks";
    string s2 = "abcba";
    
    auto result1 = partition(s1);
    auto result2 = partition(s2);

    for (const auto& partition : result1) {
        for (const auto& word : partition) {
            cout << word << " ";
        }
        cout << endl;
    }

    for (const auto& partition : result2) {
        for (const auto& word : partition) {
            cout << word << " ";
        }
        cout << endl;
    }

    return 0;
}
