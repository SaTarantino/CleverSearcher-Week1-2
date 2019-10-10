package searcher;

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
        for (int index = k; index < array.length; index++) {
            if (array[index] > smallArray[0]) {

                /**
                 * If the number in array[index] is bigger number in the smallArray, set this number as new bigger.
                 */

                if (array[index] >= smallArray[4]) {
                    smallArray[4] = array[index];
                } else {

                    /**
                     * Set a counter = 0. While the index in the array is bigger that the element in smallArray
                     * equal to the counter AND is smaller that the element in the smallArray equal to the counter +1,
                     * set the element in smallArray[counter] equal to smallArray[counter] +1.
                     */

                    int counter = 0;
                    while (array[index] > smallArray[counter] && array[index] > smallArray[counter] + 1) {
                        smallArray[counter] = smallArray[counter] + 1;
                        counter++;
                    }
                    smallArray[counter] = array[index];
                }
            }
        }
        return smallArray[0];
    }
}
