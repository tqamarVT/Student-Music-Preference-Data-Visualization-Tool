// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and doubleegrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Group One (tqamar, adamc1, hoangcd, tdeel)

package prj5;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * This class takes in String inputs passed to it via the parameter and fills a
 * LinkedList of type song with the appropriate song data, and updates each song
 * with the appropriate student data.
 * 
 * @author Group One (tqamar, adamc1, hoangcd, tdeel)
 * @version 2019.13.08
 */
public class Reader {
    private SingleLinkedList<Song> songLinkedList;
    private Controller controller;
    private SingleLinkedList<Song> copy;


    /**
     * Constructor for the Reader class.
     */
    public Reader(String student, String song) throws FileNotFoundException {
        this.songLinkedList = new SingleLinkedList<Song>();
        copy = new SingleLinkedList<Song>();
        readSongData(song);
        readStudentData(student);
        this.controller = new Controller();
        intermediateTestPrintMethod();

    }


    /**
     * Method that will read song files and store them as a Song
     * in a linked list
     * 
     * @param data
     *            the csv of the song file
     * @throws FileNotFoundException
     */
    public void readSongData(String data) throws FileNotFoundException {
        File songDataFile = new File(data);
        Scanner songReader = new Scanner(songDataFile);
        String[] songReaderArr;

        songReader.nextLine();
        while (songReader.hasNextLine()) {
            songReaderArr = songReader.nextLine().trim().split(",");
            this.songLinkedList.add(new Song(songReaderArr[0], songReaderArr[1],
                songReaderArr[2], songReaderArr[3]));
            this.copy.add(new Song(songReaderArr[0], songReaderArr[1],
                songReaderArr[2], songReaderArr[3]));
        }
        songReader.close();
    }


    /**
     * Will scan throughout the user file and increment data
     * based off the users hobby, major and state
     * 
     * @param data
     *            the csv of the user information
     * @throws FileNotFoundException
     */
    public void readStudentData(String data) throws FileNotFoundException {
        File studentDataFile = new File(data);
        Scanner studentReader = new Scanner(studentDataFile);
        String[] studentReaderArr;
        String[] updatedStudentArr;
        String[] likeHeardArr;
        int minNumOfElements = 5;
        int fullReaderString = this.songLinkedList.size() * 2
            + minNumOfElements;
        int heardIndex = 0;
        int likeIndex = 1;
        int songIndex = 0;

        studentReader.nextLine();
        while (studentReader.hasNextLine()) {
            studentReaderArr = studentReader.nextLine().trim().split(",");
            if (studentReaderArr.length < fullReaderString) {
                updatedStudentArr = new String[fullReaderString];
                for (int i = 0; i < studentReaderArr.length; i++) {
                    updatedStudentArr[i] = studentReaderArr[i];
                }
                for (int i =
                    studentReaderArr.length; i < updatedStudentArr.length; i++) {
                    updatedStudentArr[i] = "";
                }
            }
            else {
                updatedStudentArr = studentReaderArr;
            }
            if (updatedStudentArr.length < minNumOfElements) {
                continue;
            }
            String major = updatedStudentArr[2];
            String state = updatedStudentArr[3];
            String hobby = updatedStudentArr[4];
            likeHeardArr = this.copyOfRange(updatedStudentArr, 5,
                updatedStudentArr.length);
            while (likeIndex < likeHeardArr.length) {
                String heard = likeHeardArr[heardIndex];
                String like = likeHeardArr[likeIndex];
                this.songLinkedList.getAt(songIndex).majorCounter(major, like,
                    heard);
                this.copy.getAt(songIndex).majorCounter(major, like, heard);
                this.songLinkedList.getAt(songIndex).stateCounter(state, like,
                    heard);
                this.copy.getAt(songIndex).stateCounter(state, like, heard);
                this.songLinkedList.getAt(songIndex).hobbyCounter(hobby, like,
                    heard);
                this.copy.getAt(songIndex).hobbyCounter(hobby, like, heard);
                heardIndex += 2;
                likeIndex += 2;
                songIndex++;
            }
            heardIndex = 0;
            likeIndex = 1;
            songIndex = 0;
        }
        studentReader.close();
    }


    /**
     * Makes a deep copy of the array starting from and ending at the values of
     * the from and to parameters passed.
     * 
     * @param myarray
     * @param from
     * @param to
     * @return deep copy of the new array
     */
    private String[] copyOfRange(String[] myarray, int from, int to) {
        String[] newarray = new String[to - from];
        for (int i = 0; i < to - from; i++) {
            newarray[i] = myarray[i + from];
        }
        return newarray;
    }


    /**
     * getter for the songLinkedList
     * 
     * @return songLinkedList
     */
    public SingleLinkedList<Song> getSongList() {
        return songLinkedList;
    }


    public void intermediateTestPrintMethod() {

        this.copy = this.controller.sortByGenre(copy);
        for (int i = 0; i < this.copy.size(); i++) {
            System.out.print("song title " + this.copy.getAt(i).getSongName());
            System.out.print("\n");
            System.out.print("song artist " + this.copy.getAt(i)
                .getArtistName());
            System.out.print("\n");
            System.out.print("song genre " + this.copy.getAt(i).getGenre());
            System.out.print("\n");
            System.out.print("song year " + this.copy.getAt(i).getDate());
            System.out.print("\n");
            System.out.print("heard");
            System.out.print("\n");
            System.out.print("reading" + (int)this.controller
                .getHobbyHeardPercentage(copy, i)[0] + " " + "art"
                + (int)this.controller.getHobbyHeardPercentage(copy, i)[1] + " "
                + "sports" + (int)this.controller.getHobbyHeardPercentage(copy,
                    i)[2] + " " + "music" + (int)this.controller
                        .getHobbyHeardPercentage(copy, i)[3]);
            System.out.print("\n");
            System.out.print("likes");
            System.out.print("\n");
            System.out.print("reading" + (int)this.controller
                .getHobbyLikePercentage(copy, i)[0] + " " + "art"
                + (int)this.controller.getHobbyLikePercentage(copy, i)[1] + " "
                + "sports" + (int)this.controller.getHobbyLikePercentage(copy,
                    i)[2] + " " + "music" + (int)this.controller
                        .getHobbyLikePercentage(copy, i)[3]);
            System.out.print("\n");
            System.out.print("\n");
        }
        this.copy = this.controller.sortByTitle(copy);
        for (int i = 0; i < this.copy.size(); i++) {
            System.out.print("song title " + this.copy.getAt(i).getSongName());
            System.out.print("\n");
            System.out.print("song artist " + this.copy.getAt(i)
                .getArtistName());
            System.out.print("\n");
            System.out.print("song genre " + this.copy.getAt(i).getGenre());
            System.out.print("\n");
            System.out.print("song year " + this.copy.getAt(i).getDate());
            System.out.print("\n");
            System.out.print("heard");
            System.out.print("\n");
            System.out.print("reading" + (int)this.controller
                .getHobbyHeardPercentage(copy, i)[0] + " " + "art"
                + (int)this.controller.getHobbyHeardPercentage(copy, i)[1] + " "
                + "sports" + (int)this.controller.getHobbyHeardPercentage(copy,
                    i)[2] + " " + "music" + (int)this.controller
                        .getHobbyHeardPercentage(copy, i)[3]);
            System.out.print("\n");
            System.out.print("likes");
            System.out.print("\n");
            System.out.print("reading" + (int)this.controller
                .getHobbyLikePercentage(copy, i)[0] + " " + "art"
                + (int)this.controller.getHobbyLikePercentage(copy, i)[1] + " "
                + "sports" + (int)this.controller.getHobbyLikePercentage(copy,
                    i)[2] + " " + "music" + (int)this.controller
                        .getHobbyLikePercentage(copy, i)[3]);
            System.out.print("\n");
            System.out.print("\n");
        }
    }

}
