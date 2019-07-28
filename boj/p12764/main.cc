#include <iostream>
#include <algorithm>
#include <vector>
#include <numeric>
#include <unordered_map>
#include <set>
#include <functional>
#include <queue>
#include <cstdlib>
#include <ctime>

using namespace std;

typedef long long ll;

void solve(vector<pair<int, int>> &users) {
    sort(users.begin(), users.end());

    priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int,int>>> user_pq; //end time, pc num;
    priority_queue<int, vector<int>, greater<int>> empty_pq;
    vector<int> count;
    int max_pc = 0;
    for (int i = 0; i < (int)users.size(); ++i) {
        int start = users[i].first;
        int end = users[i].second;

        // check finished user
        while(!user_pq.empty()) {
            auto p = user_pq.top();
            if (p.first > start) {
                break;
            }
            empty_pq.push(p.second);
            user_pq.pop();
        }
        
        // find next empty pc
        int next;
        if (empty_pq.empty()) {
            next = user_pq.size() + 1;
            max_pc = max(max_pc, next);
        } else {
            next = empty_pq.top(); 
            empty_pq.pop();
        }

        if (next > count.size()) {
            count.push_back(0);
        }
        count[next - 1]++;
        user_pq.push({end, next});
    }
    cout << max_pc << endl;
    for (int used : count) {
        cout << used << " ";
    }
    cout << endl;
}

int main(void) {
    ios_base::sync_with_stdio(false);

    int n;
    cin >> n;

    vector<pair<int, int>> users(n);
    for (int i = 0; i < n; ++i) {
        cin >> users[i].first >> users[i].second;
    }

    solve(users);
    return 0;
}