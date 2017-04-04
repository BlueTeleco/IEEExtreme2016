import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lucas on 22/10/16.
 */
public class Post {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] ap = sc.nextLine().split(" ");
            int a = Integer.parseInt(ap[0]);
            int p = Integer.parseInt(ap[1]);
            ArrayList<Hilo> hilos = new ArrayList<>();
            int[] posts = new int[p];

            for (int i = 0; i < p; i++) {
                posts[i] = Integer.parseInt(sc.nextLine());
                if (posts[i] == 0) {
                    hilos.add(new Hilo(i+1));
                } else {
                    int target = encuentra(posts[i], posts);
                    for (int j  = 0; j < hilos.size(); j++) {
                        if (hilos.get(j).name == target) {
                            hilos.get(j).size++;
                        }
                    }
                }
            }
            int max = 0;
            int acum = 0;
            while (hilos.size() > 0) {
                max = max(max, acum, a, hilos);
            }
            System.out.println(max);
        }
    }

    public static int max(int max, int acum, int a, ArrayList<Hilo> restantes) {
        if (restantes.size() == 0) {
            max = (max > Math.abs(acum - a)) ? max : Math.abs(acum - a);
            return max;
        }
        if (Math.abs(acum - a) < Math.abs(acum + restantes.get(0).size - a)) {
            max = (max > Math.abs(acum - a)) ? max : Math.abs(acum - a);
            return max;
        } else if (Math.abs(acum - a) == Math.abs(acum + restantes.get(0).size - a)) {
            max = (max > Math.abs(acum - a)) ? max : Math.abs(acum - a);
            restantes.remove(0);
            return max;
        } else {
            int s = restantes.remove(0).size;
            max = max(max, acum + s, a, restantes);
            return max;
        }
    }

    public static int encuentra(int a, int[] posts) {
        if (posts[a-1] == 0) {
            return a;
        } else {
            return encuentra(posts[a-1], posts);
        }
    }
}

class Hilo {

    int name;
    int size;

    public Hilo(int n) {
        size = 1;
        name = n;
    }
}