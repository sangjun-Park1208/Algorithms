#include <bits/stdc++.h>
using namespace std;

int T, A, B;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    
    cin >> T;
    for(int i=1; i<=T; i++) {
        cin >> A >> B;
        cout << "Case #" << i << ": " << A << " + " << B << " = " << A+B << '\n';
    }
    
    return 0;
}