#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <unordered_map>
#include <cmath>
#include <cassert>
#include <regex>
#include <climits>

using namespace std;
typedef long long ll;

bool isMatch(const string &s, int i) {
    string num = to_string(i);
    num.insert(0, s.size() - num.size(), '0');

    for (int i = s.size() - 1; i >= 0; --i) {
        if (s[i] == '?') {
            continue;
        }

        if (s[i] != num[i]) {
            return false;
        }
    }
    return true;
}

void printSolution(const string &code, const string &jam) {
    int first_num = 0;
    int min_value = INT_MAX;
    int min_c, min_j;

    int len = code.size();
    int max_num = pow(10, len);
    for (int i = 0; i < max_num; ++i) {
        if (isMatch(code, i)) {
            for (int j = 0; j < max_num; ++j) {
                if (isMatch(jam, j)) {
                    if (min_value > abs(i - j)) {
                        min_value = abs(i - j);
                        min_c = i;
                        min_j = j;
                    }
                }
            }
        }
    }
    string ans_c = to_string(min_c);
    ans_c.insert(0, len - ans_c.size(), '0');
    string ans_j = to_string(min_j);
    ans_j.insert(0, len - ans_j.size(), '0');
    cout << ans_c << " " << ans_j << endl;
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <=t; ++i) {
        string c, j;
        cin >> c >> j;
        cout << "Case #" << i << ": ";
        printSolution(c, j);        
    }
    return 0;
}