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
        System.out.println("                | You have 20 guesses to guess the word|");
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
        //Initialize variables here
        char[] wordArray = word.toCharArray();
        char[] revealArray = new char[wordArray.length];
        int point = 0;
        char letter;
        boolean addLetter = true;

        System.out.print("                        ");
        for (int i = 0; i < word.length(); i++) {
            revealArray[i] = '_';
            System.out.print(revealArray[i] + "   ");
        }
        System.out.println("\n\n");
        
        //Game mechanics
        for (int j = 20; j >= 0; j--) {
            //Retriever and Check
            if (point >= 1) {
                addLetter = true;
                System.out.print("                        ");
                for (int a = 0; a < word.length(); a++) {
                    System.out.print(revealArray[a] + " ");
                }
                System.out.println("\n");
            }
            String guessWord = getWord();
            if (guessWord.equals(word)) {
                break;
            }

            letter = getLetter();
            point = checkIfLetterIsCorrect(letter, word);
            for (int index = 0; index < word.length(); index++){
                if (addLetter == true) {
                    if (wordArray[index] == letter) {
                        revealArray[index] = letter; //Replaces _ with letter
                    }
                }
            }
            guess++;
            //Print current game info
            System.out.println("                        # of Guesses: " + guess);
            if (guess > 20) {
                break;
            }
            for (int l = 0; l < word.length(); l++) {
                if (letter == wordArray[l]) {
                    System.out.println("                        The letter " + letter + " is in the word!");
                }
            }
            System.out.println();

        } //end master for loop

        endGame(word);
    } //end startGame method
    public static char getLetter() {
        
        System.out.print("                        Guess a letter: ");
        String input = scanner.nextLine();
        input = input.toUpperCase(); //to turn all letters to uppercase so that it is easy to match letter to letter.
        return input.charAt(0); //returns the first letter of the input like an array.
    }
    public static String getWord() {
    
        Scanner in = new Scanner(System.in);
        System.out.print("                        Guess the word: ");
        String input = in.nextLine();
        input = input.toUpperCase();
        return input;
    }
    public static int checkIfLetterIsCorrect(char letter, String word) {
    // Goes through each of the letters in the word and checks if it matches with the guess letter.
        for (int l = -1; (l = word.indexOf(letter, l + 1)) != -1; l++) {
            
            score++;
        }
        return score;
    }
    public static void endGame(String word) {
        
        if (guess <= 20) {
            if (guess <= 10) {
                try {
                    System.out.println("            You won! That was fast! You deserve a trophy!");
                    Thread.sleep(1000);
                    System.out.println("                           ._________.");
                    System.out.println("                         __[m        ]__");
                    System.out.println("                        (  (m        )  )");
                    System.out.println("                         `-_(m      )_- \u0301");
                    System.out.println("                             (m    )    ");
                    System.out.println("                            ,-(m  )-、  ");
                    System.out.println("                           /Congrats!\\  ");
                    System.out.println("                          /___________\\ ");
                }
                catch (InterruptedException ex) {Thread.currentThread().interrupt();}
            }
            else {
                System.out.println("You won! Nice job!");
                System.out.println("                           The word was " + word); 
                System.out.flush();
            }
        }
        else {
            System.out.println("                        You lost!");
            System.out.println("                        The word was " + word);
            System.out.flush();
        }
    }
} //Ends class hangman
