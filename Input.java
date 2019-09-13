// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
//

package prj5;

import java.io.FileNotFoundException;

/**
 * Runs the GUIdisplay
 * 
 * @author Caroline Hoang
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
