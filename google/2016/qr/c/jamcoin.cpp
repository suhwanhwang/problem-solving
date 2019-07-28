#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

long long getBaseNum(long long n, int base) {
    if (n == 0) {
        return 0;
    }

    return base * getBaseNum(n>>1, base) + (n % 2);
}

long long getFactor(long long n) {
    for (long long i = 3)
}

void printJamCoins(int n, int j) {
    int count = 0;

    for (long long i = (1 << (n - 1)) + 1; count < j; i += 2) {
        vector<long long> factors;
        for (int base = 2; base <= 10; ++base) {
            long long num = getBaseNum(i, base);
            
        }
        
    }
}

int main(void) {
    int T;

    cin >> T;
    for (int i = 1; i <= T; ++i) {
        int n, j;
        cin >> n >> j;
        cout << "Case #" << i << ":" << endl;
        printJamCoins(n, j);
    }

    return 0;
}