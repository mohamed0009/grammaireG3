package com.emsi.grammaireG3;

import java.util.NoSuchElementException;

public class TokenManager {
    private String entree;
    private int iCourant;

    public TokenManager(String ch) {
        if (ch == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }
        this.entree = ch + "#"; 
        this.iCourant = 0;
    }

    public char suivant() {
        if (iCourant < entree.length()) {
            return entree.charAt(iCourant++);
        }
        throw new NoSuchElementException("No more characters in the input.");
    }

    public char peek() {
        if (iCourant < entree.length()) {
            return entree.charAt(iCourant);
        }
        return '#';
    }

    public int getIndex() {
        return iCourant;
    }
}
