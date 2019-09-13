// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
//

package prj5;

import java.awt.Color;
import CS2114.*;

/**
 * Creates the class for the GlyphCreator
 * 
 * @author Caroline Hoang
 * @version 2019.08.15
 */
public class GUIGlyphCreator {

    private TextShape text;
    private TextShape artist;

    private TextShape genre;
    private TextShape year;
    private TextShape title;
    private Shape bar;
    private Controller controller;


    /**
     * Constructor for the GlyphCreator accesses
     * the Controller class
     * 
     * @param controller
     *            the controller for the project
     */
    public GUIGlyphCreator(Controller controller) {
        super();

        this.controller = controller;
    }


    /**
     * Creates the key of the legend
     * 
     */
    private void setLegend(
        String legendTitle,
        String firsttext,
        String secondtext,
        String thirdtext,
        String fourthtext,
        Window window) {

        int x = 780;
        int y = 200;

        text = new TextShape(x, y, legendTitle, Color.BLACK);
        text.setBackgroundColor(Color.WHITE);
        window.addShape(text);

        text = new TextShape(x, y + 20, firsttext, Color.MAGENTA);
        text.setBackgroundColor(Color.WHITE);
        window.addShape(text);
        text = new TextShape(x, y + 40, secondtext, Color.BLUE);
        text.setBackgroundColor(Color.WHITE);
        window.addShape(text);
        text = new TextShape(x, y + 60, thirdtext, Color.ORANGE);
        text.setBackgroundColor(Color.WHITE);
        window.addShape(text);
        text = new TextShape(x, y + 80, fourthtext, Color.GREEN);
        text.setBackgroundColor(Color.WHITE);
        window.addShape(text);

        text = new TextShape(x + 15, y + 100, "Song Title", Color.BLACK);
        text.setBackgroundColor(Color.WHITE);
        window.addShape(text);

        text = new TextShape(x + 5, y + 130, "Heard", Color.BLACK);
        text.setBackgroundColor(Color.WHITE);
        window.addShape(text);

        text = new TextShape(x + 55, y + 130, "Likes", Color.BLACK);
        text.setBackgroundColor(Color.WHITE);
        window.addShape(text);

        bar = new Shape(x + 50, y + 120, 5, 40, Color.BLACK); // line
        window.addShape(bar);

        bar = new Shape(x - 5, y - 5, 115, 175, Color.BLACK); // box
        bar.setBackgroundColor(Color.WHITE);
        window.addShape(bar);
    }


    /**
     * Displays the legend by hobby
     */
    private void displayHobbyLegend(Window window) {
        setLegend("Hobby Legend", "Read", "Art", "Sports", "Music", window);
    }


    /**
     * Displays the legend by major
     */
    private void displayMajorLegend(Window window) {
        setLegend("Major Legend", "Comp Sci", "Other Eng", "Math/CMDA", "Other",
            window);
    }


    /**
     * Displays the legend by state
     */
    private void displayStateLegend(Window window) {
        setLegend("State Legend", "Northeast US", "Southeast US",
            "Rest of the US", "Outside the US", window);
    }


    /**
     * Makes the glyph represented by hobby
     * 
     * @param window
     *            the window object
     * @param counter
     *            an incremented counter
     * @param songList
     *            the list of songs
     */
    public void songHobbyGlyph(
        Window window,
        int counter,
        SingleLinkedList<Song> songList) {

        int width = 0;
        int height = 0;

        int x = 140;
        int y = 10;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                Song songy = songList.getAt(counter);

                artist = new TextShape(x, y, songy.getSongName());
                double artistWidth = artist.getWidth() / 2 + 2.5;
                artist = new TextShape(x - (int)Math.round(artistWidth) + width,
                    y + height, songy.getSongName(), Color.BLACK);
                artist.setBackgroundColor(Color.WHITE);
                window.addShape(artist);

                title = new TextShape(x, y, "By: " + songy.getArtistName());
                double nameWidth = title.getWidth() / 2 + 2.5;
                title = new TextShape(x - (int)Math.round(nameWidth) + width, y
                    + height + 15, "By: " + songy.getArtistName(), Color.BLACK);
                title.setBackgroundColor(Color.WHITE);
                window.addShape(title);

                genre = new TextShape(x, y, "Genre: " + songy.getGenre());
                double genreWidth = genre.getWidth() / 2 + 2.5;
                genre = new TextShape(x - (int)Math.round(genreWidth) + width, y
                    + height + 30, "Genre: " + songy.getGenre(), Color.BLACK);
                genre.setBackgroundColor(Color.WHITE);
                window.addShape(genre);

                year = new TextShape(x, y, "Year: " + songy.getDate());
                double dateWidth = year.getWidth() / 2 + 2.5;
                year = new TextShape(x - (int)Math.round(dateWidth) + width, y
                    + height + 45, "Year: " + songy.getDate(), Color.BLACK);
                year.setBackgroundColor(Color.WHITE);
                window.addShape(year);

                Shape firstHeard = new Shape(x + width - (int)Math.round(
                    controller.getHobbyHeardPercentage(songList, counter)[0]), y
                        + height + 65, (int)Math.round(controller
                            .getHobbyHeardPercentage(songList, counter)[0]), 10,
                    Color.MAGENTA);
                Shape secondHeard = new Shape(x + width - (int)Math.round(
                    controller.getHobbyHeardPercentage(songList, counter)[1]), y
                        + height + 75, (int)Math.round(controller
                            .getHobbyHeardPercentage(songList, counter)[1]), 10,
                    Color.BLUE);
                Shape thirdHeard = new Shape(x + width - (int)Math.round(
                    controller.getHobbyHeardPercentage(songList, counter)[2]), y
                        + height + 85, (int)Math.round(controller
                            .getHobbyHeardPercentage(songList, counter)[2]), 10,
                    Color.ORANGE);
                Shape fourthHeard = new Shape(x + width - (int)Math.round(
                    controller.getHobbyHeardPercentage(songList, counter)[3]), y
                        + height + 95, (int)Math.round(controller
                            .getHobbyHeardPercentage(songList, counter)[3]), 10,
                    Color.GREEN);

                bar = new Shape(x + width, y + height + 65, 5, 40, Color.BLACK);

                Shape firstLike = new Shape(x + width + 5, y + height + 65,
                    (int)Math.round(controller.getHobbyLikePercentage(songList,
                        counter)[0]), 10, Color.MAGENTA);
                Shape secondLike = new Shape(x + width + 5, y + height + 75,
                    (int)Math.round(controller.getHobbyLikePercentage(songList,
                        counter)[1]), 10, Color.BLUE);
                Shape thirdLike = new Shape(x + width + 5, y + height + 85,
                    (int)Math.round(controller.getHobbyLikePercentage(songList,
                        counter)[2]), 10, Color.ORANGE);
                Shape fourthLike = new Shape(x + width + 5, y + height + 95,
                    (int)Math.round(controller.getHobbyLikePercentage(songList,
                        counter)[3]), 10, Color.GREEN);

                window.addShape(firstHeard);
                window.addShape(secondHeard);
                window.addShape(thirdHeard);
                window.addShape(fourthHeard);

                window.addShape(bar);

                window.addShape(firstLike);
                window.addShape(secondLike);
                window.addShape(thirdLike);
                window.addShape(fourthLike);
                width = width + 250;
                counter++;
            }
            width = 0;
            height = height + 125;
        }

        this.displayHobbyLegend(window);
    }


    /**
     * Makes the glyph represented by major
     * 
     * @param window
     *            the window object
     * @param counter
     *            an incremented counter
     * @param songList
     *            the list of songs
     */
    public void songMajorGlyph(
        Window window,
        int counter,
        SingleLinkedList<Song> songList) {

        int width = 0;
        int height = 0;

        int x = 140;
        int y = 10;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {
                Song songy = songList.getAt(counter);

                artist = new TextShape(x, y, songy.getSongName());
                double artistWidth = artist.getWidth() / 2 + 2.5;
                artist = new TextShape(x - (int)Math.round(artistWidth) + width,
                    y + height, songy.getSongName(), Color.BLACK);
                artist.setBackgroundColor(Color.WHITE);
                window.addShape(artist);

                title = new TextShape(x, y, "By: " + songy.getArtistName());
                double nameWidth = title.getWidth() / 2 + 2.5;
                title = new TextShape(x - (int)Math.round(nameWidth) + width, y
                    + height + 15, "By: " + songy.getArtistName(), Color.BLACK);
                title.setBackgroundColor(Color.WHITE);
                window.addShape(title);

                genre = new TextShape(x, y, "Genre: " + songy.getGenre());
                double genreWidth = genre.getWidth() / 2 + 2.5;
                genre = new TextShape(x - (int)Math.round(genreWidth) + width, y
                    + height + 30, "Genre: " + songy.getGenre(), Color.BLACK);
                genre.setBackgroundColor(Color.WHITE);
                window.addShape(genre);

                year = new TextShape(x, y, "Year: " + songy.getDate());
                double dateWidth = year.getWidth() / 2 + 2.5;
                year = new TextShape(x - (int)Math.round(dateWidth) + width, y
                    + height + 45, "Year: " + songy.getDate(), Color.BLACK);
                year.setBackgroundColor(Color.WHITE);
                window.addShape(year);

                Shape firstHeard = new Shape(x + width - (int)Math.round(
                    controller.getMajorHeardPercentage(songList, counter)[0]), y
                        + height + 65, (int)Math.round(controller
                            .getMajorHeardPercentage(songList, counter)[0]), 10,
                    Color.MAGENTA);
                Shape secondHeard = new Shape(x + width - (int)Math.round(
                    controller.getMajorHeardPercentage(songList, counter)[1]), y
                        + height + 75, (int)Math.round(controller
                            .getMajorHeardPercentage(songList, counter)[1]), 10,
                    Color.BLUE);
                Shape thirdHeard = new Shape(x + width - (int)Math.round(
                    controller.getMajorHeardPercentage(songList, counter)[2]), y
                        + height + 85, (int)Math.round(controller
                            .getMajorHeardPercentage(songList, counter)[2]), 10,
                    Color.ORANGE);
                Shape fourthHeard = new Shape(x + width - (int)Math.round(
                    controller.getMajorHeardPercentage(songList, counter)[3]), y
                        + height + 95, (int)Math.round(controller
                            .getMajorHeardPercentage(songList, counter)[3]), 10,
                    Color.GREEN);

                bar = new Shape(x + width, y + height + 65, 5, 40, Color.BLACK);

                Shape firstLike = new Shape(x + width + 5, y + height + 65,
                    (int)Math.round(controller.getMajorLikePercentage(songList,
                        counter)[0]), 10, Color.MAGENTA);
                Shape secondLike = new Shape(x + width + 5, y + height + 75,
                    (int)Math.round(controller.getMajorLikePercentage(songList,
                        counter)[1]), 10, Color.BLUE);
                Shape thirdLike = new Shape(x + width + 5, y + height + 85,
                    (int)Math.round(controller.getMajorLikePercentage(songList,
                        counter)[2]), 10, Color.ORANGE);
                Shape fourthLike = new Shape(x + width + 5, y + height + 95,
                    (int)Math.round(controller.getMajorLikePercentage(songList,
                        counter)[3]), 10, Color.GREEN);

                window.addShape(firstHeard);
                window.addShape(secondHeard);
                window.addShape(thirdHeard);
                window.addShape(fourthHeard);

                window.addShape(bar);

                window.addShape(firstLike);
                window.addShape(secondLike);
                window.addShape(thirdLike);
                window.addShape(fourthLike);
                width = width + 250;
                counter++;
            }
            width = 0;
            height = height + 125;
        }
        this.displayMajorLegend(window);
    }


    /**
     * Makes the glyph represented by state
     * 
     * @param window
     *            the window object
     * @param counter
     *            an incremented counter
     * @param songList
     *            the list of songs
     */
    public void songStateGlyph(
        Window window,
        int counter,
        SingleLinkedList<Song> songList) {

        int width = 0;
        int height = 0;

        int x = 140;
        int y = 10;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                Song songy = songList.getAt(counter);
                artist = new TextShape(x, y, songy.getSongName());
                double artistWidth = artist.getWidth() / 2 + 2.5;
                artist = new TextShape(x - (int)Math.round(artistWidth) + width,
                    y + height, songy.getSongName(), Color.BLACK);
                artist.setBackgroundColor(Color.WHITE);
                window.addShape(artist);

                title = new TextShape(x, y, "By: " + songy.getArtistName());
                double nameWidth = title.getWidth() / 2 + 2.5;
                title = new TextShape(x - (int)Math.round(nameWidth) + width, y
                    + height + 15, "By: " + songy.getArtistName(), Color.BLACK);
                title.setBackgroundColor(Color.WHITE);
                window.addShape(title);

                genre = new TextShape(x, y, "Genre: " + songy.getGenre());
                double genreWidth = genre.getWidth() / 2 + 2.5;
                genre = new TextShape(x - (int)Math.round(genreWidth) + width, y
                    + height + 30, "Genre: " + songy.getGenre(), Color.BLACK);
                genre.setBackgroundColor(Color.WHITE);
                window.addShape(genre);

                year = new TextShape(x, y, "Year: " + songy.getDate());
                double dateWidth = year.getWidth() / 2 + 2.5;
                year = new TextShape(x - (int)Math.round(dateWidth) + width, y
                    + height + 45, "Year: " + songy.getDate(), Color.BLACK);
                year.setBackgroundColor(Color.WHITE);
                window.addShape(year);

                Shape firstHeard = new Shape(x + width - (int)Math.round(
                    controller.getStateHeardPercentage(songList, counter)[0]), y
                        + height + 65, (int)Math.round(controller
                            .getStateHeardPercentage(songList, counter)[0]), 10,
                    Color.MAGENTA);

                Shape secondHeard = new Shape(x + width - (int)Math.round(
                    controller.getStateHeardPercentage(songList, counter)[1]), y
                        + height + 75, (int)Math.round(controller
                            .getStateHeardPercentage(songList, counter)[1]), 10,
                    Color.BLUE);

                Shape thirdHeard = new Shape(x + width - (int)Math.round(
                    controller.getStateHeardPercentage(songList, counter)[2]), y
                        + height + 85, (int)Math.round(controller
                            .getStateHeardPercentage(songList, counter)[2]), 10,
                    Color.ORANGE);

                Shape fourthHeard = new Shape(x + width - (int)Math.round(
                    controller.getStateHeardPercentage(songList, counter)[3]), y
                        + height + 95, (int)Math.round(controller
                            .getStateHeardPercentage(songList, counter)[3]), 10,
                    Color.GREEN);

                bar = new Shape(x + width, y + height + 65, 5, 40, Color.BLACK);

                Shape firstLike = new Shape(x + width + 5, y + height + 65,
                    (int)Math.round(controller.getStateLikePercentage(songList,
                        counter)[0]), 10, Color.MAGENTA);
                Shape secondLike = new Shape(x + width + 5, y + height + 75,
                    (int)Math.round(controller.getStateLikePercentage(songList,
                        counter)[1]), 10, Color.BLUE);
                Shape thirdLike = new Shape(x + width + 5, y + height + 85,
                    (int)Math.round(controller.getStateLikePercentage(songList,
                        counter)[2]), 10, Color.ORANGE);
                Shape fourthLike = new Shape(x + width + 5, y + height + 95,
                    (int)Math.round(controller.getStateLikePercentage(songList,
                        counter)[3]), 10, Color.GREEN);

                window.addShape(firstHeard);
                window.addShape(secondHeard);
                window.addShape(thirdHeard);
                window.addShape(fourthHeard);

                window.addShape(bar);

                window.addShape(firstLike);
                window.addShape(secondLike);
                window.addShape(thirdLike);
                window.addShape(fourthLike);

                width = width + 250;
                counter++;
            }
            width = 0;
            height = height + 125;
        }

        this.displayStateLegend(window);
    }

}
