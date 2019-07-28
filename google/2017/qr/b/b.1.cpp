#include <iostream>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

bool isTidy(long long num) {
    long long base = 10;

    int prev = num % 10;
    for (int i = 1; i <= 18 && base <= num; ++i, base *= 10) {
        int cur = (num / base) % 10;
        if (cur > prev) {
            return false;
        }
        prev = cur;
    }
    return true;
}

void printSolution(long long n) {
    for (long long t = n; t >= 1; --t) {
        if (isTidy(t)) {
            cout << t << endl;
            return;
        }
    }
}
int main(int argc, char *argv[]) {
    int t;

    cin >> t;
    for (int i = 1; i <= t; ++i) {
        long long n;
        cin >> n;
        cout << "Case #" << i << ": ";
        printSolution(n);
    }

    return 0;
}