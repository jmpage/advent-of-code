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

    @Test
    public void p2example1() {
        final List<String> rawDeltas = List.of("+1", "-1");
        final int[] deltas = rawDeltas.stream().mapToInt(Integer::parseInt).toArray();
        final int result = Day1.findRepeatFrequency(deltas).get();
        assertEquals( 0, result );
    }

    @Test
    public void p2example2() {
        final List<String> rawDeltas = List.of("+3", "+3", "+4", "-2", "-4");
        final int[] deltas = rawDeltas.stream().mapToInt(Integer::parseInt).toArray();
        final int result = Day1.findRepeatFrequency(deltas).get();
        assertEquals( 10, result );
    }


    @Test
    public void p2example3() {
        final List<String> rawDeltas = List.of("-6", "+3", "+8", "+5", "-6");
        final int[] deltas = rawDeltas.stream().mapToInt(Integer::parseInt).toArray();
        final int result = Day1.findRepeatFrequency(deltas).get();
        assertEquals( 5, result );
    }

    @Test
    public void p2example4() {
        final List<String> rawDeltas = List.of("+7", "+7", "-2", "-7", "-4");
        final int[] deltas = rawDeltas.stream().mapToInt(Integer::parseInt).toArray();
        final int result = Day1.findRepeatFrequency(deltas).get();
        assertEquals( 14, result );
    }
}
