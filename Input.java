package prj5;
import java.io.FileNotFoundException;

/**
 * Runs the GUIdisplay
 * @author Taimoor Qamar
 * @version 2019.13.08
 *
 */
public class Input {

    /**
     * the method that starts the whole project
     * sends the source data to the input class
     * 
     * @param anEntry
     */
    public static void main(String[] args) {
        Reader reader = null;
        if (args.length > 1) {
            try {
                reader = new Reader(args[0], args[1]);
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                reader = new Reader("MusicSurveyData2018.csv",
                    "SongList2018.csv");
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        SingleLinkedList<Song> songList = reader.getSongList();

        new GUIDisplay(new Controller(), songList);
    }
}
