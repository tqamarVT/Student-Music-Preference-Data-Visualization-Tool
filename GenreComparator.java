package prj5;

import java.util.Comparator;
/**
 * Comparator class for the genre of two songs
 * 
 * @author Group One (tqamar, adamc1, hoangcd, tdeel)
 * @version 2019.13.08
 */
public class GenreComparator implements Comparator<Song> {
    /**
     * compares the genre of two songs
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
        return songOne.getGenre().compareTo(songTwo.getGenre());
    }

}