import java.io.*;
import java.util.*;
public class Main {
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
        FastReader fs = new FastReader();

        Rect rect[] = new Rect[]{ new Rect(), new Rect() };
        for (Rect r : rect) {
            r.x1 = fs.nextInt();
            r.y1 = fs.nextInt();
            r.x2 = fs.nextInt();
            r.y2 = fs.nextInt();
        }

        System.out.println(solve(rect[0], rect[1]));
    }
    
    static String solve(Rect r1, Rect r2) {
        if (r1.isPoint(r2)) {
            return "POINT";
        }
        
        if (r1.isLine(r2)) {
            return "LINE";
        }
        
        if (r1.isFace(r2)) {
            return "FACE";
        }
        
        return "NULL";
    }
    
    static class Rect {
        int x1,y1,x2,y2;
        
        public boolean isPoint(Rect r) {
            return (x1 == r.x2 || x2 == r.x1) && (y1 == r.y2 || y2 == r.y1);
        }
        
        public boolean isLine(Rect r) {
            return (((x1 <= r.x1 && r.x1 < x2) || (x1 < r.x2 && r.x2 <= x2)
            || (x1 <= r.x1 && r.x2 <= x2) || (r.x1 <= x1 && x2 <= r.x2))&& (y1 == r.y2 || y2 == r.y1))
            || (((y1 <= r.y1 && r.y1 < y2) || (y1 < r.y2 && r.y2 <= y2)
            || (y1 <= r.y1 && r.y2 <= y2) || (r.y1 <= y1 && y2 <= r.y2)) && (x1 == r.x2 || x2 == r.x1));
        }
        
        public boolean isFace(Rect r) {
            return ((r.x1 <= x1 && x1 < r.x2) 
            || (r.x1 < x2 && x2 <= r.x2)
            || (x1 <= r.x1 && r.x2 <= x2)
            || (r.x1 <= x1 && x2 <= r.x2)) 
            && ((r.y1 <= y1 && y1 < r.y2) 
            || (r.y1 < y2 && y2 <= r.y2)
            || (y1 <= r.y1 && r.y2 <= y2)
            || (r.y1 <= y1 && y2 <= r.y2));
        }
    }
}
   