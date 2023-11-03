#include <bits/stdc++.h>
using namespace std;

int n, sum;

int main() {
    ios_base::sync_with_stdio; cin.tie(NULL);
    
    cin >> n;

    for(int i=1; i<=n; i++) {
        sum += i;
    }
    cout << sum;
    
    return 0;
}