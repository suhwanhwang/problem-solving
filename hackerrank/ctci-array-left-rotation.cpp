// https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem

vector<int> rotLeft(vector<int> a, int d) {
	int len = a.size();
	vector<int> ans(len);
	copy(a.begin()+d,a.end(),ans.begin());
	copy(a.begin(), a.begin()+d, ans.begin()+ (len - d));
	return ans;
}