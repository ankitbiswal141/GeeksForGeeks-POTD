package main

import (
	"fmt"
	"math"
)

func maxThievesCaught(arr []rune, k int) int {
	var police, thieves []int

	// Store positions of police and thieves
	for i, ch := range arr {
		if ch == 'P' {
			police = append(police, i)
		} else {
			thieves = append(thieves, i)
		}
	}

	i, j, caught := 0, 0, 0

	// Greedy matching
	for i < len(police) && j < len(thieves) {
		p := police[i]
		t := thieves[j]

		if math.Abs(float64(p-t)) <= float64(k) {
			caught++
			i++
			j++
		} else if p < t {
			i++
		} else {
			j++
		}
	}

	return caught
}

func main() {
	arr := []rune{'P', 'T', 'T', 'P', 'T'}
	k := 1
	fmt.Println("Maximum thieves caught:", maxThievesCaught(arr, k)) // Output: 2
}