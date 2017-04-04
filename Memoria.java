import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by lucas on 22/10/16.
 */
public class Memoria {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String[] dat = sc.nextLine().split(" ");
            int p = Integer.parseInt(dat[0]);
            int s = Integer.parseInt(dat[1]);
            int n = Integer.parseInt(dat[2]);

            int[] datos = new int[n];
            for (int j = 0; j < n; j++) {
                datos[j] = (int) (Integer.parseInt(sc.nextLine()) / s);
            }

            int f = fifo(datos, p);
            int l = lru(datos, p);
            String sol = "";

            if (l < f) {
                sol += "yes " + f + " " + l;
            } else {
                sol += "no " + f + " " + l;
            }
            System.out.println(sol);
        }
    }

    public static int fifo(int[] datos, int p) {
        int cuenta = 0;
        LinkedList<Integer> fifo = new LinkedList<>();
        for (int i = 0; i < datos.length; i++) {
            if (!fifo.contains(datos[i])) {
                if (fifo.size() == p) {
                    fifo.remove();
                    fifo.add(datos[i]);
                    cuenta++;
                } else {
                    fifo.add(datos[i]);
                }
            }
        }
        return cuenta;
    }

    public static int lru(int[] datos, int p) {
        int cuenta = 0;
        LinkedList<Integer> lru = new LinkedList<>();
        for (int i = 0; i < datos.length; i++) {
            if (!lru.contains(datos[i])) {
                if (lru.size() == p) {
                    lru.remove(0);
                    cuenta++;
                }
                lru.add(datos[i]);
            } else {
                lru.removeFirstOccurrence(datos[i]);
                lru.add(datos[i]);
            }
        }

        return cuenta;
    }
}
