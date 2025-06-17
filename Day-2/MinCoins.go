package main

import (
	"fmt"
	"sort"
)

func minCoinsToRemove(arr []int, k int) int {
	sort.Ints(arr) // Sort the array
	n := len(arr)

	// Compute prefix sums for quick coin count
	prefixSum := make([]int, n+1)
	for i := 0; i < n; i++ {
		prefixSum[i+1] = prefixSum[i] + arr[i]
	}

	result := int(1e9) // A large number to minimize

	for i := 0; i < n; i++ {
		start := arr[i]
		upperBound := findUpperBound(arr, start+k)

		// Coins to remove from left of i (all coins)
		coinsLeft := prefixSum[i]

		// Coins to remove from right of upperBound (remove excess)
		coinsRight := prefixSum[n] - prefixSum[upperBound] - (n-upperBound)*(start+k)

		result = min(result, coinsLeft+coinsRight)
	}

	return result
}

// Find index of first element > val
func findUpperBound(arr []int, val int) int {
	l, r := 0, len(arr)
	for l < r {
		mid := (l + r) / 2
		if arr[mid] <= val {
			l = mid + 1
		} else {
			r = mid
		}
	}
	return l
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func main() {
	arr := []int{1, 3, 5, 2, 7, 8}
	k := 3
	fmt.Println(minCoinsToRemove(arr, k)) // Example usage
}
