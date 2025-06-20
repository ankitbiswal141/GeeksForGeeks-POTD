#include <iostream>
#include <vector>
#include <map>
#include <algorithm>

bool canArrange(std::vector<int>& arr, int k) {
    if (arr.size() % k != 0) return false;

    std::map<int, int> count;
    for (int num : arr) {
        count[num]++;
    }

    for (auto& [num, freq] : count) {
        if (freq > 0) {
            for (int i = 0; i < k; i++) {
                int current = num + i;
                if (count[current] < freq) {
                    return false;
                }
                count[current] -= freq;
            }
        }
    }

    return true;
}

int main() {
    // Test cases here
    return 0;
}
