package io.jenpage;

import java.util.stream.IntStream;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Day2Test
{
    @Test
    public void part1Example() {
        final List<String> ids = List.of("abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab");
        assertEquals( 12, Day2.checksum(ids.stream()) );
    }

    @Test
    public void part2Example() {
        final List<String> ids = List.of("abcde", "fghij", "klmno", "pqrst", "fguij", "axcye", "wvxyz");
        assertEquals( "fgij", Day2.findCommon(ids).get() );
    }
}
