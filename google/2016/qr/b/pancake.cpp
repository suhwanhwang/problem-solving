#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>
#include <string>
#include <cassert>

using namespace std;

void flip_cake(string &cake, int len) {
    reverse(cake.begin(), cake.begin() + len);
    for (int i = 0; i < len; ++i) {
        if (cake[i] == '+') {
            cake[i] = '-';
        } else {
            cake[i] = '+';
        }
    }
}

int solve(string& cake) {
    int end = cake.size() - 1;
    int count = 0;

    while(end >= 0) {
        if (cake[end] == '+') {
            end--;
            continue;
        }

        size_t blank = cake.find_first_not_of('+');
        if (blank > end) {
            // finish
            break;
        } else {
            if (blank > 0) {
                // flip upper cakes
                flip_cake(cake, blank);
            } else {
                // flip upper cakes from end
                flip_cake(cake, end + 1);
            }
            count++;
        }
    }

    return count;
}

int main(int argc, char* argv[]) {
    ifstream fin;
    ofstream fout;
    streambuf *coutBuf = cout.rdbuf();
    streambuf *cinBuf = cin.rdbuf();

    if (argc == 3) {
        fin.open(argv[1]);
        fout.open(argv[2]);

        // optional performance optimizations    
        ios_base::sync_with_stdio(false);
        cin.tie(0);

        cin.rdbuf(fin.rdbuf());
        cout.rdbuf(fout.rdbuf());
    }

    int T;
    cin >> T;

    for (int i = 1; i <= T; ++i) {
        string cake;
        cin >> cake;
        cout << "Case #" << i << ": " << solve(cake) << endl;
    }

    if (argc == 3) {
        cin.rdbuf(cinBuf);
        cout.rdbuf(coutBuf);
        fin.close();
        fout.close();
    }

    return 0;
}