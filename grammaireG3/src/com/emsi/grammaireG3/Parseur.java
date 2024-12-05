package com.emsi.grammaireG3;


public class Parseur {
    private TokenManager tm;
    private char tc;

    public Parseur(TokenManager tm) {
        this.tm = tm;
        avancer();
    }

    private void avancer() {
        tc = tm.suivant();
    }

    private void consommer(char attendu) {
        if (tc == attendu) {
            avancer();
        } else {
            throw new RuntimeException(
                String.format("Erreur: Attendu '%c', mais trouvé '%c' à la position %d", attendu, tc, tm.getIndex())
            );
        }
    }

    private void S() {
        if (tc == 'b') {
            consommer('b');
            S();
            consommer('b');
        } else if (tc == 'c') {
            consommer('c');
            A();
            consommer('c');
        } else {
            throw new RuntimeException(
                String.format("Erreur: '%c' n'est pas valide dans S à la position %d", tc, tm.getIndex())
            );
        }
    }

    private void A() {
        if (tc == 'b') {
            consommer('b');
            A();
            A();
        } else if (tc == 'c') {
            consommer('c');
            A();
            consommer('S');
            consommer('b');
        } else if (tc == 'd') {
            consommer('d');
            consommer('c');
            consommer('b');
        } else {
            throw new RuntimeException(
                String.format("Erreur: '%c' n'est pas valide dans A à la position %d", tc, tm.getIndex())
            );
        }
    }

    public void parse() {
        S();
        if (tc != '#') {
            throw new RuntimeException(
                String.format("Erreur: Fin de chaîne attendue, mais trouvé '%c' à la position %d", tc, tm.getIndex())
            );
        }
    }
}
