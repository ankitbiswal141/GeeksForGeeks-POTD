def sortString(s):
    # Separate uppercase and lowercase characters
    upper = []
    lower = []
    
    for c in s:
        if c.isupper():
            upper.append(c)
        else:
            lower.append(c)

    # Sort both lists
    upper.sort()
    lower.sort()

    # Rebuild the string by placing characters back in the original order
    result = ''
    upperIndex, lowerIndex = 0, 0
    for c in s:
        if c.isupper():
            result += upper[upperIndex]
            upperIndex += 1
        else:
            result += lower[lowerIndex]
            lowerIndex += 1

    return result

# Test cases here