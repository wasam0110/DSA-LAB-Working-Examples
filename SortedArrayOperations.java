/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wasam
 */
import java.util.Arrays;

public class SortedArrayOperations {

    public static boolean search(int[] array, int key) {
        int start = 0, end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == key) {
                return true;
            } else if (array[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static int[] insert(int[] array, int key) {
        int[] newArray = new int[array.length + 1];
        int i = 0;
        while (i < array.length && array[i] < key) {
            newArray[i] = array[i];
            i++;
        }
        newArray[i] = key;
        while (i < array.length) {
            newArray[i + 1] = array[i];
            i++;
        }
        return newArray;
    }

    public static int[] delete(int[] array, int key) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return array;
        }
        int[] newArray = new int[array.length - 1];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (i != index) {
                newArray[j++] = array[i];
            }
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};

        System.out.println("Search for 5: " + search(array, 5));
        System.out.println("Search for 6: " + search(array, 6));

        array = insert(array, 6);
        System.out.println("Array after inserting 6: " + Arrays.toString(array));

        array = delete(array, 7);
        System.out.println("Array after deleting 7: " + Arrays.toString(array));
    }
}

