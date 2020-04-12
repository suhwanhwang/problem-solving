// from bits/stdc++.h
// C
#include <climits>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <ctime>

// C++
#include <algorithm>
#include <bitset>
#include <complex>
#include <deque>
#include <fstream>
#include <functional>
#include <iostream>
#include <istream>
#include <iterator>
#include <limits>
#include <list>
#include <map>
#include <memory>
#include <numeric>
#include <ostream>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <utility>
#include <vector>
#include <regex>
#include <tuple>
#include <unordered_map>
#include <unordered_set>

using namespace std;

typedef long long ll;
typedef long double ld;


class Solution {
public:
    int myAtoi(string str) {
        long ans=0;
        bool minus = false;
        for(int i = 0; i < str.size(); ++i) {
            if (str[i] == ' ' || !('0' <= str[i] && str[i] <= '9')) continue;
            
            if (str[i] == '-') {
              minus = true;
              continue;
            }
            
            ans *= 10;
            ans += str[i] - '0';
        }
        if (minus) {
            ans *= -1;
        }
        
        if (ans > INT_MAX) {
            ans = INT_MAX;
        } else if (ans < INT_MIN) {
            ans = INT_MIN;
        }
        return ans;
    }
};

int main(void) {
  ios_base::sync_with_stdio(false);

  Solution s;
  cout << s.myAtoi("-1") << endl;
  return 0;
}