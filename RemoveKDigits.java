public class RemoveKDigits {

    private static final char[] stack = new char[100001];
    public static String removeKdigits(String num, int k) {
        int n = num.length();
        if(n == k) return "0";
        int top = -1;
        for(int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while(top != -1 && k > 0 && stack[top] > c) {
                top--;
                k--;
            }
            stack[++top] = c;
        }
        top -= k;
        int bottom = 0;
        while(bottom < top && stack[bottom] == '0') bottom++;
        if(bottom >= top) return String.valueOf(stack[top]);
        return String.valueOf(stack, bottom, top - bottom + 1);
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3)); 
        System.out.println(removeKdigits("10200", 1)); 
        System.out.println(removeKdigits("10", 2));     
    }
}
