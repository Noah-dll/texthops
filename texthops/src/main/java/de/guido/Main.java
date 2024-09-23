package de.guido;

import com.sun.source.doctree.SeeTree;

import java.lang.reflect.Array;
import java.util.*;

public class texthops {
    public static void main(String[] args){
        String text = "das ist ein test text! ___ 123 d-ad-awD _AAW D1-dADW_ -A$%*W)122234+A_W#AdjioW_#)(";
        String win = calcPosition(text);
        System.out.println(win);
    }

    public static String calcPosition(String text) {
        int jumpsMina = hop(0, text);
        int jumpsMona = hop(1, text);
        if (jumpsMona > jumpsMina) {
            return "Mina won with: " + jumpsMina + " jumps!";
        }
        if (jumpsMona < jumpsMina) {
            return "Mona won with: " + jumpsMona + " jumps!";
        }

        return "It is a tie..";
    }

    private static int hop(int startPos, String text) {
        int jumps = 0;
        int currentPosition = startPos;
        text = text.toLowerCase();

        ArrayList<Character> ignoredChars = new ArrayList<>(Arrays.asList(
                '!', '@', '#', '$', '%', '^', '&', '*',
                '(', ')', '-', '_',
                '=', '+', '\n', '\"', '\''));

        while (currentPosition < text.length()) {
            char letter = text.charAt(startPos);

            if (ignoredChars.contains(letter)) {
                continue;
            }

            currentPosition += getLetterIndex(letter);
            jumps++;
        }
        return jumps;
    }

    private static int getLetterIndex(char letter) {
        int alphabetIndex;
        switch (letter) {
            case 'ä': {
                alphabetIndex = 27;
                break;
            }

            case 'ö': {
                alphabetIndex = 28;
                break;
            }
            case 'ü': {
                alphabetIndex = 29;
                break;
            }

            case 'ß': {
                alphabetIndex = 30;
                break;
            }

            default: {
                alphabetIndex = (int) letter - 96;
            }
        }

        return alphabetIndex;
    }
}