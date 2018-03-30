package edu.qc.seclass;


public class MyCustomString implements MyCustomStringInterface {
	private String test_input = "";
	
	@Override
	public String getString() {
		return test_input;
	}

	@Override
	public void setString(String string) {
		
		test_input = string;

	}

	@Override
	public int countNumbers() {
		boolean element_previous_is_digit = false;
		int count = 0;

	    for (int i = 0; i < test_input.length(); i++) {
	        if (Character.isDigit(test_input.charAt(i))) {
	            if (!element_previous_is_digit) {
	                count++;
	                element_previous_is_digit = true;
	            }
	        } else {
	            element_previous_is_digit = false;
	        }
	    }
	    return count;
	}

	@Override
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
		// TODO Auto-generated method stub
		int x = 1;
		int i = ( x * n ) - 1;
		String input_string ="";
		String output_string = "";
		char character;
		
		if (startFromEnd == true) {
		for(int index= test_input.length()-1;index>=0;index--)
			input_string = input_string + test_input.charAt(index);   
		}
		
		if (startFromEnd == false)
		{
			input_string = test_input;
		}
		
		if (n > input_string.length()) {
			throw new IllegalArgumentException();
		}
		
		
		System.out.println("new string: "+ input_string);
		
		while (i < input_string.length()) {
			
			character = input_string.charAt(i);
			output_string = output_string + Character.toString(character);
			
			x++;
			i = x*n - 1;
		}
	
		return output_string;
	}

	@Override
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) 
		throws MyIndexOutOfBoundsException, IllegalArgumentException, NullPointerException{
												//First character = position 1 = index 0
		String subString = test_input.substring(startPosition-1, endPosition);
		
			if (startPosition > endPosition){
				throw new IllegalArgumentException();
			}
			if (startPosition <1 || endPosition > test_input.length()) {
				throw new MyIndexOutOfBoundsException();
	}

			//replaceAll
			subString = subString.replaceAll("1", "One");
			subString = subString.replaceAll("2", "Two");
			subString = subString.replaceAll("3", "Three");
			subString = subString.replaceAll("4", "Four");
			subString = subString.replaceAll("5", "Five");
			subString = subString.replaceAll("6", "Six");
			subString = subString.replaceAll("7", "Seven");
			subString = subString.replaceAll("8", "Eight");
			subString = subString.replaceAll("9", "Nine");
			subString = subString.replaceAll("0", "Zero");
			
			test_input = 
						 test_input.substring(0, startPosition-1) + 
						 subString + 
						 test_input.substring(endPosition, test_input.length());
	}
	
}
