#include <bits/stdc++.h>
using namespace std;

int year;

int main() {
    ios_base::sync_with_stdio; cin.tie(NULL);
    
    cin >> year;
    
    if(year % 4 != 0) {
        cout << 0;
        return 0;
    }
    
    if(year % 100 != 0 || year % 400 == 0) {
        cout << 1;
        return 0;
    }
    
    cout << 0;
    return 0;
}