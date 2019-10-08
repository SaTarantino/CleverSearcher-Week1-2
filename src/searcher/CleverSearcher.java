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
        for (int index = k; index < array.length; index++) {
            if (array[index] > smallArray[index]) {
                smallArray[0] = array[index];
                Arrays.sort(smallArray);
            }
        }
        return smallArray[0];
    }
}
