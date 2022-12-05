import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

/*

abca
a
abc
abca
 
 */

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = fs.nextInt(), m = fs.nextInt();
			char[] s = fs.next().toCharArray();
			int[] tries = fs.readArray(m);
			int[][] freq = new int[n][26];
			for (int i = 0; i < n; i++) {
				Arrays.fill(freq[i], 0);
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 26; j++) {
					if (i > 0) {
						freq[i][j] += freq[i-1][j]; 
					}
				}
				freq[i][s[i]-'a']++;
			}
			int[] newFreq = new int[26];
			Arrays.fill(newFreq, 0);
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < 26; j++) {
					newFreq[j] += freq[tries[i]-1][j];
				}
			}
//			for (int i = 0; i < n; i++) {
//				for (int j = 0; j < 26; j++) {
//					System.out.print(freq[i][j] + " ");
//				}
//				System.out.println();
//			}
			for (int i = 0; i < 26; i++) {
				newFreq[i] += freq[n-1][i];
			}
			for (int i = 0; i < 26; i++) {
				System.out.print(newFreq[i] + " ");
			}
			System.out.println();
		}
		out.close();
	}

	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
