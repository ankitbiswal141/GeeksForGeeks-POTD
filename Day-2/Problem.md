## Remove Minimum Coins to Make Absolute Difference at Most K

[00:05, 18/06/2025] AB: You are given an array arr[] of integers, where each element represents the number of coins in a pile. You are also given an integer k.
Your task is to remove the minimum number of coins such that the absolute difference between the number of coins in any two updated piles is at most k.

Note: You can also remove a pile by removing all the coins of that pile.

### Examples:

 * 1: Input: arr[] = [2, 2, 2, 2], k = 0
     Output: 0
     Explanation: For any two piles the difference in the number of coins is <= 0. So no need to remove any coin. 
 * 2: Input: arr[] = [1, 5, 1, 2, 5, 1], k = 3
     Output: 2
     Explanation: If we remove one coin each from both the piles containing 5 coins, then for any two piles the absolute difference in the number of coins is <= 3. 


#### Constraints:
 -> 1 ≤ arr.size() ≤ 105
 -> 1 ≤ arr[i] ≤ 104
 -> 0 ≤ k ≤ 104
 -> [00:06, 18/06/2025] AB: 