package io.jenpage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.List;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Arrays;
import java.util.HashSet;

import static java.nio.file.Files.lines;
import static java.nio.file.Files.readAllLines;
import static java.lang.Integer.parseInt;

class Fabric {
    private String[][] claims;
    private HashSet<String> clearIds;

    Fabric(int size) {
        claims = new String[size][size];
        clearIds = new HashSet();

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                claims[i][j] = ".";
    }

    public void makeClaim(String id, int x, int y, int w, int h) {
        clearIds.add(id);
        for (int i = x; i < x + w; i++) {
            for (int j = y; j < y + h; j++) {
                final String existing = claims[i][j];
                if (existing.equals(".")) {
                    claims[i][j] = id;
                } else {
                    claims[i][j] = "X";
                    clearIds.remove(id);
                    clearIds.remove(existing);
                }
            }
        }
    }

    public void makeClaim(String claim) {
        final String[] parts = claim.split(" ");
        final String id = parts[0].replace("#", "");
        final String[] location = parts[2].split(",");
        final String[] size = parts[3].split("x");
        makeClaim(id, parseInt(location[0]), parseInt(location[1].replace(":", "")), parseInt(size[0]), parseInt(size[1]));
    }

    public int numOverlaps() {
        int overlaps = 0;
        for (int i = 0; i < claims.length; i++) {
            for (int j = 0; j < claims.length; j++) {
                if (claims[i][j].equals("X")) {
                    overlaps += 1;
                }
            }
        }
        return overlaps;
    }

    public String nonOverlapping() {
        return clearIds.iterator().next();
    }

    public void printClaims() {
        for (int i = 0; i < claims.length; i++) {
            final StringBuilder builder = new StringBuilder();
            for (int j = 0; j < claims.length; j++) {
                builder.append(claims[i][j]);
            }
            System.out.println(builder.toString());
        }
    }
}

public class Day3 {
    public static int numOverlaps(int size, List<String> claims) {
        Fabric fabric = new Fabric(size);
        for (String claim : claims) {
            fabric.makeClaim(claim);
        }
        return fabric.numOverlaps();
    }

    public static String nonOverlapping(int size, List<String> claims) {
        Fabric fabric = new Fabric(size);
        for (String claim : claims) {
            fabric.makeClaim(claim);
        }
        return fabric.nonOverlapping();
    }

    public static void main( String[] args ) throws IOException {
        final Path path = Path.of(args[0]);
        final List<String> claims = readAllLines(path);
        System.out.println( "Day 3 Part One Result: " + numOverlaps(1000, claims) );

        System.out.println( "Day 3 Part Two Result: " + nonOverlapping(1000, claims) );
    }
}
