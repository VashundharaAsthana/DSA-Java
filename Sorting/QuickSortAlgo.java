//TC->Best Case:O(n*logn) Worst case(if pivot is smallest or the largest element in the array :O(n^2)
public class QuickSortAlgo {
// PARTITION 
public static int Part(int[]arr,int start, int end){
    int pivot=arr[start];//chosing the pivot->sth index
    int count=0;
    for(int i=start+1;i<=end;i++){
        if(arr[i]<pivot) count++;
    }
    //placing pivot at right index
    int pivIndex=start+count;//gives the index where the pivot will be stored
    int temp=arr[start];
    arr[start]=arr[pivIndex];
    arr[pivIndex]=temp;

    //right and left part
    int i=start ,j=end;
    while (i<pivIndex&& j>pivIndex) {
      while(i<pivIndex&&arr[i]<pivot) i++;
      while (j>pivIndex&&arr[j]>pivot) j--;

      if(i<pivIndex&&j>pivIndex){
        int t=arr[i];
        arr[i]= arr[j];
        arr[j]=t;
        i++;
        j--;
      }
    }
  return pivIndex; 
}

// QUICKSORT FUNCTION 
public static void quickSort(int arr[],int start,int end){
    if(start>=end) return;//the base case

    int p=Part(arr, start, end); //partition
    
    quickSort(arr, start, p-1);//for left part

    quickSort(arr, p+1, end);//for right part

}


    public static void main(String[] args) {
        int arr[]={30,10,40,90,70,80};
        int n=arr.length;
        System.out.println("before sorting:");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("after sorting:");
        quickSort(arr, 0, n-1);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        

    }
}
