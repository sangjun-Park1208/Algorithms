#include <bits/stdc++.h>
using namespace std;

int N, op;
vector<int> v;

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> op;
        switch(op) {
            case 1:
                cin >> op;
                v.push_back(op);
                break;
            case 2:
                if(v.empty()) cout << -1 << '\n';
                else {
                    cout << v.back() << '\n';
                    v.pop_back();
                }
                break;
            case 3:
                cout << v.size() << '\n';
                break;
            case 4:
                if(v.empty()) cout << 1 << '\n';
                else cout << 0 << '\n';
                break;
            case 5:
                if(v.empty()) cout << -1 << '\n';
                else cout << v.back() << '\n';
                break;
        }
    }

    
    return 0;
}