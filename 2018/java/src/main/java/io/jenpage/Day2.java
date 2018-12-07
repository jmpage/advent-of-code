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

import static java.nio.file.Files.lines;
import static java.nio.file.Files.readAllLines;

public class Day2 {
    public static int[] determineRepeats( String id ) {
        final HashMap<Integer, Integer> counts = new HashMap();
        final int[] results = new int[2];
        int currentChar;
        int currentCount;

        for (int i = 0; i < id.length(); i++ ) {
            currentChar = id.charAt(i);
            currentCount = Optional.ofNullable(counts.get(currentChar)).orElse(0) + 1;
            counts.put(currentChar, currentCount);
        }

        results[0] = counts.containsValue(2) ? 1 : 0;
        results[1] = counts.containsValue(3) ? 1 : 0;

        return results;
    }

    public static int checksum( Stream<String> ids ) {
        final int[] zero = new int[2];
        zero[0] = 0;
        zero[1] = 0;

        final int[] results = ids.map(Day2::determineRepeats).reduce(zero, (int[] a, int[] b) -> {
                final int[] result = new int[2];
                result[0] = a[0] + b[0];
                result[1] = a[1] + b[1];
                return result;
            });

        return results[0] * results[1];
    }

    public static String commonChars( String id1, String id2 ) {
        final StringBuilder builder = new StringBuilder(id1.length());
        for (int i = 0; i < id1.length(); i++) {
            if (id1.charAt(i) == id2.charAt(i)) {
                builder.append(id1.charAt(i));
            }
        }
        return builder.toString();
    }

    public static Optional<String> findCommon( List<String> ids ) {
        for (int i = 0; i < ids.size(); i++) {
            for (int j = 0; j < ids.size(); j++) {
                final String commonChars = Day2.commonChars(ids.get(i), ids.get(j));
                if (commonChars.length() == ids.get(i).length() - 1) {
                    return Optional.of(commonChars);
                }
            }
        }
        return Optional.empty();
    }

    public static void main( String[] args ) throws IOException {
        final Path path = Path.of(args[0]);
        final Stream<String> ids = lines(path);
        System.out.println( "Day 2 Part One Result: " + checksum(ids) );

        final List<String> moreIds = readAllLines(path);
        System.out.println( "Day 2 Part Two Result: " + findCommon(moreIds).get() );
    }
}
