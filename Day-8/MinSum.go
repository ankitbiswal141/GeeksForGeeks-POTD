import (
	"fmt"
	"sort"
	"strings"
)

func minSum(arr []int) string {
	sort.Ints(arr)

	var num1, num2 strings.Builder

	for i, val := range arr {
		if i%2 == 0 {
			num1.WriteString(fmt.Sprintf("%d", val))
		} else {
			num2.WriteString(fmt.Sprintf("%d", val))
		}
	}

	// Remove leading zeros
	n1 := strings.TrimLeft(num1.String(), "0")
	n2 := strings.TrimLeft(num2.String(), "0")

	if n1 == "" {
		n1 = "0"
	}
	if n2 == "" {
		n2 = "0"
	}

	// Add large numbers as strings
	return addStrings(n1, n2)
}

// Add two large numbers represented as strings
func addStrings(a, b string) string {
	i, j := len(a)-1, len(b)-1
	carry := 0
	var res strings.Builder

	for i >= 0 || j >= 0 || carry > 0 {
		sum := carry
		if i >= 0 {
			sum += int(a[i] - '0')
			i--
		}
		if j >= 0 {
			sum += int(b[j] - '0')
			j--
		}
		res.WriteByte(byte(sum%10) + '0')
		carry = sum / 10
	}

	// Reverse the result
	runes := []byte(res.String())
	for l, r := 0, len(runes)-1; l < r; l, r = l+1, r-1 {
		runes[l], runes[r] = runes[r], runes[l]
	}

	return string(runes)
}