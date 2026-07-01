// STACK IMPLEMENTATION USING ARRAY
//Stack follows LIFO-Last In First Out mechanism
//TC-O(1)-each operation uses exactly O(1) time commplexity to  be completed
//SC-O(n)
public class ArrayStack {
    //create an array to hold the elements
    private int[] stackArr;
    // a variable to hold the maximum capacity
    private int capacity;
    //index of top element
    private int top;
    //constructor
    public ArrayStack(int size){
        capacity=size;
        stackArr=new int [capacity];
        top=-1;//initialization
    }
    public ArrayStack(){
        this(100);
    }
    //push function-to insert elements in stack
    public void push(int x){
        //if index is greater than the given maximum capacity
        if(top>=capacity-1){System.out.println("Stack overflow");
            return;
        }
        stackArr[++top]=x;
    }
  
    //pop function-to remove the top / last element
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArr[top--];//returns the last element after deletion
    }
  
    //peek function-returns the last element without deleting it.
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        return stackArr[top];
    }
  
    public int size(){//returns the size of stack
        if(isEmpty()){
           System.out.println("empty stack");
            return -1;
        }
        return top+1;
    }
  
    //empty function
    public boolean isEmpty(){
        return top==-1;//returns true if stack is empty i.e, top=-1
    }
  
    public static void main(String[] args) {
        ArrayStack stack= new ArrayStack();
        stack.push(9);
        stack.push(78);
        stack.push(77);
        stack.push(5);
       System.out.println("Size of Stack: "+stack.size()); 
      System.out.println("Top/Last element of Stack: "+stack.peek());
       System.out.println( "Removed last element of Stack: "+stack.pop());
      
    }
}

