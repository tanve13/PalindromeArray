
import java.util.Arrays;

public class PalindromeArray{
    static void palindromeArray(){
        int arr[] = {1,5,2,5,1};
        int y=0;
        System.out.println("Interger array is:"+Arrays.toString(arr));
        for( int i=0;i<arr.length/2;i++){
            if (arr[i]==arr[arr.length-1-i]){
           y=0;
            }else{
          y=1;            }
           
        }
        if(y!=1){
            System.out.println("this is palindrome");
        }else{
            System.out.println("This is not palindrome");
        }
    }
    public static void main(String[] args) {
        palindromeArray();
    }
}