import java.io.*;
import java.util.*;
class matrixChainMul {
	static char name;

	static void printParenthesis(int i, int j, int n,int[][] bracket)
	{
		if (i == j) {
			System.out.print(name++);
			return;
		}
		System.out.print("(");

		printParenthesis(i, bracket[i][j], n, bracket);
		printParenthesis(bracket[i][j] + 1, j, n, bracket);
		System.out.print(")");
	}
	static void matrixChainOrder(int p[], int n)
	{
		int[][] m = new int[n][n];
		int[][] bracket = new int[n][n];

	
		for (int i = 1; i < n; i++)
			m[i][i] = 0;

		// L is chain length.
		for (int L = 2; L < n; L++) {
			for (int i = 1; i < n - L + 1; i++) {
				int j = i + L - 1;
				m[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j - 1; k++) {

					int q = m[i][k] + m[k + 1][j]
							+ p[i - 1] * p[k] * p[j];
					if (q < m[i][j]) {
						m[i][j] = q;
						bracket[i][j] = k;
					}
				}
			}
		}


		name = 'A';
		System.out.print("Optimal Parenthesization is : ");
		printParenthesis(1, n - 1, n, bracket);
		System.out.print("\nOptimal Cost is : "+ m[1][n - 1]);
	}

	public static void main(String[] args)
	{
		int arr[] = { 40, 20, 30, 10, 30 };
		int n = arr.length;
		matrixChainOrder(arr, n);
	}
}

