package com.codeprovisions;

/**
 *  CountThrees
 *
 *  Read integers from binary file and count the occurrences of the number 3
 *
 *  input: threesData.bin (32-bit little-endian binary data file
 *          containing random integers)
 *
 *
 *  created by Felicia Pacifica
 *  felicia@picorealm.net
 *
 *  credit: Steven Goldade via stackoverflow.com post
 *            https://stackoverflow.com/a/5599669
 *
 */

import java.io.*;
// import java.nio.file.Paths;


public class CountThrees {

    public static void main(String[] args) {

        // Use this to find out where to put the data directory
        // System.out.println("Data directory should be in: " +
        //                Paths.get(".").toAbsolutePath().normalize().toString());


        // Use Java 7+ try-with-resources
        try (DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(
                            new FileInputStream(new File("data/threesData.bin"))))) {
            int threesCount = 0;
            while (dataInputStream.available() > 0) {
                if (dataInputStream.readInt() == 3) {
                    threesCount++;
                }
            }
            System.out.println("Number of threes: " + threesCount);
        } catch (IOException readException) {
            readException.printStackTrace();
        }
    }
}
