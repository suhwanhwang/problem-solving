#include <bits/stdc++.h>

using namespace std;
typedef long long ll;

int main(int argc, char* argv[]) {
    int x1, y1, x2, y2;
    int x, y;

    cin >> x1 >> y1 >> x2 >> y2;
    cin >> x >> y;

    int dx = abs(x2 - x1);
    int dy = abs(y2 - y1);

    if (dx % x != 0 || dy % y != 0) {
        cout << "NO" << endl;
    } else {
        int qx = dx / x;
        int qy = dy / y;
        
        if ((qx % 2 == 0 && qy % 2 == 0) ||
        (qx % 2 == 1 && qy % 2 == 1)) {
            cout << "YES" << endl;
        } else {
            cout << "NO" << endl;
        }
    }

    return 0;
}