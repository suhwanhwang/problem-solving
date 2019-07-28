//
//  main.cpp
//  problem_b
//
//  Created by Suhwan Hwang on 2017. 4. 16..
//  Copyright © 2017년 Suhwan Hwang. All rights reserved.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;
typedef long long ll;

void printSolution(int n, int p, const vector<int> &r,
                   const vector<vector<int>> &q) {
    int max_count = 0;
    for (int i = 1; i < (1 << p); ++i) {
        int count = 0;
        for (int j = 0; j < p; ++j) {
            if (i & (1 << j)) {
                int low0 = (int)(10.0 / 11.0 * q[0][j] / r[0]);
                int high0 = (int)(10.0 / 9.0 * q[0][j] / r[0]);
                vector<bool> isUse(p, false);
                
                for (int k = 0; k < p; ++k) {
                    if (isUse[k]) {
                        continue;
                    }
                    int low1 = (int)(10.0 / 11.0 * q[1][k] / r[1]);
                    int high1 = (int)(10.0 / 9.0 * q[1][k] / r[1]);
                    if (!(low1 > high0 || low0 > high1)) {
                        isUse[k] = true;
                        count++;
                    }
                }
            }
        }
        
        max_count = max(max_count, count);
    }
    
    cout << max_count << "\n";
}

int main(int argc, char *argv[]) {
    int t;
    
    cin >> t;
    
    for (int i = 1; i <= t; ++i) {
        int n, p;
        cin >> n >> p;
        
        vector<int> r;
        for (int j = 0; j < n; ++j) {
            int temp;
            cin >> temp;
            r.push_back(temp);
        }
        
        vector<vector<int>> q;
        
        for (int j = 0; j < n; ++j) {
            vector<int> q_row;
            for (int k = 0; k < p; ++k) {
                int temp;
                cin >> temp;
                q_row.push_back(temp);
            }
            // sort(q_row.begin(), q_row.end());
            q.push_back(q_row);
        }
        
        cout << "Case #" << i << ": ";
        printSolution(n, p, r, q);
    }
    return 0;
}
