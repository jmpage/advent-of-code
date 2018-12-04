package io.jenpage;

import java.util.stream.IntStream;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day1Test
{
    @Test
    public void example1() {
        final List<String> rawDeltas = List.of("+1", "+1", "+1");
        final IntStream deltas = rawDeltas.stream().mapToInt((String delta) -> Integer.parseInt(delta));
        assertEquals( 3, Day1.sumFrequencyDeltas(deltas) );
    }

    @Test
    public void example2() {
        final List<String> rawDeltas = List.of("+1", "+1", "-2");
        final IntStream deltas = rawDeltas.stream().mapToInt((String delta) -> Integer.parseInt(delta));
        assertEquals( 0, Day1.sumFrequencyDeltas(deltas) );
    }

    @Test
    public void example3() {
        final List<String> rawDeltas = List.of("-1", "-2", "-3");
        final IntStream deltas = rawDeltas.stream().mapToInt((String delta) -> Integer.parseInt(delta));
        assertEquals( -6, Day1.sumFrequencyDeltas(deltas) );
    }
}
