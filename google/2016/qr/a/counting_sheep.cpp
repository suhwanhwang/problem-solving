// problema.cpp : 콘솔 응용 프로그램에 대한 진입점을 정의합니다.
//

#include <algorithm>
#include <bitset>
#include <fstream>
#include <iostream>
#include <string>

using namespace std;
const unsigned int FULL_NUM = 1024 - 1;

unsigned int getBitNum(int num) {
    unsigned int bitNum = 0;
    for (int i = 1; num > 0; ++i) {
        bitNum |= (1 << (num % 10));
        num /= 10;
    }
    return bitNum;
}

string solve(int n) {
    if (n == 0) {
        return "INSOMNIA";
    }

    unsigned int bitNum = 0;
    for (int i = 1;; ++i) {
        int num = n * i;
        bitNum |= getBitNum(num);
        if (bitNum == FULL_NUM) {
            // cout << num << endl;
            return to_string(num);
        }
    }

    return "";
}

int main(int argc, char *argv[]) {
    // ifstream fin(argv[1]);
    // ofstream fout(argv[2]);
    // // optional performance optimizations    
    // ios_base::sync_with_stdio(false);
    // cin.tie(0);

    // cin.rdbuf(fin.rdbuf());
    // cout.rdbuf(fout.rdbuf());

    int T;
    cin >> T;
    for (int c = 1; c <= T; ++c) {
        int n;
        cin >> n;
        cout << "Case #" << c << ": " << solve(n) << endl;
    }

    return 0;
}
