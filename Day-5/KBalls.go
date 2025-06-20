package main

import (
	"fmt"
	"sort"
)

func canArrange(arr []int, k int) bool {
	if len(arr)%k != 0 {
		return false
	}

	count := make(map[int]int)
	for _, num := range arr {
		count[num]++
	}

	// Get sorted keys
	keys := []int{}
	for key := range count {
		keys = append(keys, key)
	}
	sort.Ints(keys)

	for _, num := range keys {
		freq := count[num]
		if freq > 0 {
			for i := 0; i < k; i++ {
				current := num + i
				if count[current] < freq {
					return false
				}
				count[current] -= freq
			}
		}
	}

	return true
}

func main() {
	// Test cases
}
