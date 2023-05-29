import java.util.Scanner;

public class MatrixAddition {
	
	public static int[][] createArray(int rows, int cols) {
		
		
				
		Scanner sc = new Scanner(System.in);
		
		int matrix[][] = new int[rows][cols]; 
		
		for(int r=0; r<rows; r++) {
			for(int c=0; c<cols; c++) {
				
				System.out.println("Enter value at "+r+","+c+":");
				
				matrix[r][c] = sc.nextInt();
			}
		}
		
		
		return matrix;
		
	}
	
	public static void displayMatrix(int[][] matrix) {
		
		for(int r=0; r<matrix.length; r++) {
			for(int c=0; c<matrix[0].length; c++) {
				
				System.out.print(matrix[r][c]+"\t");
			}
			System.out.println("");
		}
	}
	
	public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
		
		int val1, val2, result;
		int[][] matrix3 = new int[matrix1.length][matrix1[0].length];
		
		for(int r=0; r<matrix1.length; r++) {
			for(int c=0; c<matrix1[0].length; c++) {
				
				val1 = matrix1[r][c];
				val2 = matrix2[r][c];
				
				result = val1 + val2;
				
				matrix3[r][c] = result;
			}
		}
		
		return matrix3;
	}

	public static void main(String[] args) {
		
		int rows, cols;
		
		Scanner sc = new Scanner(System.in);
		
		// Getting rows and columns for the matrices
		
		System.out.println("Enter number of rows: ");
		rows = sc.nextInt();
		System.out.println("Enter number of columns: ");
		cols = sc.nextInt();
		
		// Creating two matrices
		
		System.out.println("\nNow to enter the values for the first matrix. \n");
		int[][] matrix1 = createArray(rows, cols);
		System.out.println("\nNow to enter the values for the second matrix. \n");
		int[][] matrix2 = createArray(rows, cols);
		
		// Displaying the two matrices
		
		System.out.println("\nMatrix 1:\n");
		displayMatrix(matrix1);
		System.out.println("\nMatrix 2:\n");
		displayMatrix(matrix2);
		
		// Getting the sum of the two matrices and displaying the result
		
		int[][] matrix3 = addMatrices(matrix1, matrix2);
		System.out.println("\nMatrix 1 + Matrix 2 =\n");
		displayMatrix(matrix3);
		
			
	}

}
