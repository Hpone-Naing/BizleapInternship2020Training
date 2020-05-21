package com.hponenaingtun.java.test;

public class Matrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// System.out.println("original matrix");
		// for (int[] outer : matrix) {
		// for (int inner : outer) {
		// System.out.print(inner + "\t");
		// }
		// System.out.println();
		// }
		for (int outer = matrix.length - 1; outer > 0; outer--) {
			for (int inner = 0; inner <= outer - 2; inner++) {
				System.out.print(matrix[outer][inner] + "\t");
			}
			System.out.println();
		}
	}
}
