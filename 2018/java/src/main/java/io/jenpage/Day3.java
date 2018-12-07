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

import static java.nio.file.Files.lines;
import static java.nio.file.Files.readAllLines;
import static java.lang.Integer.parseInt;

class Fabric {
    private int[][] claims;

    Fabric(int size) {
        claims = new int[size][size];
    }

    public void makeClaim(int x, int y, int w, int h) {
        for (int i = x; i < x + w; i++) {
            for (int j = y; j < y + h; j++) {
                claims[i][j] += 1;
            }
        }
    }

    public void makeClaim(String claim) {
        final String[] parts = claim.split(" ");
        final String[] location = parts[2].split(",");
        final String[] size = parts[3].split("x");
        makeClaim(parseInt(location[0]), parseInt(location[1].replace(":", "")), parseInt(size[0]), parseInt(size[1]));
    }

    public int numOverlaps() {
        int overlaps = 0;
        for (int i = 0; i < claims.length; i++) {
            for (int j = 0; j < claims.length; j++) {
                if (claims[i][j] > 1) {
                    overlaps += 1;
                }
            }
        }
        return overlaps;
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

    public static void main( String[] args ) throws IOException {
        final Path path = Path.of(args[0]);
        final List<String> claims = readAllLines(path);
        System.out.println( "Day 3 Part One Result: " + numOverlaps(1000, claims) );
    }
}
