package test;

public class MyClass {
    public static void main(String args[]) {
        int x = 20;
        int y = x-- + 5 + --x;
        //      20    5    18
        //      -> x = 19 ↗
        System.out.printf("x의 값은 %d, y의 값은 %d\n", x, y);
        
        int a = 2, b = 5;
        System.out.printf("%d, %d, %d, %d", b--, b--, b, ++b);
    }
}
