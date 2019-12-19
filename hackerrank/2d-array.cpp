#include <iostream>
#include <vector>

using namespace std;

// 0 1 2
//   1
// 0 1 2
int hourglassSum(vector<vector<int>> arr) {
	int max_sum = -987654321;
	
	for(int i = 0; i <= arr.size() - 3; ++i) {
		for(int j = 0; j <= arr[i].size() - 3; ++j) {
			int sum = 0;
			sum+= arr[i][j] + arr[i][j+1] + arr[i][j+2];
			sum+= arr[i+1][j+1];
			sum+= arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
			max_sum = max(max_sum, sum);
		}
	}
	return max_sum;
}