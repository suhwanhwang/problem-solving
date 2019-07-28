#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void fill(string& s) {
    int start = -1;
    int end = -1;
    // copy to left
    for (int i = 0; i < (int)s.size(); ++i) {
        if (s[i] == '?') {
            if (i == 0 || s[i - 1] != '?') {
                start = i;
            }
        } else if (s[i] != '?' && start != -1) {
            end = i;
            s.replace(start, end - start, end - start, s[end]);
            start = -1;
        }
    }

    // copy to right
    start = -1;
    end = -1;
    for (int i = (int)s.size() - 1; i >= 0; --i) {
        if (s[i] == '?') {
            if (i == (int)s.size() - 1 || s[i + 1] != '?') {
                end = i;
            }
        } else if (s[i] != '?' && end != -1) {
            start = i;
            s.replace(start + 1, end - start, end - start, s[start]);
            end = -1;
        }
    }
}

void printSolution(const vector<string>& cake) {
    vector<string> ans = cake;

    // 1st fill row
    for (int i = 0; i < (int)ans.size(); ++i) {
        fill(ans[i]);
    }

    // 2nd fill col
    for (int i = 1; i < (int)ans.size(); ++i) {
        for (int j = 0; j < (int)ans[i].size(); ++j) {
            if (ans[i][j] == '?' && ans[i - 1][j] != '?') {
                ans[i][j] = ans[i - 1][j];
            }
        }
    }

    // 3rd fill col
    for (int i = (int)ans.size() - 2; i >= 0; --i) {
        for (int j = 0; j < (int)ans[i].size(); ++j) {
            if (ans[i][j] == '?' && ans[i + 1][j] != '?') {
                ans[i][j] = ans[i + 1][j];
            }
        }
    }

    for (string& s : ans) {
        cout << s << "\n";
    }
}

void test(void) {
    vector<string> cake{"G??", "?C?", "??J"};

    printSolution(cake);
}

int main(int argc, char* argv[]) {
    // test();

    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        int r, c;
        cin >> r >> c;

        vector<string> cake;
        for (int j = 0; j < r; ++j) {
            string s;
            cin >> s;
            cake.push_back(s);
        }
        cout << "Case #" << i << ":\n";
        printSolution(cake);
    }
    return 0;
}