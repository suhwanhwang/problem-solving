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

vector<string> split(const string &s) {
    vector<string> sp;
    stringstream ss(s);
    string tmp;
    while(ss>>tmp){
      sp.push_back(tmp);
    }
    return sp;
}

bool isLetter(const string&s){
    for(auto c : s){
        if(!isalpha(c)) return false;
    }
    return true;
}

bool cmp(const string&s1, const string&s2){
    auto v1 = split(s1);
    auto v2 = split(s2);
    
    bool letter1 = isLetter(v1[1]);
    bool letter2 = isLetter(v2[1]);
    
    if(letter1 == letter2) {   
        if (letter1) {
           return s1.substr(s1.find(" ")).compare(s2.substr(s2.find(" "))) <= 0;
        } else {
           return false;
        }
    } else {
        return letter1;
    }
} 

class Solution {
public:
    vector<string> reorderLogFiles(vector<string>& logs) {
        vector<string>ans(logs);
        stable_sort(ans.begin(), ans.end(), cmp);
        return ans;
        
    }
};

int main(void) {
    ios_base::sync_with_stdio(false);

    Solution s;
    vector<string> logs{
    /*"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"*/
    "dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"
    };
    vector<string> ans = s.reorderLogFiles(logs);
    for(auto tmp : ans) {
        cout << tmp << endl;
    }
    return 0;
}
