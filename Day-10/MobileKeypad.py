def count_sequences(n):
    # Keypad layout
    keypad = [
        ['1', '2', '3'],
        ['4', '5', '6'],
        ['7', '8', '9'],
        ['*', '0', '#']
    ]

    # Directions: stay, up, down, left, right
    directions = [(0, 0), (-1, 0), (1, 0), (0, -1), (0, 1)]

    # Initialize DP table
    dp = [[[0] * (n + 1) for _ in range(3)] for _ in range(4)]

    # Base case: sequences of length 1
    for i in range(4):
        for j in range(3):
            if keypad[i][j] not in ('*', '#'):
                dp[i][j][1] = 1

    # Fill DP table
    for length in range(2, n + 1):
        for i in range(4):
            for j in range(3):
                if keypad[i][j] in ('*', '#'):
                    continue
                # Try all directions
                for di, dj in directions:
                    ni, nj = i + di, j + dj
                    if 0 <= ni < 4 and 0 <= nj < 3 and keypad[ni][nj] not in ('*', '#'):
                        dp[i][j][length] += dp[ni][nj][length - 1]

    # Sum all sequences of length n
    total = 0
    for i in range(4):
        for j in range(3):
            if keypad[i][j] not in ('*', '#'):
                total += dp[i][j][n]

    return total

# Example usage
print("Number of sequences for n = 2:", count_sequences(2))  # Output: 36