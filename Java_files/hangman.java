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
        int lengthOfWord = word.length();

        printInfo(word, lengthOfWord); //Includes gameRules, gameLegal & gameInfo all in 1.
        startGame(word, lengthOfWord);
        endGame(word, lengthOfWord); //Print statements.
        
        scanner.close(); 
    }
    
    public static void printInfo(String word, int lengthOfWord) {
        
        System.out.println("You are now playing: Hangman.");
        System.out.println("You have 20 guesses to guess the word.");
        System.out.println("The word is " + lengthOfWord + " characters long.");
        System.out.println("Instances begin on 0 = first letter of word & 1 = second letter of word");
        System.out.println("Guess the word before you run out of guesses.");
        System.out.println("TIP: Don't guess the same letter twice else!\n\n");
    }

    public static String getRandomWord() {
        
        String[] wordList = {"AWKWARD", "BAGPIPES", "BANJO", "BUNGLER", "CROQUET", "CRYPT", "DWARVES", "FERVID", "FISHHOOK", "FJORD", "GAZEBO", "GYPSY", "HAIKU", "HAPHAZARD", "HYPHEN", "IVORY", "JAZZY", "JIFFY", "JINX", "JUKEBOX", "KAYAK", "KIOSK", "KLUTZ", "MEMENTO", "MYSTIFY", "NUMBSKULL", "OSTRACIZE", "OXYGEN", "PAJAMA", "PHLEGM", "PIXEL", "POLKA", "QUAD", "QUIP", "RHYTHMIC", "ROGUE", "SPHINX", "SQUAWK", "SWIVEL", "TOADY", "TWELFTH", "UNZIP", "WAXY", "WILDEBEEST", "YACHT", "ZEALOUS", "ZIGZAG", "ZIPPY", "ZOMBIE", "CANDY"};
        String word = wordList[new Random().nextInt(wordList.length)];
        return word;
    }
    
    public static void startGame(String word, int lengthOfWord ) {
        //Create the blank spaces for each letter
        for (int i = 0; i < lengthOfWord; i++) {
            System.out.print("_ " );
        }
        //DEBUG PLEASE REMOVE AFTER YOU'RE DONE THANK YOU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        System.out.println(word);
        
        //Game mechanics
        for (int j = 0; j < 20; j++) {
            //Retriever and Check
            String guessWord = getWord();
            boolean winOrLoss = checkIfWordComplete(guessWord, word, lengthOfWord); 
            if (winOrLoss = true) {
                break;
            }

            char letter = getLetter();
            int point = checkIfLetterIsCorrect(letter, word, lengthOfWord);
            
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
        }
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
        String input = in.next();
        return input;
    }

    public static int checkIfLetterIsCorrect(char letter, String word, int lengthOfWord) {
        /*for (int i = 0; i < lengthOfWord; i++) {
            if (word.charAt(i) == letter) {
                score++;
            }
        }
        */
        for (int l = -1; (l = word.indexOf(letter, l + 1)) != -1; l++) {
            score++;
        }
        return score;
    }
    
    public static boolean checkIfWordComplete(String guessWord, String word, int lengthOfWord) {
        if (guessWord.equals(word)) {
            return false;
        }
        else {
            return true;
        }
    }

    public static void endGame(String word, int lengthOfWord) {

        if (guess <= 10) {
            try {
                System.out.println("You won? Wow, that was fast! You deserve a trophy!");
                Thread.sleep(1000);
                System.out.println("   ._________.");
                System.out.println(" __[m        ]__");
                System.out.println("(  (m        )  )");
                System.out.println(" `-_(m      )_-\u0301");
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
       
        System.out.println("The word was " + word + "\nGood game!");
        System.out.flush();
    
    }
} //Ends class hangman