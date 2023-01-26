package edu.westga.dsdm.demo;

import java.util.Scanner;

import edu.westga.dsdm.matrix.SymmetircMatrix;

/**
 * The Class MatrixDemo
 * 
 * @author CS3151
 * @version Spring 2023
 */
public class MatrixDemo {

	/**
	 * demos the use of class Matrix
	 */
	public void run() {
		int length = this.getLengthFromUser();
		SymmetircMatrix matrix = new SymmetircMatrix(length);
		System.out.println("Length: " + matrix.getLength());

		matrix.set(length - 1, length - 1, 4);
		matrix.set(0, length - 1, 4);
		matrix.print();

		matrix.set(length - 1, 0, 5);
		matrix.print();
	}

	private int getLengthFromUser() {
		int length = 0;
		try (Scanner input = new Scanner(System.in)) {
			while (length <= 0) {
				System.out.print("Enter the number rows of the matrix (must be greater than 0): ");
				length = input.nextInt();
			}
		}
		return length;
	}
}
