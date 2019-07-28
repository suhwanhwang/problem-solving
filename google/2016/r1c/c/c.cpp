#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

void printSolution2(int J, int P, int S, int K) {
    map<pair<int, int>, int> JP;
    map<pair<int, int>, int> JS;
    map<pair<int, int>, int> PS;
    vector<string> output;
    int count = 0;
    for (int j = 1; j <= J; ++j) {
        for (int p = 1; p <= P; ++p) {
            for (int s = 1; s <= S; ++s) {
                if (JP[make_pair(j, p)] < K && JS[make_pair(j, s)] < K &&
                    PS[make_pair(j, p)] < K) {
                    output.push_back(to_string(j) + " " + to_string(p) + " " +
                                     to_string(s));
                    JP[make_pair(j, p)]++;
                    JS[make_pair(j, s)]++;
                    PS[make_pair(p, s)]++;
                    count++;
                }
            }
        }
    }

    cout << count << "\n";
    for (string s : output) {
        cout << s << "\n";
    }
}

void printSolution(int J, int P, int S, int K) {
    cout << J * P * min(S, K) << "\n";
    // map<pair<int, int>, int> JP;
    // map<pair<int, int>, int> JS;
    // map<pair<int, int>, int> PS;

    
    for (int j = 1; j <= J; ++j) {
        int s = j;
        for (int p = 1; p <= P; ++p) {
            for (int k = 1; k <= min(S, K); ++k) {
                cout << j << " " << p << " " << s << "\n";
                // JP[make_pair(j, p)]++;
                // JS[make_pair(j, s)]++;
                // PS[make_pair(p, s)]++;
                // assert(JP[make_pair(j, p)] <= K && JS[make_pair(j, s)] <= K &&
                //     PS[make_pair(j, p)] <= K);
                s++;
                if (s > S) {
                    s = 1;
                }
            }
        }
    }
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        int J, P, S, K;
        cin >> J >> P >> S >> K;
        cout << "Case #" << i << ": ";
        printSolution(J, P, S, K);
    }
    return 0;
}