import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static class InputReader {
        private final BufferedReader br;
        private StringTokenizer st;

        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // Function to find gcd of array of
    // numbers
    static int findGCD(int arr[], int n) {
        int result = arr[0];
        for (int i = 1; i < n; i++)
            result = gcd(arr[i], result);

        return result;
    }

    public static void main(String[] args) {
        // write your code here
        InputReader in = new InputReader();
        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        int gcd = findGCD(a, n);

        if (gcd != 1) {
            for (int i = 0; i < n; ++i) {
                a[i] /= gcd;
            }
        }

        manipulated_seive((int)1.5e7 + 1);

        int max = 0;
        int[] count = new int[(int)1.5e7 + 1];
        for (int i = 0; i < n; ++i) {
            int num = a[i];
            while (num > 1) {
                int d = SPF[num];
                count[d]++;
                max = Math.max(max, count[d]);
                while (num % d == 0) {
                    num /= d;
                }
            }
        }

        if (max == 0) {
            System.out.println("-1");
        } else {
            System.out.println(n - max);
        }
    }

    static boolean[] isprime;
    static ArrayList<Integer> prime;
    static int[] SPF;

    // function generate all prime number less then N in O(n)
    static void manipulated_seive(int N) {
        isprime = new boolean[N + 1];
        Arrays.fill(isprime, true);

        SPF = new int[N + 1];
        prime = new ArrayList<>();

        // 0 and 1 are not prime
        isprime[0] = isprime[1] = false;

        // Fill rest of the entries
        for (int i = 2; i < N; i++) {
            // If isPrime[i] == True then i is
            // prime number
            if (isprime[i]) {
                // put i into prime[] vector
                prime.add(i);

                // A prime number is its own smallest
                // prime factor
                SPF[i] = i;
            }

            // Remove all multiples of  i*prime[j] which are
            // not prime by making isPrime[i*prime[j]] = false
            // and put smallest prime factor of i*Prime[j] as prime[j]
            // [ for exp :let  i = 5 , j = 0 , prime[j] = 2 [ i*prime[j] = 10 ]
            // so smallest prime factor of '10' is '2' that is prime[j] ]
            // this loop run only one time for number which are not prime
            for (int j = 0; j < prime.size() &&
                         i * prime.get(j) < N && prime.get(j) <= SPF[i]; j++) {
                isprime[i * prime.get(j)] = false;

                // put smallest prime factor of i*prime[j]
                SPF[i * prime.get(j)] = prime.get(j);
            }
        }
    }
}
