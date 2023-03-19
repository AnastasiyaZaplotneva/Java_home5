import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeapSorted {

    public static int[] createArray(int s, int l) {
        Random random = new Random();
        int[] arr = new int [s];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(l);
        }
        return arr;
    }

    private static void printFromArrToString (int[] arr) {
        String s = "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) s += arr[i] + "]";
            else s += arr[i] + ", ";
        }
        System.out.println(s);;
    }

    public static void heapSort(int[] myArr, int length) {
        int temp;
        int size = length-1;
        for (int i = (length / 2); i >= 0; i--) {
           heapify(myArr, i, size);
        };
        for(int i= size; i>=0; i--) {
           temp = myArr[0];
           myArr[0] = myArr[size];
           myArr[size] = temp;
           size--;
           heapify(myArr, 0, size);
        }
        System.out.println(Arrays.toString(myArr));
     }
     public static void heapify (int [] myArray, int i, int heapSize) {
        int a = 2*i;
        int b = 2*i+1;
        int largestElement;
        if (a<= heapSize && myArray[a] > myArray[i]) {
           largestElement = a;
        } else {
           largestElement = i;
        }
        if (b <= heapSize && myArray[b] > myArray[largestElement]) {
           largestElement = b;
        }
        if (largestElement != i) {
           int temp = myArray[i];
           myArray[i] = myArray[largestElement];
           myArray[largestElement] = temp;
           heapify(myArray, largestElement, heapSize);
       }
     }
     public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите желаемый размер массива: ");
        int size = scanner.nextInt();
        int[] myArray = createArray(size, 100);
        printFromArrToString(myArray);
        heapSort(myArray, size);
        scanner.close();
     }
}
