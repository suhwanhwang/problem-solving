#include <iostream>
#include <vector>
#include <unordered_set>
#include <cstdlib>
#include <ctime>

using namespace std;

typedef long long ll;

constexpr int MAX_N = 1000;

int box[MAX_N+1][MAX_N+1];
bool remain[MAX_N+1][MAX_N+1];

ll solve(int n, int m) {
    // side
    for (int i = 0; i < n; ++i) {
        int max = box[i][0];
        int max_index = 0;
        for (int j= 0; j < m;++j) {
            if (max < box[i][j]) {
                max = box[i][j];
                max_index = j;
            }
        }
        remain[i][max_index] = true;
    }
    
    // front
    for (int j = 0; j < m; ++j) {
        int max = box[0][j];
        int max_index = 0;
        for (int i = 0; i < n; ++i) {
            if (max < box[i][j]) {
                max = box[i][j];
                max_index = i;
            }
        }
        remain[max_index][j] = true;
    }
    
    ll sum = 0;
    for (int i = 0; i < n; ++i) {
        for (int j= 0; j < m;++j) {
            if(!remain[i][j]) {
                sum += box[i][j];
            }
        }
    }
    
    return sum;
}

/*
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
*/

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n; ++i) {
        for (int j= 0; j < m;++j) {
            cin >> box[i][j];
        }
    }

    cout << solve(n, m) << endl;
    
    return 0;
}