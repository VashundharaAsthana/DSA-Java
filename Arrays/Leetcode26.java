// Remove Duplicates from Sorted Array
// TC=O(n)
// sc=O(1) no extra space used
class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length-1;
        int i=0;
        for(int j=1;j<=n;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
}
//to return the no of unique elements without using a new Data Structure(in-place) , so we compare elements, if unique element found we store it in the input array: 
            // if(nums[i]!=nums[j]){
            //  i++;
            //  nums[i]=nums[j];
            // } 
// else we keep moving forward , at last we return the number of unique elements that is i+1.
// The remaining elements beyond index i - 1 can be ignored.
