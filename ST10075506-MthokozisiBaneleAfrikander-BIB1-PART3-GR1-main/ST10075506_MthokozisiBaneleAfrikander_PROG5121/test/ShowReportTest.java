/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author major
 */
public class ShowReportTest {
    ShowReport sr = new ShowReport();
    
    public ShowReportTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of delete method, of class ShowReport.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String toDelete = "Create reports";
        ShowReport instance = new ShowReport();
        instance.delete(toDelete);
        // TODO review the generated test code and remove the default call to fail.
        fail("Create reports has not been deleted");
    }

    /**
     * Test of statusOfDone method, of class ShowReport.
     */
    @Test
    public void testStatusOfDone() {
        System.out.println("statusOfDone");
        ShowReport instance = new ShowReport();
        instance.statusOfDone();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of longestDuration method, of class ShowReport.
     */
    @Test
    public void testLongestDuration() {
        System.out.println("longestDuration");
        ShowReport instance = new ShowReport();
        int expResult = sr.longestDuration();
        int result = instance.longestDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("This is not the longest");
    }

    /**
     * Test of searchTaskName method, of class ShowReport.
     */
    @Test
    public void testSearchTaskName() {
        System.out.println("Create Login");
        ShowReport instance = new ShowReport();
        int expResult = 0;
        int result = instance.searchTaskName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("Not Mike Smith, Create Login");
    }

    /**
     * Test of searchDeveloper method, of class ShowReport.
     */
    @Test
    public void testSearchDeveloper() {
        System.out.println("Samantha Paulson");
        ShowReport instance = new ShowReport();
        int expResult = 0;
        int result = instance.searchDeveloper();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("");
    }

    /**
     * Test of fullReport method, of class ShowReport.
     */
    @Test
    public void testFullReport() {
        System.out.println("fullReport");
        ShowReport instance = new ShowReport();
        instance.fullReport();
        // TODO review the generated test code and remove the default call to fail.
        fail("");
    }
    
}
