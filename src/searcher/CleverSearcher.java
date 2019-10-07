package searcher;

public class CleverSearcher extends Searcher {

    CleverSearcher(int[] array, int k) {
        super(array, k);
    }

    public int findElement() throws IndexingError {
        int[] array = getArray();
        int k = array[0]; // set kth element equal to the first element of the array

        for(int i = 0; i <= getArray().length - 1; i++){
            if(k <= 0 || k > array.length) {
                throw new IndexingError();
            }
                /**
                 * Compare each element in the array with k,
                 * if it's large than the current k set k equal than the element in array[i].
                 */
            if (array[i] > k) {
                k = array[i];
            }
        } return k;
    }
}
