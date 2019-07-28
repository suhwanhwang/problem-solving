#include <algorithm>
#include <cassert>
#include <climits>
#include <cmath>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;
typedef long long ll;

void printSolution1(const vector<pair<string, string>> &topic) {
    int max_count = 0;
    vector<int> order;
    for (int i = 0; i < topic.size(); ++i) {
        order.push_back(i);
    }

    do {
        set<string> first_set;
        set<string> second_set;
        int count = 0;
        for (int i : order) {
            auto it_f = first_set.find(topic[i].first);
            auto it_s = second_set.find(topic[i].second);
            if (it_f == first_set.end() && it_s == second_set.end()) {
                first_set.insert(topic[i].first);
                second_set.insert(topic[i].second);
            } else if (it_f != first_set.end() && it_s != second_set.end()) {
                count++;
            }
        }
        max_count = max(max_count, count);
    } while (next_permutation(order.begin(), order.end()));

    cout << max_count << endl;
}

void printSolution(const vector<pair<string, string>> &topic) {
    set<string> f_set;
    set<string> s_set;

    for (int i = 0; i < topic.size(); ++i) {
        f_set.insert(topic[i].first);
        s_set.insert(topic[i].second);
    }

    int n = topic.size();
    int max_num = (1 << n);
    int min_unfake = INT_MAX;
    set<string> f_tmp;
    set<string> s_tmp;
    for (int i = 1; i < max_num; ++i) {
        int count = 0;
        set<string> f_tmp;
        set<string> s_tmp;
        for (int j = 0; j < n; ++j) {
            if ((i >> j) & 0x1) {
                count++;
                f_tmp.insert(topic[j].first);
                s_tmp.insert(topic[j].second);
            }
        }
        if (f_tmp.size() == f_set.size() && s_tmp.size() == s_set.size()) {
            min_unfake = min(min_unfake, count);
        }
    }

    cout << n - min_unfake << endl;
}

int main(int argc, char *argv[]) {
    int t;

    cin >> t;

    for (int i = 1; i <= t; ++i) {
        int n;
        cin >> n;

        vector<pair<string, string>> topic;
        for (int j = 0; j < n; ++j) {
            string s1, s2;
            cin >> s1 >> s2;

            topic.push_back(make_pair(s1, s2));
        }

        cout << "Case #" << i << ": ";
        printSolution(topic);
    }
    return 0;
}