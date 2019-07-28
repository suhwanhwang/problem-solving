#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void printSolution(const vector<int>& m) {
    int m1 = 0;
    for (int i = 1; i < (int)m.size(); ++i) {
        if (m[i - 1] > m[i]) {
            m1 += m[i - 1] - m[i];
        }
    }

    int max_d = 0;
    for (int i = 1; i < (int)m.size(); ++i) {
        max_d = max(max_d, m[i - 1] - m[i]);
    }
    int m2 = 0;
    for (int i = 0; i < (int)m.size() - 1; ++i) {
        m2 += min(max_d, m[i]);
    }

    cout << m1 << ' ' << m2 << endl;
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        int n;
        cin >> n;
        vector<int> m(n);
        for (int j = 0; j < n; ++j) {
            cin >> m[j];
        }
        cout << "Case #" << i << ": ";
        printSolution(m);
    }
    return 0;
}