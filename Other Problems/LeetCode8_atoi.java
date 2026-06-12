// LeetCode 8- Convert Strings to Integer
// TC-O(n)
// SC-O(n)
//difficulty-Medium
class Solution {
    public int myAtoi(String s) {
      int i=0;
      int n=s.length();
      while(i<n&&s.charAt(i)==' '){//check for empty spaces
        i++;
      }  
      if(i==n){
        return 0;
      }
      int sign=1;
      if(s.charAt(i)=='-'){//check for sign
        sign=-1;
        i++;
      }
      else if(s.charAt(i)=='+'){
        i++;
      }
      int result=0;
      while(i<n&& Character.isDigit(s.charAt(i))){//checking if character at an index is a digit or alphabet
        int digit=s.charAt(i)-'0';
        if(result>(Integer.MAX_VALUE-digit)/10){//check if adding next digit would overflow
            if(sign==1){
                return Integer.MAX_VALUE;
            }else{
                return Integer.MIN_VALUE;
            }
        }
          result=result*10+digit;//update result
            i++;
      }
      return sign*result;//return result with sign
    }
}
