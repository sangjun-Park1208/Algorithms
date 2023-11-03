#include <bits/stdc++.h>
using namespace std;

int A, B, consume;

int main() {
    ios_base::sync_with_stdio; cin.tie(NULL);
    
    cin >> A >> B >> consume;
    
    int hour = consume / 60;
    int minute = consume % 60;
    
    if(B + minute >= 60) {
        if(A+1+hour >= 24) cout << A+1+hour-24 << " " << B+minute-60;
        else cout << A+1 + hour << " " << B+minute-60;
    } else {
        if(A+hour >= 24) cout << A + hour - 24 << " " << B+minute;
        else cout << A + hour << " " << B+minute;
    }
    
    
    return 0;
}