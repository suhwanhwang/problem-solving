#include <iostream>
#include <algorithm>
#include <vector>
#include <numeric>
#include <unordered_set>
#include <unordered_map>
#include <set>
#include <cstdlib>
#include <ctime>

using namespace std;

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a%b);
}

int solve(int d1, int d2) {
    set<pair<int , int>> s;

    for (int i = d1; i <= d2; ++i) {
        for (int j = 1; j <= i; ++j) {
            int g = gcd(i, j);
            s.insert({i/g, j/g});
        }
    }

    return s.size();
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int d1, d2;
    cin >> d1 >> d2;
    
    cout << solve(d1, d2) << endl;
    
    return 0;
}