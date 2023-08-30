import java.util.*;

class aggresion  {
    
    public static boolean isPossible(int stalls[],int c,int mid) {
        
        int cowcount=1;
        int lastPost=stalls[0];
        for (int i = 0; i < stalls.length; i++) {
            
            if (stalls[i] - lastPost >= mid) {
                cowcount++;
                if (cowcount==c) {
                    return true;
    
                }
                lastPost=stalls[i];
  
            }
        }
        return false;

    }
    public static int printCows(int stalls[],int c ) {
        Arrays.sort(stalls);
        int s=0;
        int e= stalls.length;
        int ans=-1;
        int mid= s + ( e - s)/2;

        while (s <= e) {
            if (isPossible(stalls,c,mid)) {
                ans =mid;
                s=mid+1;
            } else {
                e=mid-1;
            }
            mid= s + ( e - s)/2;

        }
        return ans;
    }
    public static void main(String[] args) {
        int stalls[]={4,2,1,3,5,6};
       int  c=3;
        System.out.println(printCows(stalls, c));
    }
}
