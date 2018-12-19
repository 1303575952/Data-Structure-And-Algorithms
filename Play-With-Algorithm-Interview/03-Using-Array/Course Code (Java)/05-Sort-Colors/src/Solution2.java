// 75. Sort Colors
// https://leetcode.com/problems/sort-colors/description/
//
// 三路快速排序的思想
// 对整个数组只遍历了一遍
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution2 {

    public void sortColors(int[] nums) {

        int zero = -1;          // [0...zero] == 0
        int two = nums.length;  // [two...n-1] == 2
        for(int i = 0 ; i < two ; ){
            if(nums[i] == 1)
                i ++;
            else if (nums[i] == 2)
                swap(nums, i, --two);
            else{ // nums[i] == 0
                assert nums[i] == 0;
                swap(nums, ++zero, i++);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int t = nums[i];
        nums[i]= nums[j];
        nums[j] = t;
    }

    public static void printArr(int[] nums){
        for(int num: nums)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 2, 1, 1, 0};
        (new Solution2()).sortColors(nums);
        printArr(nums);
    }
}
