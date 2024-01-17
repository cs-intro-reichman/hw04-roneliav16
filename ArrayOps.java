import java.util.Arrays;

public class ArrayOps {
    public static void main(String[] args) { // Just do some tests
        int [] array1 = {3, 2, 1};
        int [] array2 = {9, 3, 3, 3, 100, 100, 222, 7, 9, 4};
        System.out.println(findMissingInt(array1));
        System.out.println(secondMaxValue(array1));
        System.out.println(containsTheSameElements(array1, array2));
        System.out.println(isSorted(array1));
    }
    /* This function gets an array and return the missing int. if is the last in the row return the lentgh of the array */
    public static int findMissingInt (int [] array) { 
        int counter = 0;
        for(int i = 0; i < array.length; i++) {
            int missingInt = counter;
            for(int j = 0; j < array.length; j++) {
                if(array[j] == counter) {
                    counter++;
                }
                }
                if(counter == missingInt) {
                    return missingInt;
            }
        }
        return array.length;
    }

    /*This function gets an array and return the second max value in the array */
    public static int secondMaxValue(int [] array) {
        int maxValue = array[0];
        int secondValue = array[1];
        for(int i = 1; i < array.length; i++) {
            if(array[i] >= maxValue) {
                secondValue = maxValue;
                maxValue = array[i];
            } else { if(array[i] >= secondValue) {
                    secondValue = array[i];
                }
             }
        }
        return secondValue;
    }

    /* This function gets an array and print him.(return nothing) */
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    /* This function gets an array and return the array length without duplictaes values */
    public static int countUnique(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
        count = contains(arr, arr[i], i) ? count : count + 1;
        }
        return count;
        }

        /* This function gets an array, int value and ind index, in the same place that you working on in the array loop, and return if the array contains the value in foward the array  */
    public static boolean contains(int[] arr, int value, int index) {
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] == value) {
                return true;
            }
        }
        return false;
    }
    
    /*This function gest an array and return a non-duplicates value (unique). */
    public static int [] setUnique(int[] arr) {
        int [] res = new int [countUnique(arr)];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!contains(arr, arr[i], i)){
                res[index++] = arr[i];
            }
        }
        return res;
    }

    /*This function gets 2 arrays and return if they are equals sets */
    public static boolean containsTheSameElements(int[] array1, int[] array2) {
        int[] res1 = setUnique(array1);
        int[] res2 = setUnique(array2);

        for(int i = 0; i < res1.length; i++) {
            boolean containsValue = false;
            for(int j = 0; j < res2.length; j++) {
                if(res1[i] == res2[j]) {
                    containsValue = true;
                }
            }
            if (containsValue == false){
                return false;
            }
        }
        return true;
    }

    public static int [] sortArrayMaxToMin (int [] array) {
        int [] res = new int [array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }
        for (int i = 0; i < res.length; i++) {
            for(int j = i + 1; j < res.length; j++) {
                int tmp = 0;
                if (res[i] >= res[j]) {
                    tmp = res[i];
                    res[i] = res[j];
                    res[j] = tmp;
                }
            }
        }
        return res;
    }

    public static int [] sortArrayMinToMax (int [] array) {
        int [] res = new int [array.length];
        for (int i = 0; i < array.length; i++) {
            res[i] = array[i];
        }
        for (int i = 0; i < res.length; i++) {
            for(int j = i + 1; j < res.length; j++) {
                int tmp = 0;
                if (res[i] <= res[j]) {
                    tmp = res[i];
                    res[i] = res[j];
                    res[j] = tmp;
                }
            }
        }
        return res;
    }

    /*This function gets an array and return true if the array is sorted, otherwise return false*/
    public static boolean isSorted(int [] array) {
        boolean isArraySorted = true;
        int [] res = sortArrayMaxToMin(array);
        for(int i = 0; i < array.length; i++) {
            if (!(res[i] == array[i])) {
                isArraySorted = false;
                break;
            }
        }
        if (isArraySorted) {
            return true;
        }
        isArraySorted = true;
        int [] res2 = sortArrayMinToMax(array);
        for(int i = 0; i < array.length; i++) {
            if (!(res2[i] == array[i])) {
                isArraySorted = false;
                break;
            }
        }
        if (isArraySorted) {
            return true;
        } else {
            return false;
        }
    }
}
