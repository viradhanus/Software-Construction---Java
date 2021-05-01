public class Matrix extends Thread {

	private static int[][] a;
	private static int[][] b;
	private static int[][] c;

	/* You might need other variables as well */
	private int i;
	private int j;
	private int z1;

	private int s;
	private int k;

	public Matrix(int[][] A, final int[][] B, final int[][] C, int i, int j, int z1) { // need to change this, might
																						// need some information
		a = A;
		b = B;
		c = C;
		this.i = i;
		this.j = j;
		this.z1 = z1; // a[0].length
	}

	public void run() {
		synchronized (c) {
			// 3. How to allocate work for each thread (recall it is the run function which
			// all the threads execute)

			// Here this code implements the allocated work for perticular thread
			// Each element of the resulting matrix will generate by a perticular thread
			for (s = 0, k = 0; k < z1; k++)
				s += a[i][k] * b[k][j];
			c[i][j] = s;

		}

	}

	public static int[][] returnC() {
		return c;
	}

	public static int[][] multiply(final int[][] a, final int[][] b) {

		/*
		 * check if multipication can be done, if not return null allocate required
		 * memory return a * b
		 */

		final int x = a.length;
		final int y = b[0].length;

		final int z1 = a[0].length;
		final int z2 = b.length;

		if (z1 != z2) {
			System.out.println("Cannnot multiply");
			return null;
		}

		final int[][] c = new int[x][y];
		int i, j;

		// 1. How to use threads to parallelize the operation?
		// Every element in the resulting matrix will be determined by a different
		// thread

		// 2. How may threads to use?
		// x * y threads are used to generate the result.
		for (i = 0; i < x; i++)
			for (j = 0; j < y; j++) {
				try {
					Matrix temp_thread = new Matrix(a, b, c, i, j, z1);
					temp_thread.start();

					// 4. How to synchronize?

					// synchronized() is used with join() to guarantee that the perticular thread
					// will be accessed first
					
					temp_thread.join();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		return Matrix.returnC();
	}

}