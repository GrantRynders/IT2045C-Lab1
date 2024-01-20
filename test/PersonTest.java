import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    Person p1, p2, p3, p4, p5, p6;

    @BeforeEach
    void setUp()
    {
        p1 = new Person("00000A", "Bob", "Tester1", "Mr.", 1955);
        p2 = new Person("00000B", "Sally", "Tester2", "Mrs.", 1975);
        Person.setIDSeed(0);
        p3 = new Person("Bob", "Tester3", "Mr.", 1960);
        p4 = new Person( "Sally", "Tester4", "Ms.", 1965);
        p5 = new Person( "Fred", "Tester5", "Mr.", 1970);
        p6 = new Person( "Cindy", "Tester6", "Mrs.", 1975);


    }
    @Test
    /** tests the seed generator after 4 calls, should be 4*/
    void getIDSeed()
    {
        assertEquals(4, Person.getIDSeed());
    }
    @Test
    void getID()
    {
        assertEquals("00000A", p1.getID());
    }
     @Test
     void getFirstName()
     {
        assertEquals("Bob", p1.getFirstName());
     }

    @Test
    void getLastName()
    {
        assertEquals("Tester1", p1.getLastName());
    }

    @Test
    void getYearOfBirth()
    {
        assertEquals(1955, p1.getYearOfBirth());
    }

    /** now we go though all the setters and change P1 to P2 oo we can test the equals with P1 and P2 */
    @Test
    void setID()
    {
        p1.setID("00000B");
        assertEquals("00000B", p1.getID());
    }

    @Test
    void setFirstName()
    {
        p1.setFirstName("Sally");
        assertEquals("Sally", p1.getFirstName());
    }

    @Test
    void setLastName()
    {
        p1.setLastName("Tester2");
        assertEquals("Tester2", p1.getLastName());
    }

    @Test
    void setYearOfBirth()
    {
        p1.setYearOfBirth(1975);
        assertEquals(1975, p1.getYearOfBirth());
    }
    @Test
    void setTitle()
    {
        p1.setTitle("Mr.");
        assertEquals("Mr.", p1.getTitle());
    }

    @Test
    void fullName() // returns firstName, space, lastName
    {
        p3.setFirstName("Bob");
        p3.setLastName("Tester3");
        assertEquals("Bob Tester3", p3.fullName(p3.getFirstName(), p3.getLastName()));
    }

    @Test
    void formalName() // returns title space fullname
    {
        p3.setFirstName("Bob");
        p3.setLastName("Tester3");
        p3.setTitle("Mr.");
        assertEquals("Mr. Bob Tester3", p3.formalName(p3.getTitle(), p3.getFirstName(), p3.getLastName()));
    }

    @Test
    void getCurrentAge() // Why are we returning a String for the getAge method??? To do anything with it we need a number.
    {
        p3.setYearOfBirth(1960);
        assertEquals(String.valueOf(Year.now().getValue() - 1960), p3.getCurrentAge());//so many loops to jump through
    }

    @Test
    void getAge()
    {
        p3.setYearOfBirth(1960);
        int testYear = 1999;
        assertEquals(String.valueOf(testYear - 1960), p3.getAge(testYear));
    }

}