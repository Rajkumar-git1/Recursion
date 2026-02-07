import java.util.Scanner;

class PalindromeNumber {
    static int rev = 0;

    static void reverse(int n) {
        if (n == 0) return;
        rev = rev * 10 + (n % 10);
        reverse(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();

        reverse(n);

        if (n == rev)
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}
