#include <algorithm>
#include <cassert>
#include <climits>
#include <cmath>
#include <iostream>
#include <map>
#include <queue>
#include <regex>
#include <set>
#include <string>
#include <unordered_map>
#include <vector>

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

void printSolution2(const string &code, const string &jam) {
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

void printSolution(const string &code, const string &jam) {
    string ans_c = code;
    string ans_j = jam;

    ll c_num = 0;
    ll j_num = 0;

    for (int i = 0; i < ans_c.size(); ++i) {
        if (ans_c[i] != '?' && ans_j[i] != '?') {
            c_num = 10 * c_num + (ans_c[i] - '0');
            j_num = 10 * j_num + (ans_j[i] - '0');
            continue;
        }

        if (c_num == j_num) {
            if (i + 1 < ans_c.size() && ans_c[i + 1] != '?' &&
                ans_j[i + 1] != '?') {
                int d = abs(ans_c[i + 1] - ans_j[i + 1]);
                if (d >= 5) {
                    if (ans_c[i + 1] > ans_j[i + 1]) {
                        if (ans_c[i] == '?') {
                            ans_c[i] = (ans_j[i] == '?' ? '0' : ans_j[i]);
                        }
                        if (ans_j[i] == '?') {
                            ans_j[i] = ((ans_c[i] == '?'|| ans_c[i] == '0') ? '1' : ans_c[i]);
                        }
                    } else {
                        if (ans_c[i] == '?') ans_c[i] = '1';
                        if (ans_j[i] == '?') ans_j[i] = '0';
                    }
                } else {
                    if (ans_c[i] == '?') {
                        ans_c[i] = (ans_j[i] == '?' ? '0' : ans_j[i]);
                    }
                    if (ans_j[i] == '?') {
                        ans_j[i] = (ans_c[i] == '?' ? '1' : ans_c[i]);
                    }
                }
            } else {
                if (ans_c[i] == '?') {
                    ans_c[i] = (ans_j[i] == '?' ? '0' : ans_j[i]);
                }
                if (ans_j[i] == '?') {
                    ans_j[i] = (ans_c[i] == '?' ? '0' : ans_c[i]);
                }
            }
        } else if (c_num > j_num) {
            if (ans_c[i] == '?') {
                ans_c[i] = '0';
            }
            if (ans_j[i] == '?') {
                ans_j[i] = '9';
            }
        } else {
            if (ans_c[i] == '?') {
                ans_c[i] = '9';
            }
            if (ans_j[i] == '?') {
                ans_j[i] = '0';
            }
        }

        c_num = 10 * c_num + (ans_c[i] - '0');
        j_num = 10 * j_num + (ans_j[i] - '0');
    }

    cout << ans_c << " " << ans_j << endl;
}

int main(int argc, char *argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        string c, j;
        cin >> c >> j;
        cout << "Case #" << i << ": ";
        printSolution(c, j);
    }
    return 0;
}