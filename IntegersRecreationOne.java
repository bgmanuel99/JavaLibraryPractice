import java.util.Vector;

public class SumSquaredDivisors {
	public static String listSquared(long m, long n) {
    	    Vector<Integer> divisors = new Vector<Integer>();
   	    Vector<int []> numbers = new Vector<int []>();
            int sum = 0;
            String finalString = "";
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
    
            for(int i = 0; i < numbers.size(); i++){
              finalString += "[" + numbers.elementAt(i)[0] + ", " + numbers.elementAt(i)[1] + "]";
              if(i != numbers.size() - 1) finalString += ", ";
            }
    
            return "[" + finalString + "]";
	}
}
