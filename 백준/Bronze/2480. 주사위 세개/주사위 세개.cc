#include <bits/stdc++.h>
using namespace std;

int A, B, C;

int main() {
    ios_base::sync_with_stdio; cin.tie(NULL);
    
    cin >> A >> B >> C;

    if(A==B && B==C) {
        cout << 10000 + A*1000;
    } else if(A==B && B!=C) {
        cout << 1000 + A*100;
    } else if(A==C && A!=B) {
        cout << 1000 + C*100;
    } else if(B==C && A!=C) {
        cout << 1000 + B*100;
    } else {
        cout << max(A, max(B, C)) * 100;
    }
    
    return 0;
}