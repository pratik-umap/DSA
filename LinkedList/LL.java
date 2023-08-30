import java.util.Scanner;

class Solution {

    static String reverseStringWordWise(String input) {
        String[] words = input.split(" ");
        int i = 0, j = words.length - 1;
        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }
        String ans = "";
        for (i = 0; i < words.length; i++) {
            ans += (words[i] + " ");
        }
        return ans;
    }
   // reverse string
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String ans = reverseStringWordWise(input);
        System.out.println(ans);
    }
}