#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int solve_bt(int n, int p, const vector<int>& g) {
    vector<int> temp = g;
    vector<int> order;
    sort(temp.begin(), temp.end());
    int max_ans = 0;
    do {
        int ans = 1;
        int sum = 0;
        for (int i = 0; i < (int)temp.size() - 1; ++i) {
            sum += temp[i];
            if (sum % p == 0) {
                ans++;
            }
        }
        if (max_ans < ans) {
            max_ans = ans;
            order = temp;
        }
    } while(next_permutation(temp.begin(), temp.end()));

    for (auto o : order) {
        cerr << o << " ";
    }
    cerr << endl;
    return max_ans;
}

int solve1(int n, int p, const vector<int>& g) {
    vector<bool> remain(n, true);
    int ans = 0;

    // one
    for (int i = 0; i < (int)g.size(); ++i) {
        if (g[i] % p == 0) {
            remain[i] = false;
            ans++;
        }
    }

    // two
    for (int i = 0; i < (int)g.size(); ++i) {
        if (!remain[i]) {
            continue;
        }
        for (int j = i + 1; j < (int)g.size(); ++j) {
            if (!remain[j]) {
                continue;
            }
            if ((g[i] + g[j]) % p == 0) {
                remain[i] = false;
                remain[j] = false;
                ans++;
                break;
            }
        }
    }

    // three
    if (p >= 3) {
        for (int i = 0; i < (int)g.size(); ++i) {
            if (!remain[i]) {
                continue;
            }
            for (int j = i + 1; j < (int)g.size(); ++j) {
                if (!remain[j]) {
                    continue;
                }
                bool bfind = false;
                for (int k = j + 1; k < (int)g.size(); ++k) {
                    if (!remain[k]) {
                        continue;
                    }
                
                    if ((g[i] + g[j] + g[k]) % p == 0) {
                        remain[i] = false;
                        remain[j] = false;
                        remain[k] = false;
                        ans++;
                        bfind = true;
                        break;
                    }
                }
                if (bfind) {
                    break;
                }
            }
        }
    }

    int c = 0;
    for (auto r : remain) {
        if (r) {
            c++;
        }
    }
    if (c > 0) {
        ans++;
    }
    return ans;
}

int solve(int n, int p, const vector<int>& g) {
    vector<int> remain(p, 0);
    int ans = 0;
    for (int i = 0; i < (int)g.size(); ++i) {
        int r = g[i] % p;
        remain[r]++;
    }

    // remain == 0
    if (p == 2) {
        ans = remain[0] + remain[1] / 2;

        remain[0] = 0;
        remain[1] %= 2;
    } else if (p == 3) {
        ans = remain[0];
        remain[0] = 0;

        // 1 + 2
        int temp = min(remain[1], remain[2]);
        ans += temp;
        remain[1] -= temp;
        remain[2] -= temp;

        // 1 + 1 + 1
        temp = remain[1] / 3;
        ans += temp;
        remain[1] %= 3;

        // 2 + 2 + 2
        temp = remain[2] / 3;
        ans += temp;
        remain[2] %= 3;
    } else if (p == 4) {
        ans = remain[0];
        remain[0] = 0;

        // 1 + 3
        int temp = min(remain[1], remain[3]);
        ans += temp;
        remain[1] -= temp;
        remain[3] -= temp;

        // 2 + 2
        temp = remain[2] / 2;
        ans += temp;
        remain[2] %= 2;

        // 1 + 1 + 2
        if (remain[2] == 1 && remain[1] >= 2) {
            ans++;
            remain[2] = 0;
            remain[1] -= 2;
        }

        // 1 + 1 + 1 + 1
        temp = remain[1] / 4;
        ans += temp;
        remain[1] %= 4;

        // 3 + 3 + 3 + 3
        temp = remain[3] / 4;
        ans += temp;
        remain[3] %= 4;
    }

    for (auto r : remain) {
        if (r > 0) {
            ans++;
            break;
        }
    }

    return ans;
}

vector<int> getRandom(int n) {
    vector<int> r;

    for (int i = 0; i < n; ++i) {
        r.push_back(rand() % 100 + 1);
    }
    return r;
}

void test(void) {
    srand(time(nullptr));

    for (int i = 0; i < 1000; ++i) {
        int n = 9;
        int p = rand() % 1 + 2;
        vector<int> g = getRandom(n);

        int s1 = solve_bt(n, p, g);
        int s2 = solve(n, p, g);
        if (s1 == s2) {
            cerr << ".";
        }
        assert(s1 == s2);
    }

}
int main(int argc, char* argv[]) {
    // test();
    // return 0;

    int t;

    cin >> t;

    for (int i = 1; i <=t; ++i) {
        int n, p;
        cin >> n >> p;

        vector<int> g(n);
        for (int j = 0; j < n; ++j) {
            cin >> g[j];
        } 
        cout << "Case #" << i << ": ";
        cout << solve(n, p, g) << endl;
    }
    return 0;
}