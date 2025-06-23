def minSum(arr):
    arr.sort()

    num1 = []
    num2 = []

    for i, val in enumerate(arr):
        if i % 2 == 0:
            num1.append(str(val))
        else:
            num2.append(str(val))

    num1 = ''.join(num1)
    num2 = ''.join(num2)

    # Remove leading zeros
    num1 = num1.lstrip('0') or '0'
    num2 = num2.lstrip('0') or '0'

    return addStrings(num1, num2)

def addStrings(a, b):
    i, j = len(a) - 1, len(b) - 1
    carry = 0
    res = []

    while i >= 0 or j >= 0 or carry:
        total = carry
        if i >= 0:
            total += int(a[i])
            i -= 1
        if j >= 0:
            total += int(b[j])
            j -= 1
        res.append(str(total % 10))
        carry = total // 10

    return ''.join(reversed(res))