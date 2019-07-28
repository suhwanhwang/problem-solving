#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <cassert>

using namespace std;

void print(const vector<int> &v) {
    for (int i : v) {
        cout << i << " ";
    }
    cout << endl;
}

bool isBig(const vector<int> &a, const vector<int> &b) {
    for (int i = 0; i < a.size(); ++i) {
        if (a[i] >= b[i]) {
            return false;
        }
    }
    return true;
}

bool validation(const vector<vector<int>> &v, const vector<vector<int>> &o) {
    int count = 0;
    vector<int> ans;
    vector<vector<int>> temp = v;

    // rows
    for (int i = 0; i < o.size(); ++i) {
        // auto it = lower_bound(temp.begin(), temp.end(), o[i]);
        // if (it != temp.end()) {
        //     temp.erase(it);
        // } else {
        //     assert("not found");
        // }

        for (int j = 0; j < temp.size(); ++j) {
            if (temp[j] == o[i]) {
                temp.erase(temp.begin() + j);
                break;
            }
        }
    }

    // cols
    for (int i = 0; i < o.size(); ++i) {
        vector<int> col;
        for (int j = 0; j < o.size(); ++j) {
            col.push_back(o[j][i]);
        }
        // auto it = lower_bound(temp.begin(), temp.end(), col);
        // if (it != temp.end()) {
        //     temp.erase(it);
        // } else {
        //     count++;
        //     ans = col;
        // }
        bool isFound = false;
        for (int j = 0; j < temp.size(); ++j) {
            if (temp[j] == col) {
                isFound = true;
                temp.erase(temp.begin() + j);
                break;
            }
        }
        if (!isFound) {
            count++;
            if (count > 1) {
                return false;
            }
            ans = col;
        }
    }
    print(ans);
    return true;
}

bool pick(const vector<vector<int>> &v, vector<vector<int>> &o, int index, int n) {
    if (o.size() == n) {
        return validation(v, o);
    }

    for (int i = index; i < v.size(); ++i) {
        if (o.empty() || isBig(o.back(), v[i])) {
            o.push_back(v[i]);
            if (pick(v, o, i, n)) {
                return true;
            }
            o.pop_back();
        }
    }
    return false;
}

void printSolution(const vector<vector<int>> &army, int n) {
    vector<vector<int>> sorted = army;
    sort(sorted.begin(), sorted.end());
    
    vector<vector<int>> temp;
    pick(sorted, temp, 0, n);
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <=t; ++i) {
        int n;
        cin >> n;

        vector<vector<int>> army;
        for (int j = 0; j < 2*n - 1; ++j) {
            vector<int> row;
            for (int k = 0; k < n; ++k) {
                int h;
                cin >> h;
                row.push_back(h);
            }
            army.push_back(row);            
        }

        cout << "Case #" << i << ": ";
        printSolution(army, n);        
    }
    return 0;
}
