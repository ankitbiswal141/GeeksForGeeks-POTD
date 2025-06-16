def min_cost(heights, cost):
    def total_cost(target):
        return sum(abs(h - target) * c for h, c in zip(heights, cost))

    low, high = min(heights), max(heights)
    result = float('inf')

    while low <= high:
        mid = (low + high) // 2
        cost1 = total_cost(mid)
        cost2 = total_cost(mid + 1)
        result = min(result, cost1, cost2)

        if cost1 < cost2:
            high = mid - 1
        else:
            low = mid + 1

    return result


