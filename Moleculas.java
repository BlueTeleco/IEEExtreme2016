import java.util.Scanner;

/**
 * Created by lucas on 22/10/16.
 */
public class Moleculas {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] datos = sc.nextLine().split(" ");

        long c = Long.parseLong(datos[0]);
        long h = Long.parseLong(datos[1]);
        long o = Long.parseLong(datos[2]);

        long agua = (2*o + h - 4*c);
        long co2 = (2*o - h);
        long glucosa = (4*c + h - 2*o);

        if (agua >= 0 && co2 >= 0 && glucosa >= 0 && agua % 4.0 == 0 && co2 % 4.0 == 0 && glucosa % 24.0 == 0) {
            System.out.println(agua/4 + " " + co2/4 + " " + glucosa/24);
        } else {
            System.out.println("Error");
        }
    }
}
