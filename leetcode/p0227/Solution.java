import java.util.*;

enum TokenType {
  NUM,
  OP
}
class Token {
  TokenType type;
  int num;
  char op;
  public Token(TokenType type, int num, char op) {
    this.type = type;
    this.num = num;
    this.op = op;
  }
}

class Solution {
    List<Token> output = new ArrayList<>();
    Stack<Character> op = new Stack<>();

    private int calSingle(int a, int b, char op) {
        switch(op) {
        case '+':
            a += b;
            break;
        case '-':
            a -= b;
            break;
        case '*':
            a *= b;
            break;
        case '/':
            a /= b;
            break;
        }
        return a;
    }
    private boolean isPrecedence(char op1, char op2) {
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
          return true;
        } else {
          return false;
        }
    }
  
    public int calculate(String s) {
        StringTokenizer stok = new StringTokenizer(s, " +-*/()", true);
        while(stok.hasMoreTokens()) {
          String token = stok.nextToken();
          switch(token.charAt(0)) {
            case ' ':
              // do nothing
              break;
            case '+':
            case '-':
            case '*':
            case '/':
              while (!op.empty() && !isPrecedence(token.charAt(0), op.peek())) {
                output.add(new Token(TokenType.OP, 0, op.pop()));
              }
              op.push(token.charAt(0));
              break;
            default:
              output.add(new Token(TokenType.NUM, Integer.parseInt(token), ' '));
          }
        }
        while(!op.empty()) {
          output.add(new Token(TokenType.OP, 0, op.pop()));
        }

        Stack<Integer> ans = new Stack<>();
        for (Token t : output) {
          if (t.type == TokenType.NUM) {
            ans.push(t.num);
          } else {
            Integer b = ans.pop();
            Integer a = ans.pop();
            ans.push(calSingle(a, b, t.op));
          }
        }

        return ans.pop();
    }
}
