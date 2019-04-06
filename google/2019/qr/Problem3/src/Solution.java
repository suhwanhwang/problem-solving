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
        TreeSet<Integer> primeSet = new TreeSet<>();
        List<Integer> decryptNumbers = new ArrayList<>();

        int first = 0;
        int second = 0;
        for (int p = 2; p <= n; ++p) {
            if (cipher[0] % p == 0) {
                first = p;
                second = cipher[0] / p;
                break;
            }
        }

        if (cipher[1] % second != 0) {
            int tmp = first;
            first = second;
            second = tmp;
        }

        primeSet.add(first);
        decryptNumbers.add(first);

        primeSet.add(second);
        decryptNumbers.add(second);

        for (int i = 1; i < cipher.length; ++i) {
            int next = 0;
            if (cipher[i - 1] == cipher[i]) {
                int p0 = 0;
                int p1 = 0;
                for (int p = 2; p <= n; ++p) {
                    if (cipher[0] % p == 0) {
                        p0 = p;
                        p1 = cipher[0] / p;
                        break;
                    }
                }
                int prev = decryptNumbers.get(decryptNumbers.size() - 1);
                next = (prev == p0 ? p1 : p0);
            } else {
                int gcd = gcd(cipher[i - 1], cipher[i]);
                next = cipher[i] / gcd;
            }

            primeSet.add(next);
            decryptNumbers.add(next);
        }

//        if (primeSet.size() != 26) {
//            throw new RuntimeException();
//        }

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

    static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    private static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
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
