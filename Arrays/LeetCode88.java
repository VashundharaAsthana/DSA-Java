// Merge sorted arrays
// TC O(m+n)
// SC O(m+n)
// Level:Easy
class Solution {
     public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0; int j=0;
        List<Integer>result=new ArrayList<>();
        while(i<m && j<n){
            int currentValue;
            if(nums1[i]<=nums2[j]){
                currentValue=nums1[i];
                i++;
            }
            else{
                currentValue=nums2[j];
                j++;
            }
          
                result.add(currentValue);
              
        }
        while(i<m){
            result.add(nums1[i]);
            i++;
        }
        while(j<n){
          result.add(nums2[j]);
          j++;
        }
        for(int x=0;x<m+n;x++){
            nums1[x]=result.get(x);
        }
       
}
}
