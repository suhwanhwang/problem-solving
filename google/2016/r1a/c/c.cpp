#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <cmath>
#include <cassert>

using namespace std;
using ll = long long;

void printSolution(int n, const vector<int> &bff) {
    int max_num = 0;
    vector<int> v;
    for (int i = 1; i <= n; ++i) {
        v.push_back(i);
    }

    do {
        int first = v[0];
        int second = v[1];

        for (int i = 1; i < n; ++i) {
            int prev = v[i - 1];
            int cur = v[i];

            if ((bff[cur] == prev || bff[cur] == first) &&
            (bff[first] == cur || bff[first] == second)) {
                max_num = max(max_num, i + 1);
            }

            if (bff[cur] != prev && (i == n -1 || bff[cur] != v[i + 1])) {
                break;
            }
        }
    } while(next_permutation(v.begin(), v.end()));

    cout << max_num << endl;
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <=t; ++i) {
        int n;
        cin >> n;

        vector<int> bff;
        bff.push_back(0);
        for (int j = 0; j < n; ++j) {
            int f;
            cin >> f;
            bff.push_back(f);
        }

        cout << "Case #" << i << ": ";
        printSolution(n, bff);        
    }
    return 0;
}
