#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

bool checkOk(const vector<pair<int, char>> &pq, int half) {
    for (auto &p : pq) {
        if (p.first > half) {
            return false;
        }
    }
    return true;
}

void printSolution(int n, int sum, vector<pair<int, char>> &pq) {
    int current = sum;

    while (current > 0) {
        sort(pq.begin(), pq.end(), greater<pair<int,int>>());

        // 1st -2
        if (pq[0].first > 2) {
            pq[0].first -= 2;
            if (checkOk(pq, (current - 2) / 2) == false) {
                pq[0].first += 2;
            } else {
                current -= 2;
                cout << pq[0].second << pq[0].second << " ";
                continue;
            }
        }

        // 1st -1, 2nd -1
        pq[0].first--;
        pq[1].first--;
        if (checkOk(pq, (current - 2) / 2) == false) {
            pq[0].first++;
            pq[1].first++;
        } else {
            current -= 2;
            cout << pq[0].second << pq[1].second << " ";
            continue;
        }

        // 1st -1
        pq[0].first--;
        current--;
        cout << pq[0].second << " ";
    }
    cout << "\n";
}

int main(int argc, char *argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        int n;
        cin >> n;

        vector<pair<int, char>> pq;
        int sum = 0;
        for (int j = 0; j < n; ++j) {
            int p;
            cin >> p;
            pq.push_back(make_pair(p, j + 'A'));
            sum += p;
        }

        cout << "Case #" << i << ": ";
        printSolution(n, sum, pq);
    }
    return 0;
}