public class StringReferences {
    public static void main(String[] args) {
        String a = "Hello";
        System.out.println("a initialized: " + a);
        System.out.println("a initialized address: " + (a.hashCode()));
        System.out.println();

        String b = a;
        System.out.println("b initialized: " + b);
        System.out.println("b initialized address: " + (b.hashCode()));
        System.out.println();

        String alpha = "Harry Potter";
        String beta = "Cinderella";
        System.out.println("alpha initialized: " + alpha);
        System.out.println("alpha initialized address: " + (alpha.hashCode()));
        System.out.println();
        System.out.println("beta initialized: " + beta);
        System.out.println("beta initialized address: " + (beta.hashCode()));
        System.out.println();
    }

}