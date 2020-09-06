#include<bits/stdc++.h>
using namespace std;

int solution(vector<int>& A){
    sort(A.begin(), A.end());
    int first = 0, last = A.size() - 1;

    while(first < last) {
        if (A[first] == -A[last]) { // given =, change to ==
            return A[last];
        }

        if (A[first] > -A[last]) {
            last -= 1;
        } else {
            first += 1;
        }
    }

    return 0;
}

int main() {
    vector<int> nums = {4, -4, 3, -3, 2};
    cout << solution(nums) << endl;
    nums = {-2, 0, 0, -3};
    cout << solution(nums) << endl;
    nums = {-8, 4, -6, -2, 6, 5};
    cout << solution(nums) << endl;
    nums = {-4};
    cout << solution(nums) << endl;
    nums = {0, 0};
    cout << solution(nums);
    nums = {-13, -3, -2, -1, 0, 0, 1, 3, 4, 9, 11, 12, 13};
    cout << solution(nums);
}