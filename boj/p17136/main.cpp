// from bits/stdc++.h
// C
#include <climits>
#include <cmath>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <ctime>

// C++
#include <algorithm>
#include <bitset>
#include <complex>
#include <deque>
#include <fstream>
#include <functional>
#include <iostream>
#include <istream>
#include <iterator>
#include <limits>
#include <list>
#include <map>
#include <memory>
#include <numeric>
#include <ostream>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <utility>
#include <vector>
#include <regex>
#include <tuple>
#include <unordered_map>
#include <unordered_set>

using namespace std;

typedef long long ll;
typedef long double ld;

const int kMAX = 10;
const int kCOLOR_MAX = 5;
const int kNUM[]={0b0,0b1,0b11,0b111,0b1111,0b11111};

int paper[kMAX+1];
int numColor[kCOLOR_MAX+1] = {0, 5, 5, 5, 5, 5};

void setPaperBit(int r, int c, int s) {
    if (r + s > kMAX || c + s > kMAX) {
        return;
    }
    
    int num = (kNUM[s] << c);
    for (int i = r; i < r + s; ++i) {
        paper[i] |= num;
    } 
}

void clearPaperBit(int r, int c, int s) {
    if (r + s > kMAX || c + s > kMAX) {
        return;
    }
    
    int num = (kNUM[s] << c);
    for (int i = r; i < r + s; ++i) {
        paper[i] &= ~num;
    } 
}

bool isOK(int r, int c, int s) {
    if (r + s > kMAX || c + s > kMAX) {
        return false;
    }
    
    if (numColor[s] <= 0) {
        return false;
    }
    
    int num = (kNUM[s] << c);
    for (int i = r; i < r + s; ++i) {
        if ((paper[i] & num) != num) {
            return false;
        }
    } 
    return true;
} 

int solveSub(int row, int col) {
    if (row >= kMAX || col >= kMAX) {
        return 0;
    }
    
    // find 1
    int r = -1;
    int c = -1;
    for (int i = row; i < kMAX; ++i) {
        //cout<<"row"<<i<<" "<<paper[i]<<endl;
        if (paper[i] == 0) {
            continue;
        }
        int sc = (i==row ? col : 0);
        for (int j = sc; j < kMAX; ++j) {
            int tmp = (1<<j);
            //cout << "col"<<j<<" "<<tmp<<endl;
            if ((paper[i] & tmp) == tmp) {
                r = i;
                c = j;
                break;
            }
        }
        if (r!=-1 && c!=-1) { // found
            break;
        }
    }
    if (r ==-1 && c == -1) { // not found
        return 0;
    }
    
    //cout<<r<<","<<c<<endl;
    int ans = 987654321;
    for (int i = 1; i <= kCOLOR_MAX; ++i) {
        if (isOK(r, c, i)) {
            clearPaperBit(r, c, i);
            numColor[i]--;
            ans = min(ans, 1 + solveSub(r, c+i));
            numColor[i]++;
            setPaperBit(r, c, i);
        }
    }
    
    return ans;
}


int solve() {
    int ans = solveSub(0,0);
    return ans == INT_MAX ? -1 : ans;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    for(int r = 0; r < kMAX; ++r) {
        for(int c = 0; c < kMAX; ++c) {
            int tmp;
            cin >> tmp;
            if (tmp == 1) {
                paper[r] |= (1<<c);
            }
        }
    }

    cout << solve() << endl;
    return 0;
}
