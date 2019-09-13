// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of
// those who do.
//

package prj5;

/**
 * This class tests the methods in the Song class.
 * 
 * @author Caroline D.M. Hoang
 * @version 2019.08.13
 */
public class SongTest extends student.TestCase {
    private Song songy;


    /**
     * Sets up before every test
     */
    public void setUp() {
        songy = new Song("song", "name", "date", "genre");
    }


    /**
     * Tests the song info
     */
    public void testInfo() {
        assertEquals("name", songy.getArtistName());
        assertEquals("song", songy.getSongName());
        assertEquals("genre", songy.getGenre());
        assertEquals("date", songy.getDate());
    }


    /**
     * Tests the HobbyCounter()
     */
    public void testHobby() {
        songy.hobbyCounter("reading", "Yes", "Yes");
        assertEquals(1, songy.getHobbyLike("reading"));
        assertEquals(1, songy.getHobbyHeard("reading"));

        songy.hobbyCounter("reading", "Yes", "No");
        assertEquals(2, songy.getHobbyLike("reading"));
        assertEquals(1, songy.getHobbyHeard("reading"));

        songy.hobbyCounter("art", "Yes", "Yes");
        assertEquals(1, songy.getHobbyLike("art"));
        assertEquals(1, songy.getHobbyHeard("art"));

        songy.hobbyCounter("reading", "No", "Yes");
        assertEquals(2, songy.getHobbyLike("reading"));
        assertEquals(2, songy.getHobbyHeard("reading"));

        assertEquals(3, songy.getHobbyTotalLikeCount("reading"));
        assertEquals(3, songy.getHobbyTotalHeardCount("reading"));

        songy.hobbyCounter("not reading", "Yes", "No");
        assertEquals(2, songy.getHobbyLike("reading"));
        assertEquals(2, songy.getHobbyHeard("reading"));
        assertEquals(3, songy.getHobbyTotalLikeCount("reading"));
        assertEquals(3, songy.getHobbyTotalHeardCount("reading"));

        songy.hobbyCounter("reading", "", "");
        assertEquals(2, songy.getHobbyLike("reading"));
        assertEquals(2, songy.getHobbyHeard("reading"));
        assertEquals(3, songy.getHobbyTotalLikeCount("reading"));
        assertEquals(3, songy.getHobbyTotalHeardCount("reading"));

        songy.hobbyCounter("reading", "", "Yes");
        assertEquals(2, songy.getHobbyLike("reading"));
        assertEquals(3, songy.getHobbyHeard("reading"));
        assertEquals(3, songy.getHobbyTotalLikeCount("reading"));
        assertEquals(4, songy.getHobbyTotalHeardCount("reading"));

        songy.hobbyCounter("reading", "Yes", "");
        assertEquals(3, songy.getHobbyLike("reading"));
        assertEquals(3, songy.getHobbyHeard("reading"));
        assertEquals(4, songy.getHobbyTotalLikeCount("reading"));
        assertEquals(4, songy.getHobbyTotalHeardCount("reading"));

        assertEquals(4, songy.getHobbyTotalLikeCount("reading"));
        assertEquals(4, songy.getHobbyTotalHeardCount("reading"));

        songy.hobbyCounter("art", "Yes", "No");
        assertEquals(2, songy.getHobbyLike("art"));
        assertEquals(1, songy.getHobbyHeard("art"));

    }


    /**
     * Tests the majorCounter()
     */
    public void testMajor() {
        songy.majorCounter("Other", "Yes", "No");
        assertEquals(1, songy.getMajorLike("Other"));
        assertEquals(0, songy.getMajorHeard("Other"));

        songy.majorCounter("Other", "No", "Yes");
        assertEquals(1, songy.getMajorLike("Other"));
        assertEquals(1, songy.getMajorHeard("Other"));

        songy.majorCounter("Other", "", "No");
        assertEquals(1, songy.getMajorLike("Other"));
        assertEquals(1, songy.getMajorHeard("Other"));

        assertEquals(2, songy.getMajorTotalLikeCount("Other"));
        assertEquals(3, songy.getMajorTotalHeardCount("Other"));

        songy.majorCounter("Other", "", "");
        assertEquals(1, songy.getMajorLike("Other"));
        assertEquals(1, songy.getMajorHeard("Other"));

        songy.majorCounter("Other", "Yes", "");
        assertEquals(2, songy.getMajorLike("Other"));
        assertEquals(1, songy.getMajorHeard("Other"));

        songy.majorCounter("history", "Yes", "No");
        assertEquals(3, songy.getMajorTotalLikeCount("Other"));
        assertEquals(3, songy.getMajorTotalHeardCount("Other"));

        songy.majorCounter("Computer Science", "Yes", "No");
        assertEquals(1, songy.getMajorTotalLikeCount("Computer Science"));
        assertEquals(1, songy.getMajorTotalHeardCount("Computer Science"));
    }


    /**
     * Tests the stateCounter()
     */
    public void testState() {
        songy.stateCounter("Outside of United States", "No", "No");
        assertEquals(0, songy.getStateLike("Outside of United States"));
        assertEquals(0, songy.getStateHeard("Outside of United States"));
        songy.stateCounter("Outside of United States", "Yes", "Yes");
        assertEquals(1, songy.getStateLike("Outside of United States"));
        assertEquals(1, songy.getStateHeard("Outside of United States"));

        assertEquals(2, songy.getStateTotalLikeCount(
            "Outside of United States"));

        songy.stateCounter("somewhere else", "Yes", "No");
        assertEquals(2, songy.getStateTotalLikeCount(
            "Outside of United States"));
        assertEquals(2, songy.getStateTotalHeardCount(
            "Outside of United States"));

        songy.stateCounter("Outside of United States", "", "No");
        assertEquals(1, songy.getStateLike("Outside of United States"));
        assertEquals(1, songy.getStateHeard("Outside of United States"));

        assertEquals(2, songy.getStateTotalLikeCount(
            "Outside of United States"));
        assertEquals(3, songy.getStateTotalHeardCount(
            "Outside of United States"));

        songy.stateCounter("Outside of United States", "", "");
        assertEquals(1, songy.getStateLike("Outside of United States"));
        assertEquals(1, songy.getStateHeard("Outside of United States"));

        songy.stateCounter("Outside of United States", "Yes", "");
        assertEquals(2, songy.getStateLike("Outside of United States"));
        assertEquals(1, songy.getStateHeard("Outside of United States"));

        songy.stateCounter("Northeast", "Yes", "");
        assertEquals(1, songy.getStateLike("Northeast"));
        assertEquals(0, songy.getStateHeard("Northeast"));
    }

}
