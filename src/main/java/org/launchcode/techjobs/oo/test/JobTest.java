package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId(), .001);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job1.getName() instanceof String);
        assertEquals("Product tester", job1.getName());
        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals("ACME", job1.getEmployer().getValue());
        assertTrue(job1.getLocation() instanceof Location);
        assertEquals("Desert", job1.getLocation().getValue());
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
        assertFalse(job1.getId() == job2.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string = job1.toString();
        assertEquals(string.charAt(0), '\n'); //first character
        assertEquals(string.charAt(string.length() - 1), '\n'); //last character
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string = job1.toString();
        Integer id = job1.getId(); //need to learn how to clear objects after each test
        String testString = "\n" +
                "ID: " + id + "\n" +
                "Name: " + "Product tester" + "\n" +
                "Employer: " + "ACME" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" +
                "\n";
        assertEquals(testString, string);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job1 = new Job("Product tester", new Employer(), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String string = job1.toString();
        Integer id = job1.getId(); //need to learn how to clear objects after each test
        String testString = "\n" +
                "ID: " + id + "\n" +
                "Name: " + "Product tester" + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + "Desert" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" +
                "\n";
        assertEquals(testString, string);
    }

    @Test
    public void testToStringHandlesAllEmptyFields() {
        Job job1 = new Job("", new Employer(), new Location(), new PositionType(), new CoreCompetency());
        String string = job1.toString();
        String testString = "OOPS! This job does not seem to exist.";
        assertEquals(testString, string);
    }
}
