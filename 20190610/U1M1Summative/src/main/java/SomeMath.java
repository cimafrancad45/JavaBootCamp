public class SomeMath {

    public int total5(int a, int b, int c, int d, int e) {
        return a + b + c + d + e;
    }

    public double average5(int a, int b, int c, int d, int e) {
        int sum = a + b + c + d + e;
        return sum / 5;
    }

    public double largest5(double a, double b, double c, double d, double e) {

        if (a > b && a > c && a > d && a > e) {
            return a;
        } else if (b > a && b > c && b > d && b > e) {
            return b;
        } else if (c > a && c > b && c > d && c > e) {
            return c;
        } else if (d > a && d > b && d > c && d > e) {
            return d;
        } else {
            return e;
        }
    }
}
