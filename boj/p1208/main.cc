#include <iostream>
#include <algorithm>
#include <vector>
#include <numeric>
#include <unordered_map>
#include <cstdlib>
#include <ctime>

using namespace std;

typedef long long ll;

ll total_count;
int N, S;
unordered_map<int, int> sum_map;

int total_count1;
void solve1(vector<int> &nums, int index, vector<int> &select) {
    if (index >= nums.size()){
        if (select.size() > 0 && accumulate(select.begin(), select.end(), 0) == S) {
            total_count1++;
            // cout << total_count1 << ": ";
            // for (int n : select) {
            //     cout << n << " ";
            // }
            // cout << endl;
        }
        return;
    }
    
    solve1(nums, index + 1, select);
    select.push_back(nums[index]);
    solve1(nums, index + 1, select);
    select.pop_back();
}

void makeMap(const vector<int> &nums, int index, vector<int> &select) {
    if (index >= nums.size()){
        int sum = accumulate(select.begin(), select.end(), 0);
        if (select.size() > 0) {
            sum_map[sum]++;
        }
        return;
    }
    
    makeMap(nums, index + 1, select);
    select.push_back(nums[index]);
    makeMap(nums, index + 1, select);
    select.pop_back();
}

void print(const vector<int> &v) {
    cout << total_count << ": ";
    for (int n : v) {
        cout << n << " ";
    }
    cout << endl;
}

void solve(const vector<int> &nums, int index, vector<int> &select) {
    if (index >= nums.size()){
        int sum = accumulate(select.begin(), select.end(), 0);
        if (sum_map.count(S - sum) > 0) {
            total_count += sum_map[S - sum];
            //print(select);
        } 
        
        if (sum == S && select.size() > 0) {
            total_count++;
            //print(select);
        }
        
        return;
    }
    
    solve(nums, index + 1, select);
    select.push_back(nums[index]);
    solve(nums, index + 1, select);
    select.pop_back();
}

void solve(const vector<int> &nums) {
    vector<int> select;
    vector<int> half1(nums.begin(), nums.begin() + (N/2)), 
    half2(nums.begin() + (N/2), nums.end());
    
    sum_map.clear();
    total_count = 0;

    makeMap(half1, 0, select);
    // cout << "sum_map" << endl;
    // for (auto p : sum_map) {
    //     cout << p.first << " " << p.second << endl;
    // }
    select.clear();
    
    solve(half2, 0, select);

    cout << total_count << endl;
}

void test() {
    srand(time(NULL));
    for (int j = 0; j < 10000; ++j) {
        N = 10;
        S = (rand() % 1000);
        vector<int> nums;

        for (int i = 0; i < N; ++i) {
            int num = (rand() % 100);
            nums.push_back(num);
        }
        vector<int> select;
        total_count1 = 0;
        solve1(nums, 0, select);

        solve(nums);
        if (total_count1 != total_count) {
            cout << N << " " << S << endl;
            for (int n : nums) {
                cout << n << " ";
            }
            cout << endl;
        }
    }
}

int main(void) {
    ios_base::sync_with_stdio(false);

    //test();

    vector<int> nums;

    cin >> N >> S;
    
    nums.resize(N);
    for (int i = 0; i < N; ++i) {
        cin >> nums[i];
    }

    solve(nums);

    return 0;
}