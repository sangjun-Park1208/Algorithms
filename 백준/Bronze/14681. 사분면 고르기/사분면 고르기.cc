#include <bits/stdc++.h>
using namespace std;

int x, y;

int main() {
    ios_base::sync_with_stdio; cin.tie(NULL);
    
    cin >> x >> y;
    
    if(x > 0 && y > 0) cout << 1;
    else if(x < 0 && y > 0) cout << 2;
    else if(x < 0 && y < 0) cout << 3;
    else  cout << 4;
    
    
    return 0;
}