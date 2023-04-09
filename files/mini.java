public class Mini {

    public static void minimum(int[] numbers) {
        int minimum = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            if (numbers[i] < minimum) {
                minimum = numbers[i];
            }
        }
        System.out.println(minimum);
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,5,6,-7,0};
        minimum(numbers);
    }
}