#include <bits/stdc++.h>
using namespace std;

int A, B, C;

int main() {
    ios_base::sync_with_stdio; cin.tie(NULL);
    cin >> A >> B >> C;
    cout << (A+B)%C << '\n' << ((A%C) + (B%C)) % C << '\n' << (A*B)%C << '\n' << ((A%C)*(B%C))%C;
}