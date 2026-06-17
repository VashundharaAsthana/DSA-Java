//LeetCode-35->Search Insert Position
//Binary Search
//TC-O(log N)
//SC-O(1)
//Difficulty-easy
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(target==nums[mid]){
                return mid;
            }
            if(target>nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
}
