import java.util.Vector;

public class SumSquaredDivisors {
	public static String listSquared(long m, long n) {
	    //This vector is to insert all the divisors an integer has
    	    Vector<Integer> divisors = new Vector<Integer>();
		
	    /*
	    *This is a vector of arrays in which i insert the right integers which sum of square divisors is a square itself,
	    *i first insert the number, and then the sum of his square divisors
	    */
   	    Vector<int []> numbers = new Vector<int []>();
            int sum = 0;
            String finalString = "";
		
	    /*
	    *With the first for i iterate from the first number (m), to the last (n),
	    *in each iteration with the second for i get all the divisors of the number of the parameter i.
	    *In the thrid for i get the sum of the square divisors; Then i get the square root of the sum, then i multiply
	    *the number by itself and if it gives me an integer number then the sum is a perfect square.
	    *If it is a perfect square then i insert it in the vector of arrays, and then i reset the vector of divisors
	    *and the sum of the square divisors, after it i continue in the first for until i finish with all the numbers
	    *from m to n.
	    */
	    for(int i = (int) m; i <= n; i++){
              for(int j = 1; j <= i; j++){
                if(i%j == 0) divisors.add(j);
              }
              for(int k = 0; k < divisors.size(); k++){
                sum += Math.pow(divisors.elementAt(k),2);
              }
              int rootNumber = (int) Math.sqrt(sum);
              if(rootNumber * rootNumber == sum){
                numbers.add(new int[]{i,sum});
                divisors.removeAllElements();
                sum = 0;
              }else{
                divisors.removeAllElements();
                sum = 0;
              }
            }
    
	    /*
	    *With this for i go over the vector of arrays and i insert in the final string, as the algorthim expects, all the
	    *data, then i return the string with two more open_Square_brakets.
	    */
            for(int i = 0; i < numbers.size(); i++){
              finalString += "[" + numbers.elementAt(i)[0] + ", " + numbers.elementAt(i)[1] + "]";
              if(i != numbers.size() - 1) finalString += ", ";
            }
    
            return "[" + finalString + "]";
	}
}
