def min_coins_to_remove(arr, k):
    arr.sort()  # Sort the array
    n = len(arr)

    # Compute prefix sums for quick coin count
    prefix_sum = [0] * (n + 1)
    for i in range(n):
        prefix_sum[i + 1] = prefix_sum[i] + arr[i]

    result = float('inf')

    for i in range(n):
        start = arr[i]
        upper_bound = find_upper_bound(arr, start + k)

        # Coins to remove from left of i (all coins)
        coins_left = prefix_sum[i]

        # Coins to remove from right of upper_bound (remove excess)
        coins_right = prefix_sum[n] - prefix_sum[upper_bound] - (n - upper_bound) * (start + k)

        result = min(result, coins_left + coins_right)

    return result

# Find index of first element > val
def find_upper_bound(arr, val):
    l, r = 0, len(arr)
    while l < r:
        mid = (l + r) // 2
        if arr[mid] <= val:
            l = mid + 1
        else:
            r = mid
    return l

# Example usage
arr = [1, 3, 5, 2, 7, 8]
k = 3
print(min_coins_to_remove(arr, k))  # Example usage
