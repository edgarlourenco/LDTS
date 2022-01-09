package com.aor.refactoring.example6;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class TreeTest {
    public Tree tree;
    public LocalDateTime date;

    @BeforeEach
    public void setUp() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        date = sdf.parse("31-08-2002 10:20:56").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        tree = new Tree(date, "41.177772696363114", "-8.59843522310257", "FEUP");
    }

    @Test
    public void testTreeCreation() {
        assertEquals(tree.plantedAt, date);
        assertEquals(tree.location.getLocationLatitude(), "41.177772696363114");
        assertEquals(tree.location.getLocationLongitude(), "-8.59843522310257");
        assertEquals(tree.location.getLocationName(), "FEUP");
    }

    @Test
    public void testTreeSetLocation() {
        tree.setLocation("loclat", "loclon", "locname");
        assertEquals(tree.plantedAt, date);
        assertEquals(tree.location.getLocationLatitude(), "loclat");
        assertEquals(tree.location.getLocationLongitude(), "loclon");
        assertEquals(tree.location.getLocationName(), "locname");
    }

    @Test
    public void testToString() {
        String result = tree.toString();
        assertEquals("Tree planted at 2002-08-31T10:20:56 in location 41.177772696363114,-8.59843522310257 (FEUP)", result);
    }

    @Test
    public void testAddAppraisal() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        LocalDateTime appraisalDate = sdf.parse("31-08-2002 10:20:56").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        assertEquals(tree.getAppraisals().size(), 0);
        tree.addAppraisal(appraisalDate);
        assertEquals(tree.getAppraisals().size(), 1);
    }

    @SuppressWarnings("JavaUtilDate")
    @Test
    public void testNextAppraisalOverdue() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -6);
        LocalDateTime appraisalDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();;

        assertFalse(tree.isNextAppraisalOverdue());
        tree.addAppraisal(appraisalDate);
        assertTrue(tree.isNextAppraisalOverdue());
    }

    @SuppressWarnings("JavaUtilDate")
    @Test
    public void testNextAppraisalNotOverdue() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -1);
        LocalDateTime appraisalDate = calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();;

        assertFalse(tree.isNextAppraisalOverdue());
        tree.addAppraisal(appraisalDate);
        assertFalse(tree.isNextAppraisalOverdue());
    }

}
