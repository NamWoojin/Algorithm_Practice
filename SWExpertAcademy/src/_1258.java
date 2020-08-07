import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1258 {
	static class Matrix implements Comparable<Matrix> {
		int r;
		int c;

		Matrix(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Matrix o) {
			int thisMul = this.r*this.c;
			int oMul = o.r * o.c;
			if(thisMul != oMul)
				return thisMul - oMul;
			else {
				return this.r -o.r;
			}
		}

		@Override
		public String toString() {
			return r + " " + c + " ";
		}

	}

	static int[][] array;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; ++tc) {
			StringTokenizer st;
			N = Integer.parseInt(in.readLine());
			array = new int[N + 2][N + 2];
			ArrayList<Matrix> matrixArray = new ArrayList<>();
			for (int i = 1; i <= N; ++i) {
				st = new StringTokenizer(in.readLine());
				for (int j = 1; j <= N; ++j) {
					array[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int count = 0;
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					if (array[i][j] != 0) {
						++count;
						matrixArray.add(countMatrix(i, j));
					}
				}
			}
			matrixArray.sort(null);
			sb.append("#").append(tc).append(" ").append(count).append(" ");
			for(int i = 0; i<matrixArray.size();++i) {
				sb.append(matrixArray.get(i).toString());
			}
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}

	private static Matrix countMatrix(int i, int j) {
		int countR = 0;
		int countC = 0;
		int ii = i;
		int jj = j;
		while (array[ii++][jj] != 0) {
			++countR;
		}
		--ii;--ii;
		while (array[ii][jj++] != 0)
			++countC;
		--jj;--jj;
		for (int r = i; r < i + countR; ++r) {
			for (int c = j; c < j + countC; ++c) {
				array[r][c] = 0;
			}
		}
		return new Matrix(countR, countC);
	}
}
