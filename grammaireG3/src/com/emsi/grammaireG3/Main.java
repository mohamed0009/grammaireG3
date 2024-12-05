package com.emsi.grammaireG3;


public class Main {
    public static void main(String[] args) {
        String[] testStrings = {
            "cdcbc", "bcdcbcb", "cbdcbdcbc", "ccdcbcdcbcdcbcb", "cdcbbb", "cdcb", ""
        };

        for (String ch : testStrings) {
            TokenManager tm = new TokenManager(ch);
            Parseur parseur = new Parseur(tm);

            try {
                parseur.parse();
                System.out.println(ch + ": est Valide");
            } catch (RuntimeException exp) {
                System.out.println(ch + ": n'est pas Valide");
                System.out.println("Erreur : " + exp.getMessage());
            }
        }
    }
}
