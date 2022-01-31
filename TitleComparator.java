package prj5;
import java.util.Comparator;

/**
 * Comparator class for the title of two songs
 * 
 * @author Taimoor Qamar
 * @version 2019.13.08
 *
 */
public class TitleComparator implements Comparator<Song> {
    /**
     * compares the title of two songs
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
        return songOne.getSongName().compareToIgnoreCase(songTwo.getSongName());
    }

}
