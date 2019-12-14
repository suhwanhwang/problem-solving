#include <iostream>
#include <cmath>
using namespace std;

constexpr int kmax = pow(3,8);

bool stars[kmax+1][kmax+1];

void solve(int n, int row, int col) {
   if (n == 1) {
     stars[row][col] = true;
     return;
   }
   
   int unit=n/3;
   for (int r = 0; r < 3; ++r) {
     for (int c = 0; c < 3; ++c) {
       if (r==1 && c==1) continue;
       
       solve(unit, row + r*unit, col + c*unit);
     }
   }
}

int main()
{
    int n;
    cin >> n;
    
    solve(n, 0, 0);
    
    for(int i=0; i<n; ++i){
      for(int j=0; j<n; ++j){
        cout << (stars[i][j] ? '*' : ' ');
      }
      cout << "\n";
    }
}
