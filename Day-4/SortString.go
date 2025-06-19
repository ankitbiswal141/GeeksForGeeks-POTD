package main

import (
	"fmt"
	"sort"
	"unicode"
)

func sortString(s string) string {
	// Separate uppercase and lowercase characters
	upper := []rune{}
	lower := []rune{}
	
	for _, c := range s {
		if unicode.IsUpper(c) {
			upper = append(upper, c)
		} else {
			lower = append(lower, c)
		}
	}

	// Sort both arrays
	sort.Slice(upper, func(i, j int) bool { return upper[i] < upper[j] })
	sort.Slice(lower, func(i, j int) bool { return lower[i] < lower[j] })

	// Rebuild the string by placing characters back in the original order
	result := []rune{}
	upperIndex, lowerIndex := 0, 0
	for _, c := range s {
		if unicode.IsUpper(c) {
			result = append(result, upper[upperIndex])
			upperIndex++
		} else {
			result = append(result, lower[lowerIndex])
			lowerIndex++
		}
	}

	return string(result)
}

func main() {
	// Test cases here
}
