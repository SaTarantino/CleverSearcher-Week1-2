package searcher;

/**
 * author Salvatore Tarantino, u1860830
 * u1860830@hud.ac.uk
 */

class CleverSearcherTest extends SearcherTest {

    protected Searcher createSearcher(int[] array, int index) throws IndexingError {
        return new CleverSearcher(array, index);
    }
}
