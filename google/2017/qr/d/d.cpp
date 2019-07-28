#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <cassert>
#include <ctime>

using namespace std;

void printSolution(void) {

}

void test(void) {
    for (int i = 1; i <= 10000; ++i) {
        cerr << i << " : ";
        cerr << "OK" << endl;
    }
}

int main(int argc, char *argv[]) {
    // test();
    // return 0;

    clock_t tick = clock();
    int t;

    cin >> t;
    for (int i = 1; i <= t; ++i) {
        int n, k;
        cin >> n >> k;
        cout << "Case #" << i << ": ";
        printSolution();
    }

    cerr << "time = " << clock() - tick << endl;
    return 0;
}