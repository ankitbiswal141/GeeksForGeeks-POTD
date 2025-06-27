package main

import "fmt"

func countSequences(n int) int {
	keypad := [][]rune{
		{'1', '2', '3'},
		{'4', '5', '6'},
		{'7', '8', '9'},
		{'*', '0', '#'},
	}

	// Directions: stay, up, down, left, right
	dirs := [][]int{{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}}

	dp := [4][3][16]int{}

	// Base case: sequences of length 1
	for i := 0; i < 4; i++ {
		for j := 0; j < 3; j++ {
			if keypad[i][j] != '*' && keypad[i][j] != '#' {
				dp[i][j][1] = 1
			}
		}
	}

	// Fill dp table
	for length := 2; length <= n; length++ {
		for i := 0; i < 4; i++ {
			for j := 0; j < 3; j++ {
				if keypad[i][j] == '*' || keypad[i][j] == '#' {
					continue
				}
				for _, dir := range dirs {
					ni := i + dir[0]
					nj := j + dir[1]
					if ni >= 0 && ni < 4 && nj >= 0 && nj < 3 &&
						keypad[ni][nj] != '*' && keypad[ni][nj] != '#' {
						dp[i][j][length] += dp[ni][nj][length-1]
					}
				}
			}
		}
	}

	// Sum all sequences of length n
	total := 0
	for i := 0; i < 4; i++ {
		for j := 0; j < 3; j++ {
			if keypad[i][j] != '*' && keypad[i][j] != '#' {
				total += dp[i][j][n]
			}
		}
	}

	return total
}

func main() {
	fmt.Println("Number of sequences for n = 2:", countSequences(2)) // Output: 36
}