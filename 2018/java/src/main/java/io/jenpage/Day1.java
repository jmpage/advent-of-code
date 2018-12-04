package io.jenpage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.Optional;
import java.util.OptionalInt;

import static java.nio.file.Files.lines;

public class Day1 {
    public static int sumFrequencyDeltas( IntStream deltas ) {
        return deltas.sum();
    }

    public static Optional<Integer> findRepeatFrequency( int[] deltas ) {
        final HashMap<Integer, Integer> occurrances = new HashMap();
        int currentFrequency = 0;
        int currentOccurrances;

        for (int i = 0; i < 1000; i++) {
            for (int delta : deltas) {
                currentOccurrances = Optional.ofNullable(occurrances.get(currentFrequency)).orElse(0) + 1;
                if (currentOccurrances >= 2) {
                    return Optional.of(currentFrequency);
                }
                occurrances.put(currentFrequency, currentOccurrances);
                currentFrequency += delta;
            }
        }

        return Optional.empty();
    }

    public static void main( String[] args ) throws IOException {
        final Path path = Path.of(args[0]);
        final Stream<String> rawDeltas = lines(path);
        final IntStream deltas = rawDeltas.mapToInt((String delta) -> Integer.parseInt(delta));
        System.out.println( "Day 1 Part One Result: " + sumFrequencyDeltas(deltas) );

        final int[] allDeltas = lines(path).mapToInt(Integer::parseInt).toArray();
        System.out.println( "Day 1 Part Two Result: " + findRepeatFrequency(allDeltas).get() );
    }
}
