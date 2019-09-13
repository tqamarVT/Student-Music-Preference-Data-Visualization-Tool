// Virginia Tech Honor Code Pledge:

//
// As a Hokie, I will conduct myself with honor and doubleegrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Caroline Hoang (hoangcd)

package prj5;

/**
 * The class that calculates the percentages for the glyphs
 * 
 * @author Caroline Hoang
 * @version 08.13.2019
 *
 */
public class Controller {

    private double[] hobbyLike;
    private double[] hobbyHeard;
    private double[] majorLike;
    private double[] majorHeard;
    private double[] stateLike;
    private double[] stateHeard;


    /**
     * Constructor for the Controller
     */
    public Controller() {
        hobbyLike = new double[4];
        hobbyHeard = new double[4];
        majorLike = new double[4];
        majorHeard = new double[4];
        stateLike = new double[4];
        stateHeard = new double[4];
    }


    /**
     * @param singleLinkedList
     *            of the songList
     * @param index
     *            of the song
     * @return the percentages of the hobbies
     */
    public double[] getHobbyLikePercentage(
        SingleLinkedList<Song> singleLinkedList,
        int index) {
        hobbyLike[0] = (singleLinkedList.getAt(index).getHobbyLike("reading")
            * 1.0) / (singleLinkedList.getAt(index).getHobbyTotalLikeCount(
                "reading") * 1.0) * 100;
        hobbyLike[1] = (singleLinkedList.getAt(index).getHobbyLike("art") * 1.0)
            / (singleLinkedList.getAt(index).getHobbyTotalLikeCount("art")
                * 1.0) * 100;
        hobbyLike[2] = (singleLinkedList.getAt(index).getHobbyLike("sports")
            * 1.0) / (singleLinkedList.getAt(index).getHobbyTotalLikeCount(
                "sports") * 1.0) * 100;
        hobbyLike[3] = (singleLinkedList.getAt(index).getHobbyLike("music")
            * 1.0) / (singleLinkedList.getAt(index).getHobbyTotalLikeCount(
                "music") * 1.0) * 100;

        return hobbyLike;
    }


    /**
     * @param singleLinkedList
     *            of the songList
     * @param index
     *            of the song
     * @return the percentages of the hobbies
     */
    public double[] getHobbyHeardPercentage(
        SingleLinkedList<Song> singleLinkedList,
        int index) {
        hobbyHeard[0] = (singleLinkedList.getAt(index).getHobbyHeard("reading")
            * 1.0) / (singleLinkedList.getAt(index).getHobbyTotalHeardCount(
                "reading") * 1.0) * 100;
        hobbyHeard[1] = (singleLinkedList.getAt(index).getHobbyHeard("art")
            * 1.0) / (singleLinkedList.getAt(index).getHobbyTotalHeardCount(
                "art") * 1.0) * 100;
        hobbyHeard[2] = (singleLinkedList.getAt(index).getHobbyHeard("sports")
            * 1.0) / (singleLinkedList.getAt(index).getHobbyTotalHeardCount(
                "sports") * 1.0) * 100;
        hobbyHeard[3] = (singleLinkedList.getAt(index).getHobbyHeard("music")
            * 1.0) / (singleLinkedList.getAt(index).getHobbyTotalHeardCount(
                "music") * 1.0) * 100;

        return hobbyHeard;
    }


    /**
     * @param singleLinkedList
     *            of the songList
     * @param index
     *            of the song
     * @return the percentages of the major
     */
    public double[] getMajorLikePercentage(
        SingleLinkedList<Song> singleLinkedList,
        int index) {
        majorLike[0] = (singleLinkedList.getAt(index).getMajorLike(
            "Computer Science") * 1.0) / (singleLinkedList.getAt(index)
                .getMajorTotalLikeCount("Computer Science") * 1.0) * 100;
        majorLike[1] = (singleLinkedList.getAt(index).getMajorLike(
            "Other Engineering") * 1.0) / (singleLinkedList.getAt(index)
                .getMajorTotalLikeCount("Other Engineering") * 1.0) * 100;
        majorLike[2] = (singleLinkedList.getAt(index).getMajorLike(
            "Math or CMDA") * 1.0) / (singleLinkedList.getAt(index)
                .getMajorTotalLikeCount("Math or CMDA") * 1.0) * 100;
        majorLike[3] = (singleLinkedList.getAt(index).getMajorLike("Other")
            * 1.0) / (singleLinkedList.getAt(index).getMajorTotalLikeCount(
                "Other") * 1.0) * 100;

        return majorLike;
    }


    /**
     * @param singleLinkedList
     *            of the songList
     * @param index
     *            of the song
     * @return the percentages of the majors
     */
    public double[] getMajorHeardPercentage(
        SingleLinkedList<Song> singleLinkedList,
        int index) {
        majorHeard[0] = (singleLinkedList.getAt(index).getMajorHeard(
            "Computer Science") * 1.0) / (singleLinkedList.getAt(index)
                .getMajorTotalHeardCount("Computer Science") * 1.0) * 100;
        majorHeard[1] = (singleLinkedList.getAt(index).getMajorHeard(
            "Other Engineering") * 1.0) / (singleLinkedList.getAt(index)
                .getMajorTotalHeardCount("Other Engineering") * 1.0) * 100;
        majorHeard[2] = (singleLinkedList.getAt(index).getMajorHeard(
            "Math or CMDA") * 1.0) / (singleLinkedList.getAt(index)
                .getMajorTotalHeardCount("Math or CMDA") * 1.0) * 100;
        majorHeard[3] = (singleLinkedList.getAt(index).getMajorHeard("Other")
            * 1.0) / (singleLinkedList.getAt(index).getMajorTotalHeardCount(
                "Other") * 1.0) * 100;

        return majorHeard;
    }


    /**
     * @param singleLinkedList
     *            of the songList
     * @param index
     *            of the song
     * @return the percentages of the states like
     */
    public double[] getStateLikePercentage(
        SingleLinkedList<Song> singleLinkedList,
        int index) {
        stateLike[0] = (singleLinkedList.getAt(index).getStateLike("Northeast")
            * 1.0) / (singleLinkedList.getAt(index).getStateTotalLikeCount(
                "Northeast") * 1.0) * 100;
        stateLike[1] = (singleLinkedList.getAt(index).getStateLike("Southeast")
            * 1.0) / (singleLinkedList.getAt(index).getStateTotalLikeCount(
                "Southeast") * 1.0) * 100;
        stateLike[2] = (singleLinkedList.getAt(index).getStateLike(
            "United States (other than Southeast or Northwest)") * 1.0)
            / (singleLinkedList.getAt(index).getStateTotalLikeCount(
                "United States (other than Southeast or Northwest)") * 1.0)
            * 100;
        stateLike[3] = (singleLinkedList.getAt(index).getStateLike(
            "Outside of United States") * 1.0) / (singleLinkedList.getAt(index)
                .getStateTotalLikeCount("Outside of United States") * 1.0)
            * 100;

        return stateLike;
    }


    /**
     * @param singleLinkedList
     *            of the songList
     * @param index
     *            of the song
     * @return the percentages of the state heard
     */
    public double[] getStateHeardPercentage(
        SingleLinkedList<Song> singleLinkedList,
        int index) {
        stateHeard[0] = (singleLinkedList.getAt(index).getStateHeard(
            "Northeast") * 1.0) / (singleLinkedList.getAt(index)
                .getStateTotalHeardCount("Northeast") * 1.0) * 100;
        stateHeard[1] = (singleLinkedList.getAt(index).getStateHeard(
            "Southeast") * 1.0) / (singleLinkedList.getAt(index)
                .getStateTotalHeardCount("Southeast") * 1.0) * 100;
        stateHeard[2] = (singleLinkedList.getAt(index).getStateHeard(
            "United States (other than Southeast or Northwest)") * 1.0)
            / (singleLinkedList.getAt(index).getStateTotalHeardCount(
                "United States (other than Southeast or Northwest)") * 1.0)
            * 100;
        stateHeard[3] = (singleLinkedList.getAt(index).getStateHeard(
            "Outside of United States") * 1.0) / (singleLinkedList.getAt(index)
                .getStateTotalHeardCount("Outside of United States") * 1.0)
            * 100;

        return stateHeard;
    }


    /**
     * Will sort the singleLinkedList by artist name
     * 
     * @param list
     *            the list to be sorted
     * 
     * @return the sorted SingleLinkedList
     */
    public SingleLinkedList<Song> sortByArtist(SingleLinkedList<Song> list) {
        int i;
        int j;
        Song key;
        ArtistComparator comparator = new ArtistComparator();
        for (j = 1; j < list.size(); j++) {
            key = list.getAt(j);
            i = j - 1;
            while (i >= 0) {
                if (comparator.compare(key, list.getAt(i)) >= 0) {
                    break;
                }
                else {
                    list.swap(i + 1, i);
                    i--;
                }
            }
        }
        return list;
    }


    /**
     * Will sort the singleLinkedList by artist name
     * 
     * @param list
     *            the list to be sorted
     * 
     * @return the sorted SingleLinkedList
     */
    public SingleLinkedList<Song> sortByGenre(SingleLinkedList<Song> list) {
        int i;
        int j;
        Song key;
        GenreComparator comparator = new GenreComparator();
        for (j = 1; j < list.size(); j++) {
            key = list.getAt(j);
            i = j - 1;
            while (i >= 0) {
                if (comparator.compare(key, list.getAt(i)) >= 0) {
                    break;
                }
                else {
                    list.swap(i + 1, i);
                    i--;
                }
            }
        }
        return list;
    }


    /**
     * Will sort the singleLinkedList by artist name
     * 
     * @param list
     *            the list to be sorted
     * 
     * @return the sorted SingleLinkedList
     */
    public SingleLinkedList<Song> sortByDate(SingleLinkedList<Song> list) {
        int i;
        int j;
        Song key;
        DateComparator comparator = new DateComparator();
        for (j = 1; j < list.size(); j++) {
            key = list.getAt(j);
            i = j - 1;
            while (i >= 0) {
                if (comparator.compare(key, list.getAt(i)) >= 0) {
                    break;
                }
                else {
                    list.swap(i + 1, i);
                    i--;
                }
            }
        }
        return list;
    }


    /**
     * Will sort the singleLinkedList by artist name
     * 
     * @param list
     *            the list to be sorted
     * 
     * @return the sorted SingleLinkedList
     */
    public SingleLinkedList<Song> sortByTitle(SingleLinkedList<Song> list) {
        int i;
        int j;
        Song key;
        TitleComparator comparator = new TitleComparator();
        for (j = 1; j < list.size(); j++) {
            key = list.getAt(j);
            i = j - 1;
            while (i >= 0) {
                if (comparator.compare(key, list.getAt(i)) >= 0) {
                    break;
                }
                else {
                    list.swap(i + 1, i);
                    i--;
                }
            }
        }
        return list;
    }
}
