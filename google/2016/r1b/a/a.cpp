#include <algorithm>
#include <cassert>
#include <cmath>
#include <cstring>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;
typedef long long ll;

string s_number[] = {"ZERO", "ONE", "TWO",   "THREE", "FOUR",
                     "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};

bool isExist(const string &s, int num) {
    string temp = s;
    for (int i = 0; i < s_number[num].size(); ++i) {
        auto pos = temp.find(s_number[num][i]);
        if (pos == string::npos) {
            return false;
        }
        temp.erase(pos, 1);
    }
    return true;
}

void subNum(string &s, int num) {
    for (int i = 0; i < s_number[num].size(); ++i) {
        auto pos = s.find(s_number[num][i]);
        s.erase(pos, 1);
    }
}

void printSolution(const string &s) {
    int num = 0;
    string temp = s;
    string ans;

    // check unique char
    vector<int> unique{0, 2, 4, 6, 8};
    for (int i = 0; i < unique.size();) {
        if (isExist(temp, unique[i])) {
            ans += ('0' + unique[i]);
            subNum(temp, unique[i]);
        } else {
            i++;
        }
    }

    vector<int> other{1, 3, 5, 7, 9};
    string temp2;
    string ans2;
    do {
        temp2 = temp;
        ans2 = ans;
        for (int i = 0; i < other.size();) {
            if (isExist(temp2, other[i])) {
                ans2 += ('0' + other[i]);
                subNum(temp2, other[i]);
            } else {
                i++;
            }
        }
        if (temp2.empty()) {
            break;
        }
    } while (next_permutation(other.begin(), other.end()));

    sort(ans2.begin(), ans2.end());
    cout << ans2 << endl;
}

void printSolution1(const string &s) {
    int num = 0;
    string temp;
    string ans;

    vector<int> other{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    do {
        temp = s;
        ans.clear();
        for (int i = 0; i < other.size();) {
            if (isExist(temp, other[i])) {
                ans += ('0' + other[i]);
                subNum(temp, other[i]);
            } else {
                i++;
            }
        }
        if (temp.empty()) {
            break;
        }
    } while (next_permutation(other.begin(), other.end()));

    sort(ans.begin(), ans.end());
    cout << ans << endl;
}

int main(int argc, char *argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        string s;
        cin >> s;
        cout << "Case #" << i << ": ";
        printSolution(s);
    }
    return 0;
}