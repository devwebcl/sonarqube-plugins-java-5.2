package org.ejemplo;
//Unexpected at [7]
public class Test {

    int hola(int mundo) {

        int x;
        int y; // Noncompliant

        y = 1;
        y = y + mundo;

        return y;
    }

}
