#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

pair<int, int> getRange(int q, int r) {
    int low = ceil(10.0 / 11.0 * q / r);
    int high = floor(10.0 / 9.0 * q / r);

    if (low > high) {
        return make_pair(0, 0);
    } else {
        return make_pair(low, high);
    }
}

void printSolution(int n, int p, const vector<int> &r,
                   const vector<vector<int>> &q) {
    int max_count = 0;

    if (n == 1) {
        for (int i = 0; i < p; ++i) {
            auto range = getRange(q[0][i], r[0]);
            if (range.first != 0) {
                max_count++;
            }
        }
        cout << max_count << "\n";
        return;
    }

    vector<int> v;
    for (int i = 0; i < p; ++i) {
        v.push_back(i);
    }
    do {
        int count = 0;
        for (int i = 0; i < p; ++i) {
            auto range0 = getRange(q[0][i], r[0]);
            if (range0.first != 0) {
                auto range1 = getRange(q[1][v[i]], r[1]);

                if (!(range0.first > range1.second ||
                      range1.first > range0.second)) {
                    count++;
                }
            }
        }

        max_count = max(max_count, count);
    } while (next_permutation(v.begin(), v.end()));

    cout << max_count << "\n";
}

int main(int argc, char *argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        int n, p;
        cin >> n >> p;

        vector<int> r;
        for (int j = 0; j < n; ++j) {
            int temp;
            cin >> temp;
            r.push_back(temp);
        }

        vector<vector<int>> q;

        for (int j = 0; j < n; ++j) {
            vector<int> q_row;
            for (int k = 0; k < p; ++k) {
                int temp;
                cin >> temp;
                q_row.push_back(temp);
            }
            // sort(q_row.begin(), q_row.end());
            q.push_back(q_row);
        }

        cout << "Case #" << i << ": ";
        printSolution(n, p, r, q);
    }
    return 0;
}