#include <bits/stdc++.h>
using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    
    cin >> N;
    
    for(int i=1; i<=N; i++) {
        for(int j=N-i; j>0; j--) cout << " ";
        for(int j=0; j<i; j++) {
            cout << '*';
        }
        cout << '\n';
    }
    
    return 0;
}