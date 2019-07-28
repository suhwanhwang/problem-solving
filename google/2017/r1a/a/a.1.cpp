#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int findInitialIndex(int r, const vector<string>& cake) {
    for (int i = 0; i < cake[r].size(); ++i) {
        if (cake[r][i] != '?') {
            return i;
        }
    }
    return -1;
}

void printSolution(int r, int c, const vector<string>& cake) {
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            if (cake[i][j] == '?') {
                if (j == 0) {
                    int a = findInitialIndex(i, cake);
                    if (a == -1) {
                        
                    }
                }
                if (j > 0 && cake[i][j - 1] != '?') {
                    cake[i][j] = cake[i][j - 1];
                }
            }
        }
    }

    cout << "" << endl;
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <=t; ++i) {
        int r, c;
        cin >> r >> c;

        vector<string> cake;
        for (int j = 0; j < r; ++j) {
            string s;
            cin >> s;
            cake.push_back(s);
        }
        cout << "Case #" << i << ": ";
        printSolution(r, c, cake);        
    }
    return 0;
}