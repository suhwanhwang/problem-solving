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

string solve(string n) {
    int sum =0;

    for (int i=0; i < n.size(); ++i) {
	    sum+= n[i]-'0';
    }
    if (sum%3 != 0) {
	    return "-1";
    }
    sort(n.begin(),n.end(), greater<char>());
    if (n.back() !='0') {
	    return "-1";
    }
    return n;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    string  n;
    cin >> n;
    
    cout << solve(n) << endl;
    return 0;
}
