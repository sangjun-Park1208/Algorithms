
#include <bits/stdc++.h>
using namespace std;

vector<int> v;
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int N, M, input;
    cin >> N >> M;
    
    int sum = 0;
    v.push_back(0);
    for(int i=0; i<N; i++) {
        cin >> input;
        v.push_back(sum + input);
        sum += input;
    }
    
    int start, end;
    for(int i=0; i<M; i++) {
        cin >> start >> end;
        cout << v[end] - v[start-1] << '\n';
    }

    return 0;
}
