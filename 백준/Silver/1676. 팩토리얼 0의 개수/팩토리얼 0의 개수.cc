#include <bits/stdc++.h>
using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    
    cin >> N;
    int answer = 0;
    while(N >= 5) {
        answer += N/5;
        N /= 5;
    }

    cout << answer;
    return 0;
}