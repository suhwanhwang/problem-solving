#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int getLS(const vector<int> &stalls, int s) {
    int ls = 0;
    for (int i = s - 1; i >= 0; --i) {
        if (stalls[i] == 1) {
            return ls;
        }
        ++ls;
    }
    return ls;
}

int getRS(const vector<int> &stalls, int s) {
    int rs = 0;
    for (int i = s + 1; i < stalls.size(); ++i) {
        if (stalls[i] == 1) {
            return rs;
        }
        ++rs;
    }
    return rs;
}

int findStall(const vector<int> &stalls) {
    int max_min = 0;
    int max_max = 0;
    int max_stall = 0;
    for (int i = 0; i < stalls.size(); ++i) {
        if (stalls[i] == 1) {
            continue;
        }

        int ls = getLS(stalls, i);
        int rs = getRS(stalls, i);
        int mn = min(ls, rs);
        int mx = max(ls, rs);
        if (max_min < mn) {
            max_min = mn;
            max_stall = i;
        } else if (max_min == mn) {
            if (mx > max_max) {
                max_max = mn;
                max_stall = i;
            }
        }
    }
    return max_stall;
}

void printSolution(int n, int k) {
    vector<int> stalls(n, 0);
    int last_stall = 0;

    for (int i = 0; i < k; ++i) {
        int s = findStall(stalls);
        stalls[s] = 1;
        last_stall = s;
    }
    int ls = getLS(stalls, last_stall);
    int rs = getRS(stalls, last_stall);
    cout << max(ls, rs) << " " << min(ls, rs) << endl;
}

int main(int argc, char *argv[]) {
    int t;

    cin >> t;
    for (int i = 1; i <= t; ++i) {
        int n, k;
        cin >> n >> k;
        cout << "Case #" << i << ": ";
        printSolution(n, k);
    }

    return 0;
}