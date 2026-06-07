//LeetCode31-Next Permutation
//TC=O(n)
//Difficulty-Medium
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot=-1;
        for(int i =n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        if(pivot==-1){//edge case
            reverse(nums,0,n-1);
            return;
        }
        int swapIdx=-1;
        for(int i=n-1;i>pivot;i--){
            if(nums[i]>nums[pivot]){
                swapIdx=i;
                break;
            }
        }
        int temp=nums[pivot];
        nums[pivot]=nums[swapIdx];
        nums[swapIdx]=temp;
        reverse(nums,pivot+1,n-1);
    }
    private void reverse(int[]nums, int left, int right){//reverse function
        while(left<right){
            int temp=nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
