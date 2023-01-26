package edu.westga.dsdm.matrix;

/**
 * The Class SymmetricMatrix
 * 
 * Maintains a matrix of dimension n x n where the entry in row i column j is
 * equal to the entry in row j column i
 * 
 * @author CS3151
 * @version Spring 2023
 */
public class SymmetircMatrix {

	private int[][] matrix;

	/**
	 * Creates a new symmetric matrix internally storing the elements in the lower
	 * triangle only
	 * 
	 * @pre length >= 1
	 * @post getLength() == length and matrix.get(i, j) == 1 for all i, j >= 0 and
	 *       i, j < length
	 * @param length the number rows and columns
	 */
	public SymmetircMatrix(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("length must be a positive value");
		}
		this.matrix = new int[length][];
		for (int i = 0; i < this.matrix.length; i++) {
			this.matrix[i] = new int[i + 1];
			for (int j = 0; j < i + 1; j++) {
				this.matrix[i][j] = 1;
			}
		}
	}

	/**
	 * Gets the value at the row index i and column index j
	 * 
	 * @pre i, j >= 0 and i, j < length
	 * @post none
	 * @param i the row index
	 * @param j the column index
	 * @return the value at row i and column j
	 */
	public int get(int i, int j) {
		this.checkIndices(i, j);
		if (i >= j) {
			return this.matrix[i][j];
		} else {
			return this.matrix[j][i];
		}
	}

	/**
	 * Gets the length of a row / column
	 * 
	 * @pre none
	 * @post none
	 * @return the length
	 */
	public int getLength() {
		return this.matrix.length;
	}

	/**
	 * Sets the element at the row index i and column index j to the specified value
	 * 
	 * @pre i, j >= 0 and i, j < length
	 * @post get(i, j) == value
	 * @param i     the row index
	 * @param j     the column index
	 * @param value the new value
	 */
	public void set(int i, int j, int value) {
		this.checkIndices(i, j);
		if ( i >= j) {
			this.matrix[i][j] = value;
		} else {
			this.matrix[j][i] = value;
		}
	}

	/**
	 * Prints the matrix elements row by row to the console
	 */
	public void print() {
		System.out.println("Matrix: ");
		int length = this.matrix.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.printf("%4d",this.get(i, j));
			}
			System.out.println("");
		}
	}

	private void checkIndices(int i, int j) {
		if (i < 0) {
			throw new IllegalArgumentException("row index must be greater than or equal to 0");
		}
		if (j < 0) {
			throw new IllegalArgumentException("column index must be greater than or equal to 0");
		}
		if (i >= this.getLength()) {
			throw new IllegalArgumentException("row index must be less than the length");
		}
		if (j >= this.getLength()) {
			throw new IllegalArgumentException("column index must be less than the length");
		}
	}
}
