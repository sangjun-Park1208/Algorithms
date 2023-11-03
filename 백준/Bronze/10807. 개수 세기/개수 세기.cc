#include <bits/stdc++.h>
using namespace std;

int N, f, a;
vector<int> v;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> a;
        v.push_back(a);
    }
    cin >> f;
    
    int answer = 0;
    
    for(int i=0; i<v.size(); i++) {
        if(v[i] == f) answer++;
    }
    
    cout << answer;

    
    return 0;
}