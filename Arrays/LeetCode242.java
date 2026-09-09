//Valid anagram problem if O(n space can be used )
// TC-O(nlog n)-Sorting each character
// SC-O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
        // Base case
        if(s.length() != t.length()) return false;

        char sArr[]=s.toCharArray(); // convert string to character array
        Arrays.sort(sArr); // sort the array
        String sortedS=new String(sArr); // then convert back the array into string

        char tArr[]=t.toCharArray();
        Arrays.sort(tArr);
        String sortedT=new String(tArr);

        if(sortedS.equals(sortedT)) return true;

        return false;
    }
}
//2nd Approach-TC-O(n+m)
// Sc-O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
         HashMap<Character,Integer>map1=new HashMap<>();
         HashMap<Character,Integer>map2=new HashMap<>();
         for(int i=0;i<s.length();i++){
           if(map1.containsKey(s.charAt(i))){
            map1.put(s.charAt(i),map1.get(s.charAt(i))+1);
           }else{map1.put(s.charAt(i),1);}
         }
         for(int i=0;i<t.length();i++){
          if(map2.containsKey(t.charAt(i))){
            map2.put(t.charAt(i),map2.get(t.charAt(i))+1);
           }else{map2.put(t.charAt(i),1);}
         }
         if(map1.equals(map2)){return true;}

         return false;
    }
}
//3rd Approach
// using a frequency array -> is 
class Solution{
    public boolean isAnagram(String s, String t){
        int [] count= new int[26];
        for(char ch: s.toCharArray()){
            count[ch-'a']++;
        }
        for(char ch: t.toCharArray()){
            count[ch-'a']--;
        }
        // lambda expression,for loop can be used too to check anagram
        boolean AllZeros= Arrays.stream(count).allMatch(element->element==0);

        return AllZeros;
    }
}
// FOLLOW-UP:What if the inputs contain Unicode characters? How would you adapt your solution to such a case?-> You can simply use an array of count 128->int []count=new int[128]
