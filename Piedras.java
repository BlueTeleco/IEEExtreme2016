import java.util.Scanner;

/**
 * Created by lucas on 22/10/16.
 */
public class Piedras {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            int g = Integer.parseInt(sc.nextLine());
            long movs = 0;
            for (int j = 0; j < g; j++) {
                sc.nextLine();
                String[] datos  = sc.nextLine().split(" ");
                for ( int k = 0; k < datos.length; k++) {
                    movs += (Long.parseLong(datos[k]) - 1) / 2;
                }
            }
            if (movs % 2 == 0) {
                System.out.println("Bob");
            } else {
                System.out.println("Alice");
            }
        }
    }
}
