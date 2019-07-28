#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

double s_max = 0.0;
vector<pair<int, int>> s_cake;

double side(int r, int h) { return (double)2.0 * M_PI * r * h; }

double circle(int r) { return (double)M_PI * r * r; }

bool compare(const pair<int, int> &l, const pair<int, int> &r) {
    return circle(l.first) + side(l.first, l.second) > circle(r.first) + side(r.first, r.second);
}

void printSolution_f(int n, int k, vector<pair<int, int>> &cake) {
    sort(cake.begin(), cake.end(), compare);

    double ans = 0.0;
    int max_r = 0;
    for (int i = 0; i < k; ++i) {
        ans += side(cake[i].first, cake[i].second);
        max_r = max(max_r, cake[i].first);
    }
    ans += circle(max_r);

    cout << fixed << ans << endl;
}

double getNumber(const vector<int>& picked) {
    double ans = 0.0;
    int max_r = 0;
    for (int i = 0; i < (int)picked.size(); ++i) {
        ans += side(s_cake[picked[i]].first, s_cake[picked[i]].second);
        max_r = max(max_r, s_cake[picked[i]].first);
    }
    ans += circle(max_r);
    return ans;
}

void pick(int n, vector<int>& picked, int toPick) {
    if (toPick == 0) {
        s_max = max(s_max, getNumber(picked));
        return;
    }

    int smallest = picked.empty() ? 0 : picked.back() + 1;

    for (int next = smallest; next < n; ++next) {
        picked.push_back(next);
        pick(n, picked, toPick - 1);
        picked.pop_back();
    }
}

void printSolution(int n, int k) {
    s_max = 0.0;
    vector<int> temp;
    pick(n, temp, k);
    cout << fixed << s_max << endl;
}

int main(int argc, char *argv[]) {
    int t;

    cin >> t;
    cout.precision(20);

    for (int i = 1; i <= t; ++i) {
        int n, k;
        cin >> n >> k;
        s_cake.clear();

        for (int j = 0; j < n; ++j) {
            int r, h;
            cin >> r >> h;
            s_cake.push_back(make_pair(r, h));
        }

        cout << "Case #" << i << ": ";
        printSolution(n, k);
    }
    return 0;
}