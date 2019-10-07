package searcher;

import java.util.Arrays;

public class CleverSearcher extends Searcher {
    CleverSearcher(int[] array, int k) {
        super(array, k);
    }

    public int findElement() throws IndexingError {
        int[] array = getArray();
        int k = array[0];

        for(int i = 0; i <= getArray().length - 1; i++){
            if(k <= 0 || k > array.length){
                throw new IndexingError();
            }if (array[i] > k) {
                k = array[i];
            }
        } return k;
    }
}
