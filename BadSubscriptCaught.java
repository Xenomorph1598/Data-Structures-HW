import java.util.Scanner;
public class BadSubscriptCaught {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] names = {"John", "Mary", "Steve", "Pierre", "May", "Brian", "Larry", "Mike", "Pearl", "Isabelle"};
        try {
            System.out.println("What position would you like to see the name in?");
            int position = sc.nextInt();
            System.out.println("The name in this position is: " + names[position]);
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("ERROR: Entered position is out of bounds");
        }
    }
}
