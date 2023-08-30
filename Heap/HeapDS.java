
public class HeapDS {
    
    int arr[];
    int size;
    HeapDS(){
        arr=new int[100];
        size=0;
    }


     void insert(int data){
        // increase size ,ax heap
        size=size+1;
       int idx=size;
       arr[idx]=data;
         
       while (idx > 1) {
           // geting parent element
           int parent=idx/2;
           if (arr[parent] < arr[idx]) {
               int temp=arr[parent];
               arr[parent]=arr[idx];
               arr[idx]=temp;
           }else{
               return;
           }
       }
    } 

    void print(){
        for (int i = 1; i <=size ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
  
   void delete(){
     if (size==0){
        System.out.println("nothing to delete");
     }
    //  swap last to first
    int temp=arr[1];
    arr[1]=arr[size];
    arr[size]=temp;
    size--;
    
   int i=1;
    while(i < size){
       int leftidx=2*i;
       int rightidx=2*i+1;

       if(leftidx < size && arr[i] < arr[leftidx]){
           int temp1=arr[i];
           arr[i]=arr[leftidx];
           arr[leftidx]=temp1;
           i=leftidx;
       }
       else if(rightidx < size && arr[i] < arr[rightidx]){
        int temp1=arr[i];
        arr[i]=arr[rightidx];
        arr[rightidx]=temp1;
        i=rightidx;
       }else{
           return;
       }
    }

   }

  void hepify(int arr[],int n,int i){
     // max heap
    int largest=i;
    int left=2*i;
    int right=2*i+1;

    if (left <= n && arr[i] < arr[left] ) {
        largest=left;
    }
    if (right <= n && arr[i] < arr[right] ) {
        largest=right;
    }

   if(largest != i){
     int temp=arr[largest];
     arr[largest]=arr[i];
     arr[i]=temp;
     hepify(arr, n, largest);
   }
  }

  void heapSort(int arr[],int n){
     int size=n;
   
    while(size > 1){
        int temp=arr[1];
        arr[1]=arr[size];
        arr[size]=temp;
        size--;
        hepify(arr,size,1);
    }
  }

    public static void main(String[] args) {
        HeapDS h=new HeapDS();
        System.out.println("insert element in array");
        h.insert(50);
        h.insert(55);
        h.insert(53);
        h.insert(52);
        h.insert(54);
         
        h.print();
        System.out.println();
        System.out.println("delete  element from array");
        h.delete();
        h.print();

       int arr[]={-1,54,53,55,52,50};
       int n=5;
       System.out.println();
       System.out.println("heapify algorithm");
       // 1 base indexing
       for (int i = n/2; i > 0; i--) {
           h.hepify(arr, n, i);
       }
       for (int i = 1; i <= n; i++) {
           System.out.print(arr[i]+" ");
       }
        System.out.println();
       System.out.println("printing heapSort");
       h.heapSort(arr,n);
       
       for (int i = 1; i <= n; i++) {
        System.out.print(arr[i]+" ");
    }

    }
}





