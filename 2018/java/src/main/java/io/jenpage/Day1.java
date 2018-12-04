package io.jenpage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class Day1 {
    public static int sumFrequencyDeltas( IntStream deltas ) {
        return deltas.sum();
    }

    public static void main( String[] args ) throws IOException {
        final Path path = Path.of(args[0]);
        final Stream<String> rawDeltas = lines(path);
        final IntStream deltas = rawDeltas.mapToInt((String delta) -> Integer.parseInt(delta));
        System.out.println( "Day 1 Part One Result: " + sumFrequencyDeltas(deltas) );
    }
}
