/*
 * @author Taimoor Qamar
 * @version 2019.13.08
 */

package prj5;
/**
 * Creates the GUI class
 */
import CS2114.*;

public class GUIDisplay extends GUIGlyphCreator {

    private int pageNum;
    private GUIGlyphCreator glyph;
    private int legend;
    private SingleLinkedList<Song> songList;

    private Window window;
    private Button prevButton;
    private Button nextButton;
    private Button quitButton;
    private Button sortArtistNameButton;
    private Button sortSongNameButton;
    private Button sortGenreButton;
    private Button sortDateButton;
    private Button representHobbyButton;
    private Button representMajorButton;
    private Button representStateButton;
    private Controller control;

    public GUIDisplay(Controller controller, SingleLinkedList<Song> songList) {
        super(controller);
        control = controller;
        window = new Window("hoangcd tdeel adamc1 tqamar");
        window.setSize(925, 500);
        this.songList = songList;

        legend = -1;
        prevButton = new Button("Previous");
        nextButton = new Button("Next");
        quitButton = new Button("Quit");
        sortArtistNameButton = new Button("Sort By Artist Name");
        sortSongNameButton = new Button("Sort By Song Title");
        sortGenreButton = new Button("Sort By Genre");
        sortDateButton = new Button("Sort By Release Year");
        representHobbyButton = new Button("Represent Hobby");
        representMajorButton = new Button("Represent Major");
        representStateButton = new Button("Represent State");

        prevButton.onClick(this, "clickedPrev");
        nextButton.onClick(this, "clickedNext");
        quitButton.onClick(this, "clickedQuit");
        sortArtistNameButton.onClick(this, "clickedArtistName");
        sortSongNameButton.onClick(this, "clickedSongName");
        sortGenreButton.onClick(this, "clickedGenre");
        sortDateButton.onClick(this, "clickedDate");
        representHobbyButton.onClick(this, "clickedHobby");
        ;
        representMajorButton.onClick(this, "clickedMajor");
        representStateButton.onClick(this, "clickedState");

        window.addButton(prevButton, WindowSide.NORTH);
        window.addButton(sortArtistNameButton, WindowSide.NORTH);
        window.addButton(sortSongNameButton, WindowSide.NORTH);
        window.addButton(sortGenreButton, WindowSide.NORTH);
        window.addButton(sortDateButton, WindowSide.NORTH);
        window.addButton(nextButton, WindowSide.NORTH);
        window.addButton(representHobbyButton, WindowSide.SOUTH);
        window.addButton(representMajorButton, WindowSide.SOUTH);
        window.addButton(representStateButton, WindowSide.SOUTH);
        window.addButton(quitButton, WindowSide.SOUTH);
        glyph = new GUIGlyphCreator(controller);
    }

    /**
     * Gets the window
     * 
     * @return window
     */
    public Window getWindow() {
        return window;
    }

    /**
     * Will signal what methods to use based on the
     * represented legend
     * Used for the previous and next buttons
     */
    public void legendType(SingleLinkedList<Song> singleLinkedList) {
        if (legend == 0) {
            glyph.songHobbyGlyph(window, 9 * pageNum, singleLinkedList);
        }

        else if (legend == 1) {
            glyph.songMajorGlyph(window, 9 * pageNum, singleLinkedList);
        }

        else if (legend == 2) {
            glyph.songStateGlyph(window, 9 * pageNum, singleLinkedList);
        }
    }

    /**
     * Will go to the previous page when the button is clicked
     */
    public void clickedPrev(Button prevButton) {
        window.removeAllShapes();
        if (pageNum > 0) {
            pageNum--;
            this.legendType(songList);
        }
    }

    /**
     * Will go to the next page when the button is clicked
     */
    public void clickedNext(Button nextButton) {
        window.removeAllShapes();
        if (pageNum < 7) {
            pageNum++;
            this.legendType(songList);
        }
    }

    /**
     * Will exit the GUI
     */
    public void clickedQuit(Button quitutton) {
        System.exit(0);
    }

    /**
     * Will sort by the artist's name when the button is clicked
     */
    public void clickedArtistName(Button sortByArtistNameButton) {
        songList = control.sortByArtist(songList);
        window.removeAllShapes();
        pageNum = 0;
        this.legendType(songList);
    }

    /**
     * Will sort by the song name when the button is clicked
     */
    public void clickedSongName(Button sortBySongNameButton) {
        songList = control.sortByTitle(songList);
        window.removeAllShapes();
        pageNum = 0;
        this.legendType(songList);
    }

    /**
     * Will sort by genre when the button is clicked
     */
    public void clickedGenre(Button sortByGenreButton) {
        songList = control.sortByGenre(songList);
        window.removeAllShapes();
        pageNum = 0;
        this.legendType(songList);
    }

    /**
     * Will sort by the date when the button is clicked
     */
    public void clickedDate(Button sortByDateButton) {
        songList = control.sortByDate(songList);
        pageNum = 0;
        window.removeAllShapes();
        this.legendType(songList);
    }

    /**
     * Will represent the data by Hobby when the button is clicked
     */
    public void clickedHobby(Button representHobbyButton) {
        legend = 0;
        pageNum = 0;
        window.removeAllShapes();
        glyph.songHobbyGlyph(window, 0, songList);
    }


    /**
     * Will represent the data by Major when the button is clicked
     */
    public void clickedMajor(Button representMajorButton) {
        legend = 1;
        pageNum = 0;
        window.removeAllShapes();
        glyph.songMajorGlyph(window, 0, songList);
    }

    /**
     * Will represent the data by State when the button is clicked
     */
    public void clickedState(Button representStateButton) {
        legend = 2;
        pageNum = 0;
        window.removeAllShapes();
        glyph.songStateGlyph(window, 0, songList);

    }
    
    

}
