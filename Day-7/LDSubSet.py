def largestDivisibleSubset(nums):
    nums.sort()  # Step 1: Sort the array

    n = len(nums)
    dp = [[] for _ in range(n)]
    max_subset = []

    for i in range(n):
        max_list = []
        for j in range(i):
            if nums[i] % nums[j] == 0:
                if len(dp[j]) > len(max_list):
                    max_list = dp[j]
                elif len(dp[j]) == len(max_list):
                    candidate = dp[j] + [nums[i]]
                    current = max_list + [nums[i]]
                    if isLexGreater(candidate, current):
                        max_list = dp[j]
        dp[i] = max_list + [nums[i]]

        # Track the maximum subset
        if len(dp[i]) > len(max_subset):
            max_subset = dp[i]
        elif len(dp[i]) == len(max_subset):
            if isLexGreater(dp[i], max_subset):
                max_subset = dp[i]

    return max_subset

def isLexGreater(a, b):
    for i in range(min(len(a), len(b))):
        if a[i] != b[i]:
            return a[i] > b[i]
    return len(a) > len(b)  # If all elements are equal, the longer list is greater

# Test
input_data = [51, 7, 6, 5, 88, 4, 81, 15, 74]
print(largestDivisibleSubset(input_data))  # Expected: [5, 15]
