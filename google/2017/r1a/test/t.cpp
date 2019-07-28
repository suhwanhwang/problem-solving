#include <bits/stdc++.h>

using namespace std;

int main() {
  string s = "???a???";

  auto a = s.find_first_not_of('?');
  for (auto it = s.begin(); it != a; ++it) {
    *it = *a;
  }
  cout << s << "\n";
  return 0;
}
