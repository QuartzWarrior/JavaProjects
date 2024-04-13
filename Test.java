public class Test {
    public static void main(String args[]) {
int[] array = {1, 3, 0, 2, 4}; for(int i = 0; i < array.length; i++) { array[array[i]] = array[i]; }
for (int i = 0; i< array.length; i++){System.out.println(array[i]);}
    }
}
