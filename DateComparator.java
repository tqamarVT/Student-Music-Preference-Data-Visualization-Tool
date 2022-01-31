package prj5;

import java.util.Comparator;

/**
 * Comparator class for the date of two songs
 * 
 * @author Taimoor Qamar
 * @version 2019.13.08
 */

public class DateComparator implements Comparator<Song> {

    /**
     * compares the date of two songs
     * 
     * 
     * @param songOne
     *            first song to compare
     * @param songTwo
     *            second song to compare
     * @return int 0, 1, or -1 depending on the
     *         results of the compare
     */
    @Override
    public int compare(Song songOne, Song songTwo) {
        return songOne.getDate().compareToIgnoreCase(songTwo.getDate());
    }
}
