// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and doubleegrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Caroline Hoang (hoangcd)

package prj5;

import java.io.FileNotFoundException;

/**
 * Tests the methods of the Controller class
 * 
 * @author Caroline Hoang
 * @version 08.13.2019
 *
 */
public class ControllerTest extends student.TestCase {
    private Controller controller;
    private SingleLinkedList<Song> songList;

    private SingleLinkedList<Song> list;
    private SingleLinkedList<Song> listSortedTitle;
    private SingleLinkedList<Song> listSortedGenre;
    private SingleLinkedList<Song> listSortedYear;
    private SingleLinkedList<Song> listSortedArtist;

    /**
     * Sets up before every test
     */
    public void setUp() {
        Reader reader = null;
        try {
            reader = new Reader("MusicSurveyData2018.csv", "SongList2018.csv");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        songList = reader.getSongList();
        controller = new Controller();
        
        list = new SingleLinkedList<Song>();
        listSortedTitle = new SingleLinkedList<Song>();
        listSortedGenre = new SingleLinkedList<Song>();
        listSortedYear = new SingleLinkedList<Song>();
        listSortedArtist = new SingleLinkedList<Song>();
        
        Song songOne = new Song("Lo/Hi", "Black Keys", "2019", "a");
        Song songTwo = new Song("Money In The Grave", "Drake", "2019", "b");
        Song songThree = new Song("Bad Blood", "Taylor Swift", "2015", "b");
        Song songFour = new Song("Call Me", "Blondie", "1980", "c");
        Song songFive = new Song("Tik Tok", "Ke$ha", "2009", "a");
        Song songSix = new Song("Bad Blood", "Taylor Swift", "2015", "b");
        
        list.add(songSix);
        list.add(songOne);
        list.add(songTwo);
        list.add(songThree);
        list.add(songFour);
        list.add(songFive);
        
        listSortedTitle.add(songSix);
        listSortedTitle.add(songThree);
        listSortedTitle.add(songFour);
        listSortedTitle.add(songOne);
        listSortedTitle.add(songTwo);
        listSortedTitle.add(songFive);

        
        listSortedGenre.add(songOne);
        listSortedGenre.add(songFive);
        listSortedGenre.add(songSix);
        listSortedGenre.add(songTwo);
        listSortedGenre.add(songThree);
        listSortedGenre.add(songFour);

        listSortedYear.add(songFour);
        listSortedYear.add(songFive);
        listSortedYear.add(songSix);
        listSortedYear.add(songThree);
        listSortedYear.add(songOne);
        listSortedYear.add(songTwo);
        
        listSortedArtist.add(songOne);
        listSortedArtist.add(songFour);
        listSortedArtist.add(songTwo);
        listSortedArtist.add(songFive);
        listSortedArtist.add(songSix);
        listSortedArtist.add(songThree);
    }


    /**
     * Tests the methods of getHobby Heard/Like Percentage
     */
    public void testGetHobby() {
        assertEquals(44.262, controller.getHobbyLikePercentage(songList, 0)[0],
            0.01);
        assertEquals(45.456, controller.getHobbyLikePercentage(songList, 0)[1],
            0.01);
        assertEquals(64.615, controller.getHobbyLikePercentage(songList, 0)[2],
            0.01);
        assertEquals(49.107, controller.getHobbyLikePercentage(songList, 0)[3],
            0.01);

        assertEquals(68.852, controller.getHobbyHeardPercentage(songList, 0)[0],
            0.01);
        assertEquals(72.727, controller.getHobbyHeardPercentage(songList, 0)[1],
            0.01);
        assertEquals(87.692, controller.getHobbyHeardPercentage(songList, 0)[2],
            0.01);
        assertEquals(85.714, controller.getHobbyHeardPercentage(songList, 0)[3],
            0.01);

        assertEquals(57.37, controller.getHobbyLikePercentage(songList, 42)[0],
            0.01);
        assertEquals(68.18, controller.getHobbyLikePercentage(songList, 42)[1],
            0.01);
        assertEquals(67.968, controller.getHobbyLikePercentage(songList, 42)[2],
            0.01);
        assertEquals(70.909, controller.getHobbyLikePercentage(songList, 42)[3],
            0.01);

        assertEquals(60.65, controller.getHobbyHeardPercentage(songList, 42)[0],
            0.01);
        assertEquals(72.72, controller.getHobbyHeardPercentage(songList, 42)[1],
            0.01);
        assertEquals(77.34, controller.getHobbyHeardPercentage(songList, 42)[2],
            0.01);
        assertEquals(82.72, controller.getHobbyHeardPercentage(songList, 42)[3],
            0.01);
    }


    /**
     * Tests the methods of getMajor Heard/Like Percentage
     */
    public void testGetMajor() {
        assertEquals(54.109, controller.getMajorLikePercentage(songList, 0)[0],
            0.01);
        assertEquals(50.98, controller.getMajorLikePercentage(songList, 0)[1],
            0.01);
        assertEquals(55., controller.getMajorLikePercentage(songList, 0)[2],
            0.01);
        assertEquals(56., controller.getMajorLikePercentage(songList, 0)[3],
            0.01);

        assertEquals(83.561, controller.getMajorHeardPercentage(songList, 0)[0],
            0.01);
        assertEquals(82.352, controller.getMajorHeardPercentage(songList, 0)[1],
            0.01);
        assertEquals(86.25, controller.getMajorHeardPercentage(songList, 0)[2],
            0.01);
        assertEquals(74., controller.getMajorHeardPercentage(songList, 0)[3],
            0.01);

        assertEquals(69.93, controller.getMajorLikePercentage(songList, 42)[0],
            0.01);
        assertEquals(70, controller.getMajorLikePercentage(songList, 42)[1],
            0.01);
        assertEquals(66.25, controller.getMajorLikePercentage(songList, 42)[2],
            0.01);
        assertEquals(56, controller.getMajorLikePercentage(songList, 42)[3],
            0.01);

        assertEquals(79.72, controller.getMajorHeardPercentage(songList, 42)[0],
            0.01);
        assertEquals(76, controller.getMajorHeardPercentage(songList, 42)[1],
            0.01);
        assertEquals(75, controller.getMajorHeardPercentage(songList, 42)[2],
            0.01);
        assertEquals(66., controller.getMajorHeardPercentage(songList, 42)[3],
            0.01);
    }


    /**
     * Tests the methods of getMajor Heard/Like Percentage
     */
    public void testGetState() {
        assertEquals(61.904, controller.getStateLikePercentage(songList, 0)[0],
            0.01);
        assertEquals(56.881, controller.getStateLikePercentage(songList, 0)[1],
            0.01);
        assertEquals(47.222, controller.getStateLikePercentage(songList, 0)[2],
            0.01);
        assertEquals(20., controller.getStateLikePercentage(songList, 0)[3],
            0.01);

        assertEquals(90.476, controller.getStateHeardPercentage(songList, 0)[0],
            0.01);
        assertEquals(88.073, controller.getStateHeardPercentage(songList, 0)[1],
            0.01);
        assertEquals(77.778, controller.getStateHeardPercentage(songList, 0)[2],
            0.01);
        assertEquals(37.143, controller.getStateHeardPercentage(songList, 0)[3],
            0.01);

        assertEquals(72.6, controller.getStateLikePercentage(songList, 42)[0],
            0.01);
        assertEquals(66.05, controller.getStateLikePercentage(songList, 42)[1],
            0.01);
        assertEquals(72.22, controller.getStateLikePercentage(songList, 42)[2],
            0.01);
        assertEquals(37.5, controller.getStateLikePercentage(songList, 42)[3],
            0.01);

        assertEquals(80.82, controller.getStateHeardPercentage(songList, 42)[0],
            0.01);
        assertEquals(74.31, controller.getStateHeardPercentage(songList, 42)[1],
            0.01);
        assertEquals(83.33, controller.getStateHeardPercentage(songList, 42)[2],
            0.01);
        assertEquals(50., controller.getStateHeardPercentage(songList, 42)[3],
            0.01);
    }
    
    /**
     * Test the sortByTitle() method
     */
    public void testSortByTitle() {
        assertEquals(listSortedTitle, controller.sortByTitle(list));
    }
    
    /**
     * Test the sortByGenre() method
     */
    public void testSortByGenre() {
        assertEquals(listSortedGenre, controller.sortByGenre(list));
    }

    /**
     * Test the sortByYear() method
     */
    public void testSortByYear() {
        assertEquals(listSortedYear, controller.sortByDate(list));
    }

    /**
     * Test the sortByArtis() method
     */
    public void testSortByArtist() {

        SingleLinkedList<Song> empty = new SingleLinkedList<Song>();
        assertEquals(empty, controller.sortByArtist(empty));
        assertEquals(listSortedArtist, controller.sortByArtist(list));
    }
}



