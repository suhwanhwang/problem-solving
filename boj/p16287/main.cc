#include <iostream>
#include <vector>
#include <unordered_set>
#include <cstdlib>
#include <ctime>

using namespace std;

bool solve(int w, const vector<int> &parcel) {
    unordered_set<int> set;
    
    // 0 1 2 3
    // a b c d
    for (int i = 2; i < parcel.size() - 1; ++i) {
        for (int j = 0; j < i - 1; ++j) {
            set.insert(parcel[j] + parcel[i - 1]);
        }
        for (int j = i + 1; j < parcel.size(); ++j) {
            if (set.count(w - (parcel[i] + parcel[j])) > 0) {
                return true;
            }
        } 
    }
    /*
    for (int i = 0; i < parcel.size() - 3; ++i) {
        for (int j = i + 1; j < parcel.size() - 2; ++j) {
            set.insert(parcel[j] + parcel[i - 1]);
        
            for (int k = j + 2; j < parcel.size(); ++j) {
                if (set.count(w - (parcel[j + 1] + parcel[k])) > 0) {
                    return true;
                }
            }
        }
    }
    */
    return false;
}

void test() {
    clock_t tick = clock();
    srand (time(NULL));
    int w = rand() % 800000 + 1;
    vector<int> p(5000);
    
    for(int i = 0; i < 5000; ++i) {
        p[i] = rand() % 200000 + 1;
    }
    cout << w << endl;
    cout << (solve(w, p) ? "YES": "NO") << endl;
    cout << " time = " << (float)(clock() - tick)/CLOCKS_PER_SEC << endl;
}

int main(void) {
    test();
    return 0;

    ios_base::sync_with_stdio(false);

    int w, n;
    cin >> w >> n;

    vector<int> parcel(n);
    for (int i = 0; i < n; ++i) {
        cin >> parcel[i];
    }

    cout << (solve(w, parcel) ? "YES": "NO") << endl;
    
    return 0;
}