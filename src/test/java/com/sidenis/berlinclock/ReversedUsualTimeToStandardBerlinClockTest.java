package com.sidenis.berlinclock;

import com.sidenis.berlinclock.controller.ReversedUsualTimeToStandardBerlinClock;
import com.sidenis.berlinclock.controller.TimeConverter;
import org.junit.Assert;
import org.junit.Test;

public class ReversedUsualTimeToStandardBerlinClockTest {

    private final TimeConverter timeConverter = new ReversedUsualTimeToStandardBerlinClock();

    @Test
    public void test13_17_01() {
        String actual = timeConverter.convertTime("13:17:01");
        String expected = "YYOO\n" +
                "YYGOOOOOOOO\n" +
                "GGGO\n" +
                "GGOO\n" +
                "O";

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() {
        timeConverter.convertTime("13:97:01");
    }

}
