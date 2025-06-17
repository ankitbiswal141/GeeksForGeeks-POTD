#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int minCoinsToRemove(vector<int>& arr, int k) {
    sort(arr.begin(), arr.end());  // Sort the array
    int n = arr.size();

    // Compute prefix sums for quick coin count
    vector<long long> prefixSum(n + 1, 0);
    for (int i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + arr[i];
    }

    long long result = LLONG_MAX;

    for (int i = 0; i < n; i++) {
        int start = arr[i];
        int upperBound = findUpperBound(arr, start + k);

        // Coins to remove from left of i (all coins)
        long long coinsLeft = prefixSum[i];

        // Coins to remove from right of upperBound (remove excess)
        long long coinsRight = prefixSum[n] - prefixSum[upperBound] - (n - upperBound) * (start + k);

        result = min(result, coinsLeft + coinsRight);
    }

    return result;
}

// Find index of first element > val
int findUpperBound(const vector<int>& arr, int val) {
    int l = 0, r = arr.size();
    while (l < r) {
        int mid = (l + r) / 2;
        if (arr[mid] <= val) l = mid + 1;
        else r = mid;
    }
    return l;
}

int main() {
    vector<int> arr = {1, 3, 5, 2, 7, 8};
    int k = 3;
    cout << minCoinsToRemove(arr, k) << endl;  // Example usage
    return 0;
}
