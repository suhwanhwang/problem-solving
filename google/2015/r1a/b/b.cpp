#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void printSolution(int n, const vector<int>& m) {
    vector<pair<int, int>> v;

    for (int i = 1; i < (int)m.size(); ++i) {
        v.push_back(make_pair(0, i));
    }

    int barber;
    for (int i = 1; i <= n; ++i) {
        sort(v.begin(), v.end());
        barber = v[0].second;
        if (v[0].first != 0) {
            for (int j = 1; j < (int)v.size(); ++j) {
                v[i].first = max(v[i].first - v[0].first, 0);
            }
        }
        v[0].first = m[v[0].second];
    }
    cout << barber << endl;
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        int b, n;
        cin >> b >> n;
        vector<int> m(b+1);
        for (int j = 1; j <= b; ++j) {
            cin >> m[j];
        }
        cout << "Case #" << i << ": ";
        printSolution(n, m);
    }
    return 0;
}