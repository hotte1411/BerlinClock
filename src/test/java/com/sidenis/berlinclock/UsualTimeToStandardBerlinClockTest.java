package com.sidenis.berlinclock;

import com.sidenis.berlinclock.controller.TimeConverter;
import com.sidenis.berlinclock.controller.UsualTimeToStandardBerlinClock;
import org.junit.Assert;
import org.junit.Test;


/**
 * @author Anton Laletin
 * @since 2015-07-30
 */
public class UsualTimeToStandardBerlinClockTest {

    private final TimeConverter timeConverter = new UsualTimeToStandardBerlinClock();

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
    public void testAnotherMidnightAnotherSeparator() {
        String actual = timeConverter.convertTime("24-00-00");
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

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException() {
        timeConverter.convertTime("20:70:10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException_1() {
        timeConverter.convertTime("25:00:10");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentException_2() {
        timeConverter.convertTime("20:00:90");
    }
}
