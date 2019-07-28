#include <iostream>
#include <vector>
#include <bitset>

using namespace std;

long long getNum(long long bitNum, int base) {
    long long num = 0;
    long long b = 1;
    for (long long n = bitNum; n > 0; n /= 2) {
        num += b * (n % 2);
        b *= base;
    }
    return num;
}

long long getFactor(long long num) {
    for (long long i = 2; i * i <= num; ++i) {
        if ((num % i) == 0) {
            return i;
        }
    }
    return 0;
}

void printJamcoin(int n, int j) {
    int count = 0;
    for (long long i = (1 << (n - 1)) + 1; j > 0; i += 2) {
        vector<long long> factors;
        for (int b = 2; b <= 10; ++b) {
            long long num = getNum(i, b);
            long long f = getFactor(num);
            if (f == 0) {
                break;
            }
            factors.push_back(f);
        }
        if (factors.size() < 9) {
            continue;
        }
        cout << getNum(i, 10);
        for (long long k : factors) {
            cout << " " << k;
        }
        cout << endl;
        j--;
    }
}

int main(void) {
    //printJamcoin(6, 4);

    int T;
    cin >> T;

    for (int i = 1; i <= T; ++i) {
        int n, j;
        cin >> n >> j;
        cout << "Case #" << i << ":" << endl;
        printJamcoin(n, j);
    }
    return 0;
}