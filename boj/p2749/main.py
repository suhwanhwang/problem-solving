# n+1  0 1  n
# n+2  1 1  n+1
#
# a b  w x   aw+by ax+bz
# c d  y z   cw+dy cx+dz
#

def mul(m1, m2):
    res=[[0,0],[0,0]]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                res[i][j] += m1[i][k] * m2[k][j]
    return res

def fib2(n):
    if (n < 2):
        return n;
        
    ans=[[0,1],[1,1]]
    k = [[0,1],[1,1]]
    
    for i in range(n-2):
        ans = mul(k,ans)
        # print(ans)
    return ans[1][1]

num = int(input())
print(fib2(num))