public class Program1 {
	
	    public int calculate(int n) {
	    	if(n == 0) return 1;
	    	return n * calculate(n - 1);
	    }
        public static void main(String []args) {
        	Program1 fact = new Program1();
            int number = 6;
            int result = fact.calculate(number);
            
            System.out.println("The factorial of " + number + " is: " + result);
        }
} 

