package searcher;

public class CleverSearcher extends Searcher {
    CleverSearcher(int[] array, int k) {
        super(array, k);
    }

    public int findElement() throws IndexingError {
        int[] array = getArray();
        int k = array[0]; // set kth element equal to the first element of the array

        for(int i = 0; i <= getArray().length - 1; i++){
            if(k <= 0 || k > array.length){
                throw new IndexingError();

                /**
                 * Compare each element in the array (array[i]) with k,
                 * if it's large than the
                 */
            }if (array[i] > k) { // compare the element i in the array to k
                k = array[i];
            }
        } return k;
    }
}
