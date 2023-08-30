import java.util.ArrayList;
public class subSet {
    public static void printSet(ArrayList <Integer> output) {
        
        for (int i = 0; i < output.size(); i++) {
            System.out.print(output.get(i)+" ");
        }
        System.out.println();
    }
    public static void subset( ArrayList <Integer> arr, ArrayList <Integer> output,int idx) {
        
        if (idx == arr.size()) {
          printSet(output);
            return;
        }
        // exclude
        subset(arr, output, idx+1);

        // include
        int element=arr.get(idx);
        output.add(element);
        subset(arr, output, idx+1);
       
      output.remove(arr.get(idx));  
    }

    public static void main(String[] args) {
        ArrayList <Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);

        ArrayList <Integer> output=new ArrayList<>();
       subset(arr, output, 0);


    }
}