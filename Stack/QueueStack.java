//Leetcode-225
//Stack Implementation using  2queues
//SC=O(n) , overall TC=O(n)
import java.util.Queue;
import java.util.LinkedList;
class MyStack {
//2 queue
Queue<Integer>q1=new LinkedList<>();
Queue<Integer>q2=new LinkedList<>();
//push function
  void push(int x){
 q1.add(x);
 }
  //pop function
 int pop(){
    while(q1.size()>1){
       q2.add(q1.poll());
    }
    int value=q1.poll();
      Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
    return value;
 }
  //peek/top function
 int top(){
   while(q1.size()>1){
      q2.add(q1.poll());
   }
  int value=q1.peek();
   q2.add(q1.poll());
   Queue<Integer>temp=q1;
   q1=q2;
   q2=temp;
   return value;
 }
  //empty function
 void empty(){
  System.out.println(q1.isEmpty()); 
 }
}
//creating and object and implementing in main class
public class StackQueue {
    public static void main(String[] args) {
       MyStack obj1 =new  MyStack();
        obj1.push(3);
        obj1.push(2);
        obj1.push(1);
      obj1.top();
       System.out.println(obj1.pop()); 
       System.out.println(obj1.pop());
       obj1.empty();
        
    }
    
     
}

 
  
