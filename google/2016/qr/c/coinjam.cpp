#include <iostream>
#include <algorithm>
#include <string>
#include <cmath>
#include <bitset>

using namespace std;

bool isPrime(int num) {
	bool isprime = false;
	for(int i = 2; i <= sqrt(num); i += 2) {
		if(i % 2 == 0)
			i++;

		if((num % i) == 0) {
			isprime = true;
			break;
		}
	}

	return isprime;
}

int solve(int n, int j) {
    // coin 
    // 10...01
    for (int i = 2; i <= 2; ++i) {
        int base_num = 1 + pow(i, n - 1);
        int mid_max = pow(i, n - 1 - 1);
        for (int j = 0; j < mid_max; ++j) {
            int jamcoin = base_num + j * i;
            cout << bitset<16>(jamcoin) << endl;
        }
    }
    return 0;
}

int main(void) {
    int T;
    cin >> T;

    for (int i = 1; i <= T; ++i) {
        int n, j;
        cin >> n >> j;
        cout << "Case #" << i << ":" << endl;
        solve(n, j);
    }
    return 0;
}