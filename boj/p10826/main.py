import sys
sys.setrecursionlimit(100000)

dp={}
def fib(n):
    if (n<2):
        return n
    if n in dp:
        return dp[n]
    dp[n] = fib(n-1)+fib(n-2)
    return dp[n]
num = int(input())
print(fib(num))
