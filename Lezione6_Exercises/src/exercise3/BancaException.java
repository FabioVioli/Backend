package exercise3;

class BancaException extends Exception
{
	String message;
      // Parameterless Constructor
      public BancaException() {}

      // Constructor that accepts a message
      public BancaException(String message)
      {
         super(message);
         
      }

	@Override
	public String toString() {
		return "error";
	}
      
      
 }
	

