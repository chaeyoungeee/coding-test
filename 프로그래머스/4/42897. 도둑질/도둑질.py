def steal(money):
    n = len(money)
    dp = [0] * n
    dp[0] = money[0]
    dp[1] = max(dp[0], money[1])
    
    for i in range(2, n):
        dp[i] = max(money[i]+dp[i-2], dp[i-1])

    return dp[n-1]

def solution(money):
    return max(steal(money[1:len(money)]), steal(money[:len(money)-1]))