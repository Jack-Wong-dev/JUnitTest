package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test		
    public void testCountNumbers2() {
    	mycustomstring.setString("There aren't any numbers in this string");	
    	assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers3() {
    	mycustomstring.setString("1234567890");	
    	assertEquals(1, mycustomstring.countNumbers()); //this is just one number
    }

    @Test (expected = NullPointerException.class)
    public void testCountNumbers4() {			// null exception
    	mycustomstring.setString(null);	
    	mycustomstring.countNumbers();
    }

    @Test
    public void testCountNumbers5() {
    	 
    	mycustomstring.setString("1 1 1 1 1 1 1 1 1 1");	
    	assertEquals(10, mycustomstring.countNumbers()); //10 of the same number
    }

    @Test
    public void testCountNumbers6() {
    	mycustomstring.setString("0");	
    	assertEquals(1, mycustomstring.countNumbers()); //one number (zero)
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("hr6r hns6 0t tb'", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test 
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
    	mycustomstring.setString("12 ");		//Result should be an empty string
    	assertEquals(" ", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
    	mycustomstring.setString("1234567890");	//Output should be every 2nd character starting from the end	
        assertEquals("97531", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
    	mycustomstring.setString("1234567890");	//Output should be every 2nd character starting from the beginning	
        assertEquals("24680", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false));
    }

    @Test (expected= NullPointerException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
    	mycustomstring.setString(null);	//null, expected 
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(2, false);
    }

    @Test 
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
    	mycustomstring.setString("1234567890");	//Output should result in every character	
        assertEquals("1234567890", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false));
    }

    @Test  (expected= IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
    	mycustomstring.setString("Hi");	// illegal argument, not enough characters	
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
    	mycustomstring.setString("1234567890");	//Every 10th character.  There should only be one 10th char	
        assertEquals("0", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(10, false));
    }

    @Test (expected= IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
    	mycustomstring.setString("");	//empty string 	
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, false);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
    	mycustomstring.setString("1 2 3 4 5 6 7 8 9 0 ");	//Output should result in every character backwards	
        assertEquals(" 0 9 8 7 6 5 4 3 2 1", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(1, true));
    }

    @Test (expected= IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
    	mycustomstring.setString("n is larger than string length");	// illegal argument, negative value passed	
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(50, false);
    }

    @Test 
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
    	mycustomstring.setString("           i           c");	// every 12th	
    	assertEquals("ic", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(12, false));
    }

    @Test (expected= IllegalArgumentException.class)
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
    	mycustomstring.setString("HelloWorl");	//  illegal argument, only 9 characters	
    	mycustomstring.getEveryNthCharacterFromBeginningOrEnd(10, true);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring2() {
    	 mycustomstring.setString("Fr0m B3gg1nn1ng t0 3nd"); //Converted the entire string
         mycustomstring.convertDigitsToNamesInSubstring(1, 22);
         assertEquals("FrZerom BThreeggOnennOneng tZero Threend", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring3() {
    	mycustomstring.setString("0123456789"); //Converted every digit except for the last one (9)
        mycustomstring.convertDigitsToNamesInSubstring(1, 9);
        assertEquals("ZeroOneTwoThreeFourFiveSixSevenEight9", mycustomstring.getString());
    }

    @Test 
    public void testConvertDigitsToNamesInSubstring4() {
    	mycustomstring.setString("0123456789"); //end position index is greater than string length
    	try {
    	 mycustomstring.convertDigitsToNamesInSubstring(1, 20);     
    	 fail();
    	}
    	catch (IndexOutOfBoundsException e)
    	{
    		
    	}
    }

    @Test (expected = NullPointerException.class)
    public void testConvertDigitsToNamesInSubstring5() {
    	mycustomstring.setString(null); //null
        mycustomstring.convertDigitsToNamesInSubstring(1, 4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testConvertDigitsToNamesInSubstring6() {
    	mycustomstring.setString("0123456789"); //Illegal Arguments 
        mycustomstring.convertDigitsToNamesInSubstring(2, 1);
        
    }

    @Test 
    public void testConvertDigitsToNamesInSubstring7() {
    	mycustomstring.setString("0123456789"); //start position index is less than 1
   	try { 
   		mycustomstring.convertDigitsToNamesInSubstring(0, 9);
   		fail();
   	}
   	catch (IndexOutOfBoundsException e)
	{
		
	}
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {
    	mycustomstring.setString("0123456789"); // Converted every digit
    	mycustomstring.convertDigitsToNamesInSubstring(1, 10);  
    	assertEquals("ZeroOneTwoThreeFourFiveSixSevenEightNine", mycustomstring.getString());
    }

}
