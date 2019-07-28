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
#include <regex>

using namespace std;

typedef long long ll;
typedef long double ld;


bool solve(string s) {
    // (100~1~|01)~
    regex pattern("(100+1+|01)+");
    return regex_match(s, pattern);
}

int main(void) {
    ios_base::sync_with_stdio(false);

    string s;
    cin >> s;
    
    cout << (solve(s) ? "SUBMARINE" : "NOISE") << endl;
    return 0;
}