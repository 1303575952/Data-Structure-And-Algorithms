#include <iostream>
#include <vector>
#include <cassert>

using namespace std;

// 167. Two Sum II - Input array is sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
//
// 暴力枚举法
// 时间复杂度: O(n^2)
// 空间复杂度: O(1)
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {

        assert(numbers.size() >= 2);
        // assert(isSorted(numbers));

        for(int i = 0 ; i < numbers.size() ; i ++)
            for(int j = i+1 ; j < numbers.size() ; j ++)
                if(numbers[i] + numbers[j] == target){
                    int res[2] = {i+1, j+1};
                    return vector<int>(res, res+2);
                }

        throw invalid_argument("the input has no solution");
    }

private:
    bool isSorted(const vector<int>& numbers){
        for(int i = 1 ; i < numbers.size() ; i ++)
            if(numbers[i] < numbers[i-1])
                return false;
        return true;
    }
};

int main() {

    int nums[] = {2, 7, 11, 15};
    vector<int> vec(nums, nums + sizeof(nums) / sizeof(int));
    int target = 9;

    vector<int> res = Solution().twoSum(vec, target);
    for(int i = 0 ; i < res.size() ; i ++)
        cout << res[i] << " ";
    cout << endl;

    return 0;
}