package searcher;

import java.util.Arrays;

public class CleverSearcher extends Searcher {

    CleverSearcher(int[] array, int k) {
        super(array, k);
    }

    public int findElement() throws IndexingError {
        int[] array = getArray();
        int k = getIndex();
        int[] smallArray = new int[k];

        for(int index = 0; index < k; index++){
            if(k <= 0 || k > array.length) {
                throw new IndexingError();
            }
            smallArray[index] = array[index];
        }
        Arrays.sort(smallArray);
        //System.out.println(Arrays.toString(smallArray));
        for (int index = k; index < array.length; index++) {
            if (array[index] > smallArray[0]) {
                //System.out.println(array[index] + "?");

                /**
                 * If the number in array[index] is bigger number in the smallArray, set this number as new bigger.
                 */
                if (array[index] >= smallArray[k-1]) {
                    for(int i = 0; i < k - 1; i++){
                        smallArray[i] = smallArray[i + 1];
                    }
                    smallArray[k-1] = array[index];
                   //System.out.println(Arrays.toString(smallArray));
                } else {

                    /**
                     * Set a counter = 0. While the index in the array is bigger than the element in smallArray
                     * equal to the counter AND is smaller that the element in the smallArray equal to the counter +1,
                     * set the element in smallArray[counter] equal to smallArray[counter] +1.
                     */
                    int counter = 0;
                    while (array[index] > smallArray[counter + 1]) {
                        smallArray[counter] = smallArray[counter + 1];
                        counter++;
                    }
                    smallArray[counter] = array[index];
                    //System.out.println(Arrays.toString(smallArray));
                }
            }
        }
        return smallArray[0];
    }
}


//public class CleverSearcher extends Searcher {
//
//    CleverSearcher(int[] array, int k) {
//        super(array, k);
//    }
//
//    public int findElement() throws IndexingError {
//        int[] array = getArray();
//        int k = array[0]; // set kth element equal to the first element of the array
//
//        for(int i = 0; i <= getArray().length - 1; i++){
//            if(k <= 0 || k > array.length) {
//                throw new IndexingError();
//            }
//            /**
//             * Compare each element in the array with k,
//             * if it's large than the current k set k equal than the element in array[i].
//             */
//            if (array[i] > k) {
//                k = array[i];
//            }
//        } return k;
//    }
//}
