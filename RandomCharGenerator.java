package com.suprithgurudu;

import java.util.Random;

public class RandomCharGenerator {
    int randInt = new Random().nextInt(26) + 97;
    public char getRandomChar(){
        return (char)randInt;
    }
}
