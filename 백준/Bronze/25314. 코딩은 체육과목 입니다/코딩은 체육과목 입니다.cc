#include <bits/stdc++.h>
using namespace std;

int N;

int main() {
    ios_base::sync_with_stdio; cin.tie(NULL);
    
    cin >> N;
    int loop = N / 4;
    string answer = "";
    for(int i=0; i<loop; i++) {
        answer += "long ";
    }
    answer += "int";
    
    cout << answer;
    
    return 0;
}