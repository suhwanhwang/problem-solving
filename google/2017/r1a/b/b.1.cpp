#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void printSolution1(int n, int p, const vector<int> &in, const vector<vector<int>> &qu) {
    int max_count = 0;
   
    for (int i = 0; i < n; ++i) {
        int count = 0;
        for (int j = 0; j < p; ++j) {
            int q = qu[i][j];
            int portion = 0;
            for (int k = q/in[i]; k <= q/in[i] + 1; ++k) {
                int low = in[i] * k * 0.9;
                int high = in[i] * k * 1.1;
                if (low <= q && q <= high) {
                    portion = k;
                    break;
                }
            }
            if (portion == 0) {
                continue;
            }

            bool isOK = true;
            for (int k = 0; k < n; ++k) {
                int low = in[k] * portion * 0.9;
                int high = in[k] * portion * 1.1;
                bool found = false;
                for (int l = 0; l < p; ++l) {
                    if (low <= qu[k][l] && qu[k][l] <= high) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    isOK = false;
                    break;
                }
            }
            if (isOK) {
                count++;
            }
        }
        max_count = max(max_count, count);
    }
    
    cout << max_count << endl;
}

void printSolution(int n, int p, const vector<int> &in, const vector<vector<int>> &qu) {
    int max_portion = 0;
    for (int i = 0; i < n; ++i) {
        max_portion = max(max_portion, qu[i].back() / in[i] + 1);
    }

    int total_count = 0;
    for (int i = 1; i <= max_portion; ++i) {
        bool isOk = true;
        int min_count = INT_MAX;
        for (int j = 0; j < n; ++j) {
            int quantity = in[j] * i;
            int low = quantity * 0.9;
            int high = quantity * 1.1;

            // auto it_lo = lower_bound(qu[j].begin(), qu[j].end(), low);
            // auto it_hi = upper_bound(qu[j].begin(), qu[j].end(), high);
            // if (it_lo == it_hi) {
            //     break;
            // }
            // if (it_lo == qu[j].end() && it_hi == qu[j].end()) {
            //     break;
            // }
            int count = 0;
            for (int k = 0; k < p; ++k) {
                if (low <= qu[j][k] && qu[j][k] <= high) {
                    count++;
                }
            }
            if (count == 0) {
                isOk = false;
                break;
            }
            min_count = min(min_count, count);
        }
        if (isOk) {
            total_count += min_count;
        }
    }
    if (total_count > p) {
        total_count = p;
    }
    cout << total_count << endl;
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <=t; ++i) {
        int n, p;
        cin >> n >> p;

        vector<int> ingredient;
        for (int j = 0; j < n; ++j) {
            int temp;
            cin >> temp;
            ingredient.push_back(temp);
        }

        vector<vector<int>> quantity;

        for (int j = 0; j < n; ++j) {
            vector<int> q;
            for (int k = 0; k < p; ++k) {
                int temp;
                cin >> temp;
                q.push_back(temp);
            }
            sort(q.begin(), q.end());
            quantity.push_back(q);
        }

        cout << "Case #" << i << ": ";
        printSolution(n, p, ingredient, quantity);
    }
    return 0;
}