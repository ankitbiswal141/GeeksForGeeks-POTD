from collections import Counter

def can_arrange(arr, k):
    if len(arr) % k != 0:
        return False

    count = Counter(arr)
    for num in sorted(count):
        freq = count[num]
        if freq > 0:
            for i in range(k):
                if count[num + i] < freq:
                    return False
                count[num + i] -= freq
    return True

# Test cases here