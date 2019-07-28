#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

void printSolution(const string &s) {
    string last;
    last = s[0];
    for (int i = 1; i < s.size(); ++i) {
        if (s[i] >= last[0]) {
            last.insert(0, 1, s[i]);
        } else {
            last.append(1, s[i]);
        }
    }

    cout << last << endl;
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <=t; ++i) {
        string s;
        cin >> s;
        cout << "Case #" << i << ": ";
        printSolution(s);        
    }
    return 0;
}
