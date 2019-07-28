#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void printSolution(int n, const vector<int>& m) {
    
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