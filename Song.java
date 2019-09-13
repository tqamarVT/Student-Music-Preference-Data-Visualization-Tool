// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
//
package prj5;

import java.util.*;

/**
 * this class calculates all of the statistics besides percentages
 * counts the total number of people who heard and liked a song for
 * given parameters
 * 
 * @author group1
 */
/**
 * Creates a song object
 * 
 * @author Caroline Hoang
 * @version 07.31.2019
 */

public class Song {

    private String artistName;
    private String songName;
    private String genre;
    private String date;

    private HashMap<String, Integer> hobbyLikeCount;
    private HashMap<String, Integer> majorLikeCount;
    private HashMap<String, Integer> stateLikeCount;

    private HashMap<String, Integer> hobbyHeardCount;
    private HashMap<String, Integer> majorHeardCount;
    private HashMap<String, Integer> stateHeardCount;

    private HashMap<String, Integer> hobbyTotalLikeCount;
    private HashMap<String, Integer> majorTotalLikeCount;
    private HashMap<String, Integer> stateTotalLikeCount;

    private HashMap<String, Integer> hobbyTotalHeardCount;
    private HashMap<String, Integer> majorTotalHeardCount;
    private HashMap<String, Integer> stateTotalHeardCount;


    /**
     * Constructor for the Song class
     * 
     * @param songName
     *            the name of the song
     * @param artistName
     *            the artist name
     * @param date
     *            the year of the song
     * @param genre
     *            the genre of the song
     */
    public Song(String songName, String artistName, String date, String genre) {
        this.songName = songName;
        this.artistName = artistName;
        this.genre = genre;
        this.date = date;

        int hobbyLike = 0;
        int hobbyHeard = 0;
        int hobbyCountLike = 0;
        int hobbyCountHeard = 0;

        int majorLike = 0;
        int majorHeard = 0;
        int majorCountLike = 0;
        int majorCountHeard = 0;

        int stateLike = 0;
        int stateHeard = 0;
        int stateCountLike = 0;
        int stateCountHeard = 0;

        hobbyLikeCount = new HashMap<String, Integer>();
        hobbyHeardCount = new HashMap<String, Integer>();

        majorLikeCount = new HashMap<String, Integer>();
        majorHeardCount = new HashMap<String, Integer>();

        stateLikeCount = new HashMap<String, Integer>();
        stateHeardCount = new HashMap<String, Integer>();

        hobbyTotalLikeCount = new HashMap<String, Integer>();
        majorTotalLikeCount = new HashMap<String, Integer>();
        stateTotalLikeCount = new HashMap<String, Integer>();

        hobbyTotalHeardCount = new HashMap<String, Integer>();
        majorTotalHeardCount = new HashMap<String, Integer>();
        stateTotalHeardCount = new HashMap<String, Integer>();

        hobbyLikeCount.put("reading", hobbyLike);
        hobbyLikeCount.put("art", hobbyLike);
        hobbyLikeCount.put("sports", hobbyLike);
        hobbyLikeCount.put("music", hobbyLike);

        hobbyHeardCount.put("reading", hobbyHeard);
        hobbyHeardCount.put("art", hobbyHeard);
        hobbyHeardCount.put("sports", hobbyHeard);
        hobbyHeardCount.put("music", hobbyHeard);

        majorLikeCount.put("Computer Science", majorLike);
        majorLikeCount.put("Other Engineering", majorLike);
        majorLikeCount.put("Math or CMDA", majorLike);
        majorLikeCount.put("Other", majorLike);

        majorHeardCount.put("Computer Science", majorHeard);
        majorHeardCount.put("Other Engineering", majorHeard);
        majorHeardCount.put("Math or CMDA", majorHeard);
        majorHeardCount.put("Other", majorHeard);

        stateLikeCount.put("Northeast", stateLike);
        stateLikeCount.put("Southeast", stateLike);
        stateLikeCount.put("United States (other than Southeast or Northwest)",
            stateLike);
        stateLikeCount.put("Outside of United States", stateLike);

        stateHeardCount.put("Northeast", stateHeard);
        stateHeardCount.put("Southeast", stateHeard);
        stateHeardCount.put("United States (other than Southeast or Northwest)",
            stateHeard);
        stateHeardCount.put("Outside of United States", stateHeard);

        hobbyTotalLikeCount.put("reading", hobbyCountLike);
        hobbyTotalLikeCount.put("art", hobbyCountLike);
        hobbyTotalLikeCount.put("sports", hobbyCountLike);
        hobbyTotalLikeCount.put("music", hobbyCountLike);

        majorTotalLikeCount.put("Computer Science", majorCountLike);
        majorTotalLikeCount.put("Other Engineering", majorCountLike);
        majorTotalLikeCount.put("Math or CMDA", majorCountLike);
        majorTotalLikeCount.put("Other", majorCountLike);

        stateTotalLikeCount.put("Northeast", stateCountLike);
        stateTotalLikeCount.put("Southeast", stateCountLike);
        stateTotalLikeCount.put(
            "United States (other than Southeast or Northwest)",
            stateCountLike);
        stateTotalLikeCount.put("Outside of United States", stateCountLike);

        hobbyTotalHeardCount.put("reading", hobbyCountHeard);
        hobbyTotalHeardCount.put("art", hobbyCountHeard);
        hobbyTotalHeardCount.put("sports", hobbyCountHeard);
        hobbyTotalHeardCount.put("music", hobbyCountHeard);

        majorTotalHeardCount.put("Computer Science", majorCountHeard);
        majorTotalHeardCount.put("Other Engineering", majorCountHeard);
        majorTotalHeardCount.put("Math or CMDA", majorCountHeard);
        majorTotalHeardCount.put("Other", majorCountHeard);

        stateTotalHeardCount.put("Northeast", stateCountHeard);
        stateTotalHeardCount.put("Southeast", stateCountHeard);
        stateTotalHeardCount.put(
            "United States (other than Southeast or Northwest)",
            stateCountHeard);
        stateTotalHeardCount.put("Outside of United States", stateCountHeard);
    }


    /**
     * Gets the name of the artist
     * 
     * @return the artist name
     */
    public String getArtistName() {
        return artistName;
    }


    /**
     * Gets the song name of the artist
     * 
     * @return the song name
     */
    public String getSongName() {
        return songName;
    }


    /**
     * Gets the genre of the artist
     * 
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Gets the date of the artist
     * 
     * @return the date
     */
    public String getDate() {
        return date;
    }


    /**
     * 
     * Increment the hobby information
     * 
     * @param key
     *            what hobby the user did
     * @param like
     *            Yes or No
     * @param heard
     *            Yes or No
     */
    public void hobbyCounter(String key, String like, String heard) {

        if (!hobbyLikeCount.containsKey(key)) {
            return;
        }

        if (like.equals("Yes") || like.equals("No")) {
            if (like.equals("Yes")) {
                hobbyLikeCount.put(key, hobbyLikeCount.get(key) + 1);
            }
            hobbyTotalLikeCount.put(key, hobbyTotalLikeCount.get(key) + 1);
        }

        if (heard.equals("Yes") || heard.equals("No")) {

            if (heard.equals("Yes")) {
                hobbyHeardCount.put(key, hobbyHeardCount.get(key) + 1);
            }

            hobbyTotalHeardCount.put(key, hobbyTotalHeardCount.get(key) + 1);
        }
    }


    /**
     * Increment the major information
     * 
     * @param key
     *            what major the user did
     * @param like
     *            Yes or No
     * @param heard
     *            Yes or No
     */
    public void majorCounter(String key, String like, String heard) {
        if (!majorLikeCount.containsKey(key)) {
            return;
        }

        if (like.equals("Yes") || like.equals("No")) {
            if (like.equals("Yes")) {
                majorLikeCount.put(key, majorLikeCount.get(key) + 1);
            }

            majorTotalLikeCount.put(key, majorTotalLikeCount.get(key) + 1);
        }

        if (heard.equals("Yes") || heard.equals("No")) {
            if (heard.equals("Yes")) {
                majorHeardCount.put(key, majorHeardCount.get(key) + 1);
            }

            majorTotalHeardCount.put(key, majorTotalHeardCount.get(key) + 1);
        }

    }


    /**
     * Increment the state information
     * 
     * @param key
     *            what state the user did
     * @param like
     *            Yes or No
     * @param heard
     *            Yes or No
     */
    public void stateCounter(String key, String like, String heard) {
        if (!stateLikeCount.containsKey(key)) {
            return;
        }

        if (like.equals("Yes") || like.equals("No")) {
            if (like.equals("Yes")) {
                stateLikeCount.put(key, stateLikeCount.get(key) + 1);
            }

            stateTotalLikeCount.put(key, stateTotalLikeCount.get(key) + 1);
        }

        if (heard.equals("Yes") || heard.equals("No")) {

            if (heard.equals("Yes")) {
                stateHeardCount.put(key, stateHeardCount.get(key) + 1);
            }

            stateTotalHeardCount.put(key, stateTotalHeardCount.get(key) + 1);
        }
    }


    /**
     * Gets hobbyLike
     * 
     * @return the number like with a certain hobby
     * @param key
     *            what hobby the user is
     */
    public int getHobbyLike(String key) {
        return hobbyLikeCount.get(key);
    }


    /**
     * Gets hobbyHeard
     * 
     * @return the number heard with a certain hobby
     * @param key
     *            what hobby the user is
     */
    public int getHobbyHeard(String key) {
        return hobbyHeardCount.get(key);
    }


    /**
     * Gets majorLike
     * 
     * @return the number like with a certain major
     * @param key
     *            what major the user is
     */
    public int getMajorLike(String key) {
        return majorLikeCount.get(key);
    }


    /**
     * Gets majorHeard
     * 
     * @return the number heard with a certain major
     * @param key
     *            what major the user is
     */
    public int getMajorHeard(String key) {
        return majorHeardCount.get(key);
    }


    /**
     * Gets stateLike
     * 
     * @return the number like with a certain state
     * @param key
     *            what state the user is
     */
    public int getStateLike(String key) {
        return stateLikeCount.get(key);
    }


    /**
     * Gets stateHeard
     * 
     * @return the number heard with a certain state
     * @param key
     *            what state the user is
     */
    public int getStateHeard(String key) {
        return stateHeardCount.get(key);
    }


    /**
     * Gets totalCount
     * 
     * @return the number of the total number of users
     *         surveryed corrected with if they liked the song
     * @param key
     *            what hobby the user is
     */
    public int getHobbyTotalLikeCount(String key) {
        return hobbyTotalLikeCount.get(key);
    }


    /**
     * Gets totalCount
     * 
     * @return the number of the total number of users
     *         surveryed corrected with if they heard the song
     * @param key
     *            what hobby the user is
     */
    public int getHobbyTotalHeardCount(String key) {
        return hobbyTotalHeardCount.get(key);
    }


    /**
     * Gets totalCount
     * 
     * @return the number of the total number of users
     *         surveryed corrected with if they liked the song
     * @param key
     *            what major the user is
     */
    public int getMajorTotalLikeCount(String key) {
        return majorTotalLikeCount.get(key);
    }


    /**
     * Gets totalCount
     * 
     * @return the number of the total number of users
     *         surveryed corrected with if they heard the song
     * @param key
     *            what major the user is
     */
    public int getMajorTotalHeardCount(String key) {
        return majorTotalHeardCount.get(key);
    }


    /**
     * Gets totalCount
     * 
     * @return the number of the total number of users
     *         surveryed corrected with if they liked the song
     * @param key
     *            what state the user is
     */
    public int getStateTotalLikeCount(String key) {
        return stateTotalLikeCount.get(key);
    }


    /**
     * Gets totalCount
     * 
     * @return the number of the total number of users
     *         surveryed corrected with if they heard the song
     * @param key
     *            what state the user is
     */
    public int getStateTotalHeardCount(String key) {
        return stateTotalHeardCount.get(key);
    }

}
