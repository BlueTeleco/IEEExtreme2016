import java.util.Scanner;

/**
 * Created by lucas on 22/10/16.
 */
public class Pintor {

    static String pincel1, pincel2;

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            pincel1 = null;
            pincel2 = null;
            int n = Integer.parseInt(scanner.nextLine());
            String[] colors = scanner.nextLine().split(" ");
            System.out.println(cuenta(colors));
        }

    }

    public static int cuenta(String[] colores) {
        int cuenta = 0;
        pincel1 = colores[0];
        cuenta++;
        for (int i = 1; i < colores.length; i++) {
            if (!colores[i].equals(pincel1) && !colores[i].equals(pincel2)) {
                if (pincel2 == null) {
                    pincel2 = colores[i];
                    cuenta++;
                } else {
                    String prov1 = pincel1;
                    String prov2 = pincel2;
                    for (int j = i + 1; j < colores.length; j++) {
                        if (colores[j].equals(pincel1)) {
                            pincel2 = colores[i];
                            cuenta++;
                            break;
                        } else if (colores[j].equals(pincel2)) {
                            pincel1 = colores[i];
                            cuenta++;
                            break;
                        }
                    }
                    if (pincel1.equals(prov1) && pincel2.equals(prov2)) {
                        pincel1 = colores[i];
                        cuenta++;
                    }
                }
            }
        }
        return cuenta;
    }
}
