package searcher;

class CleverSearcherTest extends SearcherTest {

    protected Searcher createSearcher(int[] array, int index) throws IndexingError {
        return new SimpleSearcher(array, index);
    }
}
