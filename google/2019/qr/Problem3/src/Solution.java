import java.io.*;
import java.util.*;

public class Solution {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        if ("true".equals(System.getProperty("use_text_input"))) {
            try {
                System.setIn(new FileInputStream(new File("test_in.txt")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            }
        }


        FastReader fs = new FastReader();
        int t = fs.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            int n = fs.nextInt();
            int l = fs.nextInt();
            int[] cipher = new int[l];
            for (int j = 0; j < l; ++j) {
                cipher[j] = fs.nextInt();
            }

            System.out.print("Case #" + tt + ": ");

            solve(n, cipher);
        }
    }

    private static void solve(int n, int[] cipher) {
        //int[] allPrimeNumbers = sieveOfEratosthenes(n);
        TreeSet<Integer> primeSet = new TreeSet<>();
        List<Integer> decryptNumbers = new ArrayList<>();

        int cur = 0;
        int next = 0;
        for (int p = 2; p <= n; ++p) {
            if (cipher[0] % p == 0) {
                cur = p;
                next = cipher[0] / p;
                break;
            }
        }

        if (cipher[1] % next != 0) {
            int tmp = cur;
            cur = next;
            next = tmp;
        }

        primeSet.add(cur);
        decryptNumbers.add(cur);

        primeSet.add(next);
        decryptNumbers.add(next);


        for (int i = 1; i < cipher.length; ++i) {
            int tmp = cipher[i] / next;
            primeSet.add(tmp);
            decryptNumbers.add(tmp);
            next = tmp;
        }

        HashMap<Integer, Character> dic = new HashMap<>();
        char cc = 'A';
        for (Integer p : primeSet) {
            dic.put(p, cc++);
        }
        for (Integer d : decryptNumbers) {
            System.out.print(dic.get(d));
        }
        System.out.println();
    }




    // https://www.geeksforgeeks.org/sieve-of-eratosthenes/
    static int[] sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                count++;
            }
        }

        int[] list = new int[count];
        int index = 0;
        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                //System.out.print(i + " ");
                list[index++] = i;
            }
        }
        return list;
    }
}
