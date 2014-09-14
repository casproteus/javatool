import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
/**
 * 
 * This is a demo for parameterisation of unit test.
 * @author admin
 *
 */
@RunWith(Parameterized.class)
public class demoOfParameterisation {

	private int[] A;
	private int X;
	private int[] expected;
//	Object solution = new Solution();
	
	@Parameters
	public static Collection<Object[]> arrays() {
		int[] AMax = new int[1000000];
		for (int i = 0; i < AMax.length; i++){
			AMax[i] = i;
		}
		AMax[999998] = 999999;
		
		return Arrays.asList(new Object[][] {
			{ new int[] { 1, 2, 3}, 2, new int[]{1}}, 	//general case, match with the second, should return 1;
			{ new int[] { 1, 2, 3}, 5, new int[]{-1}},	//general case, no match, should return -1;
			{ null, -1, new int[]{-1}}, 			// null, should return -1;
			{ new int[] {}, 3, new int[]{-1} }, 	// empty, should return -1;
			{ new int[] {1}, 1, new int[]{0} }, 	// only 1 value, match with first 1, should return 0;
			{ new int[] {1}, 3, new int[]{-1} }, 	// only 1 value, and no match, should return -1;
			{ new int[] {1, 2}, 2, new int[]{1}}, 	// only 2 values, and match with the second, should return 1;
			{ new int[] {1, 2}, 3, new int[]{-1}}, 	// only 2 values, and no match, should return -1;
			{ new int[] {1, 1, 2}, 1, new int[]{0,1} }, 	// both 0 and 1 match with X, should return 0 or 1;
			{ new int[] {1, 2, 2}, 2, new int[]{1,2} }, 	// both 1 and 2 match with X, should return 1 or 2;
			{ AMax, 999999, new int[]{999998, 999999}}, 	// for huge array case, matched value at the end, should return right value in time.
			{ AMax, 1000000, new int[]{-1}}, 				// for huge array, even no-match value at last, should return -1 in time.
		});
	}

	/**
	 * the constructor
	 * 
	 * @param A 		the array in non-descending order
	 * @param X			the value to search
	 * @param expected	the expected value that indicates a position where the value appear.
	 */
	public demoOfParameterisation(int[] A, Integer X, int[] expected) {
		this.A = A;
		this.X = X;
		this.expected = expected;
	}

	 @Test(timeout = 100)
	 public void test() {new demoOfParameterisation(null, 1, null);
		 int result = 0;//solution.solution(A, X);
		 for(int i = 0; i < expected.length; i++){
			 if(expected[i] == result){
				 assertTrue(true);
				 return;
			 }
		 }
		 StringBuilder sb = new StringBuilder("[");
		 sb.append(expected[0]);
		 for(int i = 1; i < expected.length; i++){
			 sb.append(", ");
			 sb.append(expected[i]);
		 }
		 sb.append("]");
		 Assert.fail("got " + result + ", while expected " + sb.toString());
	 }
}
