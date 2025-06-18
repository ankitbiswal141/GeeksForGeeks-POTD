def is_palindrome(s: str) -> bool:
    return s == s[::-1]

def backtrack(s: str, start: int, temp: list, result: list):
    if start == len(s):
        result.append(temp[:])
        return

    for i in range(start + 1, len(s) + 1):
        substr = s[start:i]
        if is_palindrome(substr):
            temp.append(substr)
            backtrack(s, i, temp, result)
            temp.pop()

def partition(s: str):
    result = []
    backtrack(s, 0, [], result)
    return result

# Test cases