#include <bits/stdc++.h>
using namespace std;

int N;
vector<pair<int, string>> v;

bool compare(pair<int, string> p1, pair<int, string> p2) {
    return p1.first < p2.first;
}

int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    
    cin >> N;
    int age;
    string name;
    for(int i=0; i<N; i++) {
        cin >> age >> name;
        v.push_back(make_pair(age, name));
    }
    stable_sort(v.begin(), v.end(), compare);
    for(int i=0; i<v.size(); i++) {
        cout << v[i].first << " " << v[i].second << '\n';
    }
    return 0;
}