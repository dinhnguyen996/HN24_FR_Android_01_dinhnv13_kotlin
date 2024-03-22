package assignment4.exp5;

public class Main {
    public static void main(String[] args) {
        long a = 10;
        long b = 5;

        // Gọi các hàm Kotlin từ Java
        long sum = MyKotlinFunctionsKt.add(a, b);
        long difference = MyKotlinFunctionsKt.subtract(a, b);
        long product = MyKotlinFunctionsKt.multiply(a, b);
        long quotient = MyKotlinFunctionsKt.divide(a, b);

        // In kết quả
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
    }
}
