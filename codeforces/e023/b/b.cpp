#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

ll comb(ll n, ll k) {
    ll ans = 1;
    for (ll i = n; i > k; --i) {
        ans *= i;
    }

    for (ll i = n - k; i > 0; --i) {
        ans /= i;
    }
    return ans;
}

int main(int argc, char* argv[]) {
    int n;
    cin >> n;

    map<ll, ll> a;
    for (int i = 0; i < n; ++i) {
        int temp;
        cin >> temp;
        a[temp] += 1;
    }
    auto first = a.begin();
    if (first->second >= 3) {
        cout << comb(first->second, 3) << endl;
        return 0;
    }

    auto second = a.begin();
    second++;
    if (first->second + second->second >= 3) {
        cout << comb(second->second, 3 - first->second) << endl;
        return 0;
    }

    auto third = a.begin();
    third++;
    third++;
    cout << third->second << endl;   

    return 0;
}