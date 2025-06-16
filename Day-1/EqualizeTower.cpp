#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>
#include <climits>
using namespace std;

long long getTotalCost(const vector<int>& heights, const vector<int>& cost, int target) {
    long long total = 0;
    for (size_t i = 0; i < heights.size(); ++i) {
        total += (long long)abs(heights[i] - target) * cost[i];
    }
    return total;
}

long long minCost(const vector<int>& heights, const vector<int>& cost) {
    int low = *min_element(heights.begin(), heights.end());
    int high = *max_element(heights.begin(), heights.end());
    long long result = LLONG_MAX;

    while (low <= high) {
        int mid = (low + high) / 2;
        long long cost1 = getTotalCost(heights, cost, mid);
        long long cost2 = getTotalCost(heights, cost, mid + 1);
        result = min({result, cost1, cost2});

        if (cost1 < cost2)
            high = mid - 1;
        else
            low = mid + 1;
    }

    return result;
}

int main() {
  // Write your test case here

  return 0;
}
