import java.util.Scanner;
public class arrayLab {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[] list = new double[20];
        int exitedAt = 0;
        System.out.println("Enter at least 1 and up to 20 doubles, enter 99999 to exit early:");
        for (int i = 0; i < list.length; i++){
            exitedAt = i;
            double addMe = sc.nextDouble();
            if (addMe == 99999){
                i = list.length;
            }
            else {
                list[i] = addMe;
            }
        }

        if (exitedAt == 0){
            System.out.println("No doubles entered!");
        }
        else if (exitedAt == 19){
            for (int f = 0; f < exitedAt + 1; f++){
                System.out.print(list[f] + " ");
            }
        }
        else {
            for (int h = 0; h < exitedAt; h++){
                System.out.print(list[h] + " ");
            }
        }
    }
}
