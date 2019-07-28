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

int gcd(int a, int b) {return b == 0 ? a : gcd(b, a%b);}

int solve(int n) {
    return 0;
}

struct Employee {
    int id;
    int s;
    int t;
    Employee(int id, int s, int t):id(id), s(s), t(t) {}  
};

bool comp(

int main(void) {
    ios_base::sync_with_stdio(false);

    int m, n;
    cin >> n >> m;
    
    vector<Employee> employee;
    for (int i = 0; i < n; ++i) {
        int id, s, t;
        cin >> id >> s >> t;
        employee.push_back(Employee(id,s,t));
    }
    
    cout << solve(n) << endl;
    return 0;
}