def maxThievesCaught(arr, k):
    police = []
    thieves = []

    for i, ch in enumerate(arr):
        if ch == 'P':
            police.append(i)
        elif ch == 'T':
            thieves.append(i)

    i = j = caught = 0

    while i < len(police) and j < len(thieves):
        p = police[i]
        t = thieves[j]

        if abs(p - t) <= k:
            caught += 1
            i += 1
            j += 1
        elif p < t:
            i += 1
        else:
            j += 1

    return caught

arr = ['P', 'T', 'T', 'P', 'T']
k = 1
print("Maximum thieves caught:", maxThievesCaught(arr, k))  # Output: 2