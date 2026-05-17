class Solution {
  // Approach: Sorting + Two Pointers
    // Time Complexity: O(n log n)
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int [][]newArray = new int[n][2];
        for(int i= 0;i<n;i++){
            newArray[i][0]=nums[i];
            newArray[i][1]=i;
        }
        Arrays.sort(newArray,(a,b)-> Integer.compare(a[0],b[0]));
        int left=0;
        int right=n-1;
        while(left<right){
            int sum = newArray[left][0]+newArray[right][0];
            if(sum==target){
                return new int [] {newArray[left][1],newArray[right][1]};
            }
            else if(sum<target){
                left++;
            }
            else if(sum>target){
                right--;
            }
        }
        return new int [] {-1,-1};
    }
}
