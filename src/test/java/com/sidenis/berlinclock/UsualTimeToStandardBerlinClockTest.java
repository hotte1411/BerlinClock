package com.sidenis.berlinclock;

import com.sidenis.berlinclock.TimeConverter;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Anton Laletin
 * @since 2015-07-30
 */
public class UsualTimeToStandardBerlinClockTest {

    private TimeConverter timeConverter = new BerlinTimeConverter();

    @Test
    public void testMidnight() {
        String actual = timeConverter.convertTime("00:00:00");
        String expected =
                "Y\n" +
                        "OOOO\n" +
                        "OOOO\n" +
                        "OOOOOOOOOOO\n" +
                        "OOOO";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAnotherMidnight() {
        String actual = timeConverter.convertTime("24:00:00");
        String expected =
                "Y\n" +
                        "RRRR\n" +
                        "RRRR\n" +
                        "OOOOOOOOOOO\n" +
                        "OOOO";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_13_17_01() {
        String actual = timeConverter.convertTime("13:17:01");
        String expected =
                "O\n" +
                        "RROO\n" +
                        "RRRO\n" +
                        "YYROOOOOOOO\n" +
                        "YYOO";

        Assert.assertEquals(expected, actual);
    }

    //Please feel free to add your own test.

    @Test
    public void testIncorrectHours_1() {
        String actual = timeConverter.convertTime("25:10:10");
        Assert.assertNull(actual);
    }

    @Test
    public void testIncorrectMinutes() {
        String actual = timeConverter.convertTime("20:70:10");
        Assert.assertNull(actual);
    }

    @Test
    public void testIncorrectSeconds() {
        String actual = timeConverter.convertTime("20:10:90");
        Assert.assertNull(actual);
    }

    @Test
    public void testIncorrectHours_2() {
        String actual = timeConverter.convertTime("120:10:20");
        Assert.assertNull(actual);
    }

}
