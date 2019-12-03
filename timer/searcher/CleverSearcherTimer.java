package searcher;

import arrayGenerator.ArrayGenerator;
import arrayGenerator.CleverRandomListingGenerator;
import timer.Timer;

/**
 * author Salvatore Tarantino, u1860830
 * u1860830@hud.ac.uk
 *
 * Based on SimpleSearcherTimer.
 */

public class CleverSearcherTimer extends CleverSearcher implements Timer {

    private final static int K = 5;

    private CleverSearcherTimer(int[] array){
        super (array, K);
    }

    @Override
    public Timer getTimer(int size) {
        ArrayGenerator generator = new CleverRandomListingGenerator(size);
        return new CleverSearcherTimer(generator.getArray());
    }

    @Override
    public void timedMethod() {
        try {
            findElement();
        } catch (IndexingError indexingError){

        }
    }

    @Override
    public long getMaximumRuntime() {
        return 5;
    }

    @Override
    public int getMinimumTaskSize() {
        return 10;
    }

    @Override
    public int getMaximumTaskSize() {
        return 1000000000;
    }

    public static void main(String[] args) throws IndexingError {
        CleverSearcherTimer timer = new CleverSearcherTimer(null);
        timer.timingSequence();
    }
}
