#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_set>
#include <cstdlib>
#include <ctime>

using namespace std;

int solve(vector<int> cards) {
    sort(cards.begin(), cards.end());
    
    int a = cards[cards.size() - 1];
    int b = cards[cards.size() - 2];
    int c = cards[cards.size() - 3];
    int d = cards[2];
    int e = cards[1];
    int f = cards[0];
    int m = max(a*b, a*b*c);
    m = max(m, max(f*e, f*e*a)); // - -
    return m;
}

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> cards(n);
    for (int i = 0; i < n; ++i) {
        cin >> cards[i];
    }

    cout << solve(cards) << endl;
    
    return 0;
}