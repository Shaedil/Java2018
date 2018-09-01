/*------------------------------------------------------------------------
 *   Copyright (C) 2018 Shaedil Dider                                    |
 *                                                                       |
 *   This program is free software; you can redistribute it and/or modify|
 *   it under the terms of the GNU General Public License as published by|
 *   the Free Software Foundation; either version 2 of the License, or   |
 *   (at your option) any later version.                                 |
 *                                                                       |
 *   This program is distributed in the hope that it will be useful,     |
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of      |
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the        | 
 *   GNU General Public License for more details.                        |
 *------------------------------------------------------------------------
 */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.io.*;
public class hangman {

    public static int score;
    public static int guess;
    public static Scanner scanner;

    public static void main(String[] args) {
        score = guess = 0;
        scanner = new Scanner(System.in);
        String word = getRandomWord();

        printInfo(word); //Game rules and special info
    }
    
    public static void printInfo(String word) {
        
        System.out.println("                .===============+Hangman+==============.");
        System.out.println("                |You have 20 guesses to guess the word |");
        System.out.println("                |The word is " + word.length() + " characters long.        |");
        System.out.println("                |Instances begin on 0 = first letter of|");
        System.out.println("                |   word & 1 = second letter of word   |");
        System.out.println("                |                                      |");
        System.out.println("                |======================================|");
        System.out.println("                |Guess the word before you run out of  |");
        System.out.println("                |               guesses.               |");
        System.out.println("                |                                      |");
        System.out.println("                |--------------------------------------|");
        System.out.println("                |TIP:Don't guess the same letter twice |");
        System.out.println("                |                 else!                |");
        System.out.println("                |______________________________________|" + "\n\n");
        startGame(word);
    }

    public static String getRandomWord() {
        
        String[] wordList = {"AWKWARD", "BAGPIPES", "BANJO", "BUNGLER", "CROQUET", "CRYPT", "DWARVES", "FERVID", "FISHHOOK", "FJORD", "GAZEBO", "GYPSY", "HAIKU", "HAPHAZARD", "HYPHEN", "IVORY", "JAZZY", "JIFFY", "JINX", "JUKEBOX", "KAYAK", "KIOSK", "KLUTZ", "MEMENTO", "MYSTIFY", "NUMBSKULL", "OSTRACIZE", "OXYGEN", "PAJAMA", "PHLEGM", "PIXEL", "POLKA", "QUAD", "QUIP", "RHYTHMIC", "ROGUE", "SPHINX", "SQUAWK", "SWIVEL", "TOADY", "TWELFTH", "UNZIP", "WAXY", "WILDEBEEST", "YACHT", "ZEALOUS", "ZIGZAG", "ZIPPY", "ZOMBIE", "CANDY"};
        String word = wordList[new Random().nextInt(wordList.length)];
        return word;
    }
    
    public static void startGame(String word) {
        //Create the blank spaces for each letter
        for (int i = 0; i < word.length(); i++) {
            System.out.print("_ " );
        }
        //DEBUG PLEASE REMOVE AFTER YOU'RE DONE THANK YOU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println(word);
        
        char[] wordArray = word.toCharArray();
        char[] revealArray = new char[wordArray.length];
        System.out.println(revealArray.length); //should print out a number
        int i;
       
        //Game mechanics
        for (int j = 0; j < 20; j++) {
            //Retriever and Check
            String guessWord = getWord();
            if (guessWord.equals(word)) {
                endGame(word, guessWord);
                break;
            }

            char letter = getLetter();
            int point = checkIfLetterIsCorrect(letter, word);

            for (i = 0; i >= revealArray.length; i++); { //  loop iterates through array word
                switch (wordArray[i]) {
                    case 1:
                        if (wordArray[1] == letter) {
                            revealArray[1] = letter;
                            System.out.println(revealArray[1]);
                        }
                        else {
                            revealArray[1] = '-';
                            System.out.println(revealArray[1]);
                        }
                    case 2:
                        if (wordArray[2] == letter) {
                            revealArray[2] = letter;
                            System.out.print(revealArray[2]);
                        }
                        else {
                            revealArray[2] = '-';
                            System.out.print(revealArray[2]);
                        }
                    case 3:
                        if (wordArray[3] == letter) {
                            revealArray[3] = letter;
                            System.out.print(revealArray[3]);
                        }
                        else {
                            revealArray[3] = '-';
                            System.out.print(revealArray[3]);
                        }
                    case 4:
                        if (wordArray[4] == letter) {
                            revealArray[4] = letter;
                            System.out.print(revealArray[4]);
                        }
                        else {
                            revealArray[4] = '-';
                            System.out.print(revealArray[4]);
                        }
                    case 5:
                        if (wordArray[5] == letter) {
                            revealArray[5] = letter;
                            System.out.print(revealArray[5]);
                        }
                        else {
                            revealArray[5] = '-';
                            System.out.print(revealArray[5]);
                        }
                    case 6:
                        if (wordArray[6] == letter) {
                            revealArray[6] = letter;
                            System.out.print(revealArray[6]);
                        }
                        else {
                            revealArray[6] = '-';
                            System.out.print(revealArray[6]);
                        }
                    case 7:
                        if (wordArray[7] == letter) {
                            revealArray[7] = letter;
                            System.out.print(revealArray[7]);
                        }
                        else {
                            revealArray[7] = '-';
                            System.out.print(revealArray[7]);
                        }
                    case 8:
                        if (wordArray[8] == letter) {
                            revealArray[8] = letter;
                            System.out.print(revealArray[8]);
                        }
                        else {
                            revealArray[8] = '-';
                            System.out.print(revealArray[8]);
                        }
                    case 9:
                        if (wordArray[9] == letter) {
                            revealArray[9] = letter;
                            System.out.print(revealArray[9]);
                        }
                        else {
                            revealArray[9] = '-';
                            System.out.print(revealArray[9]);
                        }
                    default:
                            revealArray[i] = '-';
                            System.out.print(revealArray[i]);
                } //end switch case 
            } //end switch case's loop
           
            //Score & guess.
            if (point == 1) {
                score += point;
            }
               
            guess++;

            //Print current game info
            System.out.println("# of Guesses: " + guess);
            System.out.println("Score: " + score);

            for (int l = -1; (l = word.indexOf(letter, l + 1)) != -1; l++) {
                System.out.println("The instances of this letter are on letter # " + l);
            }

            System.out.println("-------------------------------");

        } //end master for loop
    } //end startGame method
    public static char getLetter() {
        
        System.out.print("Guess a letter: ");
        String input = scanner.nextLine();
        input = input.toUpperCase(); //to turn all letters to uppercase so that it is easy to match letter to letter.
        return input.charAt(0); //returns the first letter of the input like an array.
    }
    public static String getWord() {
    
        Scanner in = new Scanner(System.in);
        System.out.print("Guess the word: ");
        String input = in.nextLine();
        input = input.toUpperCase();
        return input;
    }
    public static int checkIfLetterIsCorrect(char letter, String word) {
    
        for (int l = -1; (l = word.indexOf(letter, l + 1)) != -1; l++) {
            score++;
        }
        return score;
    }
    public static void endGame(String word, String guessWord) {
        
        if (score >= word.length() || guessWord.equals(word)) {
            if (guess <= 10) {
                try {
                    System.out.println("You won? Wow, that was fast! You deserve a trophy!");
                    Thread.sleep(1000);
                    System.out.println("   ._________.");
                    System.out.println(" __[m        ]__");
                    System.out.println("(  (m        )  )");
                    System.out.println(" `-_(m      )_- \u0301");
                    System.out.println("     (m    )    ");
                    System.out.println("    ,-(m  )-、  ");
                    System.out.println("   /Congrats!\\  ");
                    System.out.println("  /___________\\ ");
                }
                catch (InterruptedException ex) {Thread.currentThread().interrupt();}
            }
            else {
                System.out.println("You won! Nice job!");
            }
        }
        else {
            System.out.println("You lost!");
            System.out.println("The word was " + word + ". Good try!");
        }
        System.out.println("The word was " + word); 
        System.out.flush();
    }
} //Ends class hangman
