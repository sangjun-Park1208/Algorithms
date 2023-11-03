#include <bits/stdc++.h>
using namespace std;

int H, M;

int main() {
    ios_base::sync_with_stdio; cin.tie(NULL);
    
    cin >> H >> M;

    if(M >= 45) {
        cout << H << " " << M-45;
    } else {
        if(H == 0) cout << 23 << " " << M + 60 - 45;
        else cout << H-1 << " " << M + 60 - 45;
    }
    
    return 0;
}