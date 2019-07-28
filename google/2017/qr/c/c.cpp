#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <map>
#include <cassert>
#include <ctime>

using namespace std;

typedef long long ll;

pair<ll, ll> solution2(ll n, ll k) {
    auto cmp = [](pair<ll, ll> l, pair<ll, ll> r) {
        return l.second - l.first < r.second - r.first;
    };

    priority_queue<pair<ll, ll>, vector<pair<ll, ll>>,  decltype(cmp)> pq(cmp);
    pq.push(make_pair(0, n - 1));

    int mid;
    int ls;
    int rs;

    for (ll i = 0; i < k; ++i) {
        auto t = pq.top();
        pq.pop();
        
        mid = (t.first + t.second) / 2;
        ls = mid - t.first;
        rs = t.second - mid;
        if (ls > 0) {
            pq.push(make_pair(t.first, mid - 1));
        }
        if (rs > 0) {
            pq.push(make_pair(mid + 1, t.second));
        }
    }
    //cout << max(ls, rs) << " " << min(ls, rs) << endl;
    return make_pair(max(ls,rs), min(ls,rs));
}

pair<ll, ll> solution3(ll n, ll k) {
    ll ls, rs;
    priority_queue<ll> q;
    q.push(n);

    for (ll i = 0; i < k; ++i) {
        ll f = q.top();
        q.pop();
        if (f == 0) {
            rs = ls = 0;
            break;
        }
        rs = (f - 1) / 2;
        ls = rs + (f - 1) % 2;
        q.push(ls);
        q.push(rs);
    }

    //cout << ls << " " << rs << endl;
    return make_pair(ls, rs);
}

pair<ll, ll> solution4(ll n, ll k) {
    ll ls, rs;
    ll last_i = 0;
    pair<ll, ll> prev0 = make_pair(n, 1);
    pair<ll, ll> prev1 = make_pair(n - 1, 0);

    for (ll i = 1; i <= k / 2; i *= 2) {
        ll n0 = prev0.first;
        ll c0 = prev0.second;
        ll n1 = prev1.first;
        ll c1 = prev1.second;

        ll next1 = (n0 - 1) / 2;
        ll next0 = (n0 - 1) - next1;
        if (next0 == next1) {
            prev0.first = next0;
            prev0.second = c0 * 2;
            prev1.first = next0 - 1;
            prev1.second = 0;
        } else {
            prev0.first = next0;
            prev0.second = c0;
            prev1.first = next1;
            prev1.second = c0;
        }

        if (c1 > 0) {
            next1 = (n1 - 1) / 2;
            next0 = (n1 - 1) - next1;
            if (next0 == next1) {
                prev1.second += c1 * 2;
            } else {
                prev0.second += c1;
                prev1.second += c1;
            }
        }
        last_i = i;
    }
    if (last_i == 0) {
        rs = (n - 1) / 2;
        ls = (n - 1) - rs;
    } else {
        ll offset = k - last_i * 2;
        if (offset < prev0.second) {
            rs = (prev0.first - 1) / 2;
            ls = (prev0.first - 1) - rs;
        } else {
            rs = (prev1.first - 1) / 2;
            ls = (prev1.first - 1) - rs;
        }
    }

    return make_pair(ls, rs);
}

pair<ll, ll> solution(ll n, ll k) {
    map<ll, ll, greater<ll>> m; 
    m[n] = 1;
    ll pos = 0;
    while(true) {
        auto top = m.begin();
        ll rs = (top->first - 1) / 2;
        ll ls = (top->first - 1) - rs;
        pos += top->second;

        if (pos >= k) {
            return make_pair(ls, rs);
        } else {
            m[ls] += top->second;
            m[rs] += top->second;
            m.erase(top);
        }
    }
    assert("Not found");
}

void printSolution(ll n, ll k) {
    pair<ll, ll> ans = solution(n, k);
    cout << ans.first << " " << ans.second << endl;
}

void test(void) {
    for (ll i = 1; i <= 10000; ++i) {
        cerr << i << " : ";
        for (ll j = 1; j <= i; ++j) {
            pair<ll, ll> ans = solution(i, j);
            pair<ll, ll> ans3 = solution3(i, j);
            assert(ans == ans3);
        }
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
        ll n, k;
        cin >> n >> k;
        cout << "Case #" << i << ": ";
        printSolution(n, k);
    }

    cerr << "time = " << clock() - tick << endl;
    return 0;
}