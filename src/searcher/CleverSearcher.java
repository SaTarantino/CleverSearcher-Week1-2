package searcher;

import java.util.Arrays;

/**
 *author Salvatore Tarantino, u1860830
 * u1860830@hud.ac.uk
 */

public class CleverSearcher extends Searcher {

    CleverSearcher(int[] array, int k) {
        super(array, k);
    }

    /**
     * Clever Searcher create a new smallArray where it store the bigger number from the array T found until that moment.
     *
     * @param array the array of int where the method is going to work.
     * @return
     */

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

        for (int index = k; index < array.length; index++) {
            if (array[index] > smallArray[0]) {

                /**
                 * If the number in array[index] is bigger number in the smallArray, set this number as new bigger.
                 */
                if (array[index] >= smallArray[k-1]) {
                    for(int i = 0; i < k - 1; i++){
                        smallArray[i] = smallArray[i + 1];
                    }
                    smallArray[k-1] = array[index];

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
                }
            }
        }
        return smallArray[0];
    }
}
