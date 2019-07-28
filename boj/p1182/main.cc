#include <iostream>
#include <algorithm>
#include <vector>
#include <numeric>
#include <unordered_set>
#include <cstdlib>
#include <ctime>

using namespace std;

int total_count;
int N, S;
void solve(vector<int> &nums, int index, vector<int> &select) {
    if (index >= nums.size()){
        if (select.size() > 0 && accumulate(select.begin(), select.end(), 0) == S) {
            total_count++;
        }
        return;
    }
    
    solve(nums, index + 1, select);
    select.push_back(nums[index]);
    solve(nums, index + 1, select);
    select.pop_back();
}

int main(void) {
    ios_base::sync_with_stdio(false);

    cin >> N >> S;

    vector<int> nums(N);
    for (int i = 0; i < N; ++i) {
        cin >> nums[i];
    }
    
    vector<int> select;
    solve(nums, 0, select);
    cout << total_count << endl;
    
    return 0;
}