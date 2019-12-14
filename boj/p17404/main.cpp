#include <iostream>
#include <algorithm>
#include <cstring>
using namespace std;

/*
3
26 40 83
49 60 57
13 89 99
  */
constexpr int kmax = 1000;

int num;
int cost[kmax + 1][3];
int dp[kmax + 1][3];

int solveSub(int index, int color, int lastColor) {
  if (index < 0) return 0;
  
  int &ans = dp[index][color];
  if (ans != -1) return ans;
  
  int c1 = (color + 1) % 3;
  int c2 = (color + 2) % 3;
  
  if (index == 0 && c1 == lastColor) {
    ans = cost[index][color] 
      + solveSub(index-1, c2, lastColor);
  } else if (index == 0 && c2 == lastColor) {
    ans = cost[index][color] 
      + solveSub(index-1, c1, lastColor);
  } else {
    ans = cost[index][color] 
      + min(solveSub(index-1, c1, lastColor), 
        solveSub(index-1, c2, lastColor));
  }
  return ans;
}

int solve() {
  int ans = 987654321;
  for (int i = 0; i < 3; ++i) {
    memset(dp, -1, sizeof(dp));
    ans = min(ans, solveSub(num - 1, i, i));
  }
  return ans;
}

int main()
{
    cin >> num;
    for(int i = 0; i < num; ++i) {
      cin >> cost[i][0] >> cost[i][1] >> cost[i][2];
    }
    
    cout << solve() << endl;
}
