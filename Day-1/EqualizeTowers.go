package main

import (
    "fmt"
    "math"
)

func minCost(heights []int, cost []int) int64 {
    getTotalCost := func(target int) int64 {
        var total int64
        for i := range heights {
            total += int64(abs(heights[i]-target)) * int64(cost[i])
        }
        return total
    }

    minH, maxH := heights[0], heights[0]
    for _, h := range heights {
        if h < minH {
            minH = h
        }
        if h > maxH {
            maxH = h
        }
    }

    var result int64 = math.MaxInt64
    for minH <= maxH {
        mid := (minH + maxH) / 2
        cost1 := getTotalCost(mid)
        cost2 := getTotalCost(mid + 1)
        if cost1 < cost2 {
            result = min(result, cost1)
            maxH = mid - 1
        } else {
            result = min(result, cost2)
            minH = mid + 1
        }
    }
    return result
}

func abs(x int) int {
    if x < 0 {
        return -x
    }
    return x
}

func min(a, b int64) int64 {
    if a < b {
        return a
    }
    return b
}

func main() {
	// Write your test case here
}
