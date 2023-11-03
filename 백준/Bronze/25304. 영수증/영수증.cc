#include <bits/stdc++.h>
using namespace std;

long X, sum;
int N, a, b;
vector<pair<int, int>> v;

int main() {
    ios_base::sync_with_stdio; cin.tie(NULL);
    
    cin >> X >> N;
    for(int i=0; i<N; i++) {
        cin >> a >> b;
        v.push_back(make_pair(a, b));
    }
    
    for(int i=0; i<v.size(); i++) {
        sum += v[i].first * v[i].second;
    }
    
    if(sum == X) cout << "Yes";
    else cout << "No";
    
    return 0;
}