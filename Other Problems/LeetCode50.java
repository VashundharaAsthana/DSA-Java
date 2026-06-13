//LeetCode 50-Pow(x,n)
//TC-O(logN)
//SC-O(logN)
//Difficulty-Medium
//given a number n calculate x raise to the power n 
class Solution {
    public double myPow(double x, int n) {
       long exp=n;
      if(n<0){
        return 1.0/power(x,-exp);//if n is negative
      }
       return 1.0*power(x,exp);
    }
    public double power(double x,long n){
          if(n==0)return 1.0;
          if(n==1)return x;
          if (n%2==0){return power(x*x,n/2);}
          else{return x*power(x, n-1 );}
    }
}
