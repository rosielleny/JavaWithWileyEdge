package com.rosie.bd;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDec {

	public static void main(String[] args) {
		
			double a=0.03;
	        double b=0.04;
	        double c=b-a;
	        System.out.println(c);

	        BigDecimal _a = new BigDecimal("0.03");
	        BigDecimal _b = new BigDecimal("0.04");
	        BigDecimal _c = _b.subtract(_a);
	        System.out.println(_c);

	      //Create BigDecimal object
			BigDecimal bdValue1,bdValue2;
			
			double inta = 56893.54000004;
			double intb = 56453.54660006;
			
			inta = inta + intb;
			
			System.out.println(inta);
			
			//Assigning value into BigDecimal object
			bdValue1 = new BigDecimal("56893.54000004");
			bdValue2 = new BigDecimal("56453.54660006");
			
			//Addition
			bdValue1 = bdValue1.add(bdValue2);
			
			System.out.println(bdValue1.toString());
			
			if (a < b) {
				System.out.println(a);
			}         // For primitive double
			BigDecimal A = new BigDecimal("2.345");
			BigDecimal B = new BigDecimal("5.654");
			
			if (A.compareTo(B) < 0)  { // For BigDecimal
			//Actually compareTo returns -1(less than), 0(Equal), 1(greater than) according to values.
				System.out.println("A is less than B");
				System.out.println(A);
			}

			//For equality we can also use:

			if (A.equals(B)) {
				
				System.out.println("A is equal to B");
				System.out.println(A);
				System.out.println(B);
			}  // A is equal to B

	
					// TODO Auto-generated method stub
					
		BigDecimal obj = new BigDecimal("32.37");
				
		BigDecimal obj1 = obj.setScale(1,RoundingMode.CEILING);
		System.out.println(obj1.toString());
		
		BigDecimal obj2 = new BigDecimal("45.37367");
		BigDecimal obj3 = obj2.divide(obj1, RoundingMode.HALF_UP);
		System.out.println(obj3.toString());
					
		BigDecimal obj4 = obj2.divide(obj1, 2, RoundingMode.HALF_UP);
		System.out.println(obj4.toString());
					
					
					
					

				}

			
	}


