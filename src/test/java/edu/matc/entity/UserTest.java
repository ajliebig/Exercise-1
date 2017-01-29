package edu.matc.entity;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

/**
 * Created on 1/24/17.
 *
 * @author pwaite
 */
public class UserTest {

    User user;

    @Before
    public void setUp() {
        user = new User("Test", "One", "5", createLocalDateFromString("01-08-2000"));

    }

    private LocalDate createLocalDateFromString(String input) {
        DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(input, DATE_FORMAT);
    }

    @Test
    public void calculateAge() throws Exception {
        assertEquals("Age was not correct", 16, user.age());
        assertNotNull(user);

    }

}