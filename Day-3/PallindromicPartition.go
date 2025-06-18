package main

import (
	"fmt"
)

func isPalindrome(s string) bool {
	left, right := 0, len(s)-1
	for left < right {
		if s[left] != s[right] {
			return false
		}
		left++
		right--
	}
	return true
}

func partitionHelper(s string, start int, temp []string, result *[][]string) {
	if start == len(s) {
		// Append a copy of temp to result
		*result = append(*result, append([]string(nil), temp...))
		return
	}

	for i := start + 1; i <= len(s); i++ {
		substr := s[start:i]
		if isPalindrome(substr) {
			temp = append(temp, substr)
			partitionHelper(s, i, temp, result)
			temp = temp[:len(temp)-1] // backtrack
		}
	}
}

func partition(s string) [][]string {
	var result [][]string
	partitionHelper(s, 0, []string{}, &result)
	return result
}

func main() {
	// Test cases
}