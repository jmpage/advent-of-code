package io.jenpage;

import java.util.stream.IntStream;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day3Test
{
    @Test
    public void part1Example() {
        final List<String> claims = List.of("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2");
        assertEquals( 4, Day3.numOverlaps(8, claims) );
    }

    @Test
    public void part2Example() {
        final List<String> claims = List.of("#1 @ 1,3: 4x4", "#2 @ 3,1: 4x4", "#3 @ 5,5: 2x2");
        assertEquals( "3", Day3.nonOverlapping(8, claims) );
    }
}
