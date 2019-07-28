#include <iostream>
#include <algorithm>

using namespace std;

void printSolution(int k, int c, int s) {
    // 123
    // 123456789
    // 0k + 1, 1k + 2, 2k + 3

    for (int i = 1; i <= k; ++i) {
        cout << " " << i;
    }
    cout << endl;
}
int main(void) {
    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        int k, c, s;
        cin >> k >> c >> s;
        cout << "Case #" << i << ":";
        printSolution(k, c, s);
    }
    return 0;
}