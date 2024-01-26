import java.util.Scanner;
public class money_converter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter money amount:");
        String money = sc.nextLine();
        double noDollaSine = Double.parseDouble(money.substring(1));
        int amount = (int) (noDollaSine * 100);
        int quarters = amount / 25;
        int remainingAfterQuarters = amount % 25;
        int dimes = remainingAfterQuarters / 10;
        int remainingAfterDimes = remainingAfterQuarters % 10;
        int nickels = remainingAfterDimes / 5;
        if (quarters > 0){
            if (dimes > 0){
                if (nickels > 0){
                    System.out.println("You have " + quarters + " quarter(s), " + dimes + " dime(s), and " + nickels + " nickel(s).");
                }
                else{
                    System.out.println("You have " + quarters + " quarter(s) and " + dimes + " dime(s).");
                }
            }
            else{
                if (nickels > 0){
                    System.out.println("You have " + quarters + " quarter(s) and " + nickels + " nickel(s).");
                }
                else{
                    System.out.println("You have " + quarters + " quarter(s).");
                }
            }
        }
        else if (dimes > 0) {
            if (nickels > 0){
                System.out.println("You have " + dimes + " dime(s) and " + nickels + " nickel(s).");
            }
            else{
                System.out.println("You have " + dimes + " dime(s).");
            }
        }
        else if (nickels > 0) {
            System.out.println("You have " + nickels + " nickel(s).");
        }
        else{
            System.out.println("You have no money.");
        }
    }
}