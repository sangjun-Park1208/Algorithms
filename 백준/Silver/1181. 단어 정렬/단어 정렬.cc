#include <bits/stdc++.h>
using namespace std;

int N;
vector<string> v;
string str;

bool compare(string s1, string s2) {
    if(s1.length() == s2.length()) return s1 < s2;
    return s1.length() < s2.length();
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    
    cin >> N;
    for(int i=0; i<N; i++) {
        cin >> str;
        v.push_back(str);
    }
    sort(v.begin(), v.end(), compare);
    v.erase(unique(v.begin(), v.end()), v.end());
    
    for(int i=0; i<v.size(); i++) {
        cout << v[i] << '\n';
    }

    
    return 0;
}