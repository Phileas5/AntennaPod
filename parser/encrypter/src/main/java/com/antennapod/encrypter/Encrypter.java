package com.antennapod.encrypter;

public class Encrypter {
    static char[] alphabet1 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static String crypt(int n, String sIn)  {
        char[] charSIn = sIn.toCharArray();
        char[] charSOut = new char[charSIn.length];
        int pos1, pos2;
        for(int i = 0; i < charSIn.length; i++)   {
            pos1 = posChar(charSIn[i], alphabet1);
            pos2 = newPos(pos1, n);
            if(pos2 == -1) charSOut[i] = ' ';
            else charSOut[i] = alphabet1[pos2];
        }
        return new String(charSOut);
    }

    public static String decrypt(int n, String sIn)  {
        char[] charSIn = sIn.toCharArray();
        char[] charSOut = new char[charSIn.length];
        int pos1, pos2;
        for(int i = 0; i < charSIn.length; i++) {
            pos1 = posChar(charSIn[i], alphabet1);
            pos2 = newPos(pos1, -n);
            if(pos2 == -1) charSOut[i] = ' ';
            else charSOut[i] = alphabet1[pos2];
        }
        return new String(charSOut);
    }

    private static int posChar(char c, char[] tab)  {
        for(int i = 0; i < tab.length; i++)   {
            if(tab[i] == c) return i;
        }   return -1;
    }

    private static int newPos(int pos,int n)  {
        int pos2 = pos;
        if(pos <= -1) {
            pos2 = -1;
        } else {
            int i = 0;
            while(i < abs(n)) {
                if(n < 0) {
                    if(pos2 - 1 == -1) pos2 = 25;
                    else pos2--;
                } else {
                    if(pos2 + 1 >= 25) pos2 = 0;
                    else pos2++;
                }
                i++;
            }
        }
        return pos2;
    }

    public static int abs(int a)  {
        if(a >= 0) return a;
        else return -a;
    }
}
