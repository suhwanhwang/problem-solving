#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <cassert>
#include <ctime>

using namespace std;

typedef long long ll;

void printSolution(ll n, ll k) {
    ll ls, rs;
    for (ll i = 0; i < n; ++i) {
        ls += i;
        rs += i;
    }

    cout << ls << " " << rs << endl;
}

int main(int argc, char *argv[]) {
    clock_t tick = clock();
    int t;

    cin >> t;
    for (int i = 1; i <= t; ++i) {
        ll n, k;
        cin >> n >> k;
        cout << "Case #" << i << ": ";
        printSolution(n, k);
    }

    cerr << "time = " << clock() - tick << endl;
    return 0;
}