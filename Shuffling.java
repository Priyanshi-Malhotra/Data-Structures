import java.util.Random;

public class Shuffling {
    public static void main(String[] args)
    {
        int[] arr=new int[5];
        arr[0]=1;
        arr[1]=2;
        arr[2]=3;
        arr[3]=4;
        arr[4]=5;
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        Random number=new Random();
        int n=2;
        while(n>0) {
            n--;
            for (int i = 0; i < arr.length; i++) {
                int temp = number.nextInt(5);
                if (arr[i] > arr[temp]) {
                    int swap = arr[i];
                    arr[i] = arr[temp];
                    arr[temp] = swap;
                }
            }
            System.out.println(n + " :");
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
        return;
    }
}
