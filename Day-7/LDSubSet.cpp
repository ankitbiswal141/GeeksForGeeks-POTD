#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool isLexGreater(const vector<int>& a, const vector<int>& b) {
    int n = a.size(), m = b.size();
    for (int i = 0; i < min(n, m); i++) {
        if (a[i] != b[i]) {
            return a[i] > b[i];
        }
    }
    return n > m; // If all elements are equal, the longer list is greater
}

vector<int> largestDivisibleSubset(vector<int>& nums) {
    sort(nums.begin(), nums.end()); // Step 1: Sort the array

    int n = nums.size();
    vector<vector<int>> dp(n);
    vector<int> maxSubset;

    for (int i = 0; i < n; i++) {
        vector<int> maxList;
        for (int j = 0; j < i; j++) {
            if (nums[i] % nums[j] == 0) {
                if (dp[j].size() > maxList.size()) {
                    maxList = dp[j];
                } else if (dp[j].size() == maxList.size()) {
                    vector<int> candidate = dp[j];
                    candidate.push_back(nums[i]);
                    vector<int> current = maxList;
                    current.push_back(nums[i]);
                    if (isLexGreater(candidate, current)) {
                        maxList = dp[j];
                    }
                }
            }
        }
        dp[i] = maxList;
        dp[i].push_back(nums[i]);

        // Track the maximum subset
        if (dp[i].size() > maxSubset.size()) {
            maxSubset = dp[i];
        } else if (dp[i].size() == maxSubset.size()) {
            if (isLexGreater(dp[i], maxSubset)) {
                maxSubset = dp[i];
            }
        }
    }

    return maxSubset;
}

int main() {
    vector<int> input = {51, 7, 6, 5, 88, 4, 81, 15, 74};
    vector<int> result = largestDivisibleSubset(input);
    for (int num : result) {
        cout << num << " ";  // Expected: 5 15
    }
    cout << endl;
    return 0;
}
