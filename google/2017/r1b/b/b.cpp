#include <bits/stdc++.h>

using namespace std;
typedef long long ll;
int N, R, O, Y, G, B, V;
char s_color[] = {'R', 'Y', 'B'};

void printSolution(void) {
    string output;
    vector<int> u{R, Y, B};

    int cur = 0;
    while((int)output.size() < N) {
        if (u[cur] > 0) {
            if ((output.empty() || output.back() != s_color[cur])
            && ((int)output.size() != N - 1 || output.front() != s_color[cur])) {
                output += s_color[cur];
                u[cur]--;
            } else {
                bool isFound = false;
                for (int i = 0; i < (int)output.size(); ++i) {
                    if (output[i] != s_color[cur] && (i == 0 || output[i - 1] != s_color[cur])) {
                        if ((int)output.size() == N - 1 
                        && ((i != 0 && output.front() == output.back()) || (i == 0 && output.back() == s_color[cur]))) {
                            continue;
                        }
                        output.insert(i, 1, s_color[cur]);
                        u[cur]--;
                        isFound = true;
                        break;
                    }
                }
                if (isFound == false) {
                    cout << "IMPOSSIBLE\n";
                    return;
                }
            }
        }
        cur = (cur + 1) % u.size();
    }

    cout << output << endl;
}

int main(int argc, char* argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <=t; ++i) {
        cin >> N >> R >> O >> Y >> G >> B >> V;

        cout << "Case #" << i << ": ";
        printSolution();        
    }
    return 0;
}