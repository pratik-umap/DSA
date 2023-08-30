public class classHeap {
     int n,size;
      int a[];
      classHeap(int size){
       n=0;
       this.size=size;
       a=new int[size+1];
      }
       classHeap(int a[]){
        this.a=a;
        this.size=a.length-1;
        n=a.length-1;
        buildHeap();
       }
      // min Heap
      public void insert(int key){
        if(n==size){
           System.out.println("arr is full");
        }
        n++;
         a[n]=key;
          int i=n;
         while (i > 1) {
            int parent=i/2;
            if (a[parent] > a[i]) {
                int temp=a[parent];
                a[parent]=a[i];
                a[i]=temp;
                i=parent;
            }else return;
         }
      } 
      public int extractMin(){
        if(n==0){
            System.out.println("array is empty");
        }
        int start=a[1];
        a[1]=a[n];
        n--;
         
        int i=1;
        while (i <= n) {
            int leftidx=2*i;
            int rightidx=2*i+1;
            int smallest=i;
            if (leftidx <= n && a[leftidx] < a[smallest]) {
                smallest=leftidx;
            }
            if (rightidx <= n && a[rightidx] < a[smallest]) {
                smallest=rightidx;
            }
           
            if(smallest!=i){
                int temp=a[i];
                a[i]=a[smallest];
                a[smallest]=temp;

                i=smallest;
            }else break;
        }

         return start;
      }
      public void hepify(int i){
        while (i <= n) {
          int leftidx=2*i;
          int rightidx=2*i+1;
          int smallest=i;
          if (leftidx <= n && a[leftidx] < a[smallest]) {
              smallest=leftidx;
          }
          if (rightidx <= n && a[rightidx] < a[smallest]) {
              smallest=rightidx;
          }
         
          if(smallest!=i){
              int temp=a[i];
              a[i]=a[smallest];
              a[smallest]=temp;

              i=smallest;
          }else break;
      }
      }
      void buildHeap(){
        for (int i = n; i > 0; i--) {
           hepify(i);
        }
      }
     public void heapSort() {
      int N=n;

         for (int i = 1; i <=N; i++) {
            System.out.print(extractMin()+" ");
         }
     }

      int ArraySize(){
        return n;
      }
      public void printHeap() {
        int size=n;
        for (int i=1;i<=size;i++) {
            System.out.print(a[i]+" ");
        }
      }
    public static void main(String[] args) {
        classHeap h=new classHeap(4);

        int a[]={0,4,3,5,1,6,2,7};
        classHeap s =new classHeap(a);

        s.heapSort();
      // s.printHeap();

      //    h.insert(5);
      //    h.insert(2);
      //  System.out.println(h.extractMin());
      //    h.insert(1);
      //    h.insert(8);
      //    System.out.println(h.ArraySize());
      //    h.insert(3);
      //    System.out.println(h.ArraySize());
      //    h.printHeap();
    }
}
