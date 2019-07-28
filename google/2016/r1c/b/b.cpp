#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void printSolution(ll b, ll m) {
    ll max_num = (1LL << (b - 2));

    if (m > max_num) {
        cout << "IMPOSSIBLE\n";
        return;
    }

    cout << "POSSIBLE\n";
    vector<vector<ll>> g(b, vector<ll>(b, 0));
    ll count = 0;

    for (ll i = 1; i < b; ++i) {
        for (ll j = b - 1; j > i; --j) {
            g[i][j] = 1;
        }
    }

    if (m < max_num) {
        for (ll i = m, c = 0; i > 0; i >>= 1, ++c) {
            if (i & 1) {
                g[0][b - 1 - (c + 1)] = 1;
            }
        }
    } else {
        for (ll i = 1; i < b; ++i) {
            g[0][i] = 1;
        }
    }

    // print
    for (ll i = 0; i < b; ++i) {
        for (ll j : g[i]) {
            cout << j;
        }
        cout << "\n";
    }
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        ll b, m;
        cin >> b >> m;

        cout << "Case #" << i << ": ";
        printSolution(b, m);
    }
    return 0;
}