package main

import (
	"fmt"
	"sort"
)

func largestDivisibleSubset(nums []int) []int {
	n := len(nums)
	sort.Ints(nums) // Step 1: Sort the array

	// DP table to store the largest divisible subset ending at each index
	dp := make([][]int, n)
	maxSubset := []int{}

	for i := 0; i < n; i++ {
		maxList := []int{}
		for j := 0; j < i; j++ {
			if nums[i]%nums[j] == 0 {
				if len(dp[j]) > len(maxList) {
					maxList = dp[j]
				} else if len(dp[j]) == len(maxList) {
					candidate := append([]int(nil), dp[j]...)
					candidate = append(candidate, nums[i])
					current := append([]int(nil), maxList...)
					current = append(current, nums[i])
					if isLexGreater(candidate, current) {
						maxList = dp[j]
					}
				}
			}
		}
		dp[i] = append(maxList, nums[i])

		// Track the maximum subset
		if len(dp[i]) > len(maxSubset) {
			maxSubset = dp[i]
		} else if len(dp[i]) == len(maxSubset) {
			if isLexGreater(dp[i], maxSubset) {
				maxSubset = dp[i]
			}
		}
	}

	return maxSubset
}

func isLexGreater(a, b []int) bool {
	for i := 0; i < len(a) && i < len(b); i++ {
		if a[i] != b[i] {
			return a[i] > b[i]
		}
	}
	return len(a) > len(b) // If all elements are equal, the longer list is greater
}

func main() {
	input := []int{51, 7, 6, 5, 88, 4, 81, 15, 74}
	result := largestDivisibleSubset(input)
	fmt.Println(result) // Expected: [5, 15]
}
