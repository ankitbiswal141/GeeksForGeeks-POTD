#include <iostream>
#include <vector>
#include <cmath>
#include <string>

using namespace std;

int maxThievesCaught(const string& arr, int k) {
    vector<int> police, thieves;

    // Step 1: Store positions of all police and thieves
    for (int i = 0; i < arr.size(); ++i) {
        if (arr[i] == 'P')
            police.push_back(i);
        else if (arr[i] == 'T')
            thieves.push_back(i);
    }

    int i = 0, j = 0, caught = 0;

    // Step 2: Greedy matching using two pointers
    while (i < police.size() && j < thieves.size()) {
        int p = police[i];
        int t = thieves[j];

        if (abs(p - t) <= k) {
            // Policeman catches the thief
            caught++;
            i++;
            j++;
        } else if (p < t) {
            // Policeman is behind thief
            i++;
        } else {
            // Thief is behind policeman
            j++;
        }
    }

    return caught;
}

// 🔍 Example Usage
int main() {
    string arr1 = "P T T P T"; arr1.erase(remove(arr1.begin(), arr1.end(), ' '), arr1.end());
    int k1 = 1;
    cout << "Example 1: " << maxThievesCaught(arr1, k1) << " thieves caught\n"; // Output: 2

    string arr2 = "T T P P T P"; arr2.erase(remove(arr2.begin(), arr2.end(), ' '), arr2.end());
    int k2 = 2;
    cout << "Example 2: " << maxThievesCaught(arr2, k2) << " thieves caught\n"; // Output: 3

    return 0;
}