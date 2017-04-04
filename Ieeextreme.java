import java.util.Scanner;

/**
 * Created by lucas on 22/10/16.
 */
public class Ieeextreme {

    static String[] answ = new  String[10];


    public static void main(String args[]) {
        int testCases;
        int q, n;
        String[] preg, resp;
        for (int i = 0; i < 10; i++) {
            answ[i] = "rgb";
        }
        String sol = "";
        Scanner scanner = new Scanner(System.in);

        testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i <testCases; i++) {
            q = scanner.nextInt();
            n = scanner.nextInt();
            preg = new String[q];
            resp = new String[q];
            for (int j = 0; j < q; j++) {
                preg[j] = scanner.nextLine();
                resp[j] = scanner.nextLine();
            }
            sol += resolver(n, preg, resp) + '\n';
        }
    }

    public static String resolver(int n, String[] preg, String[] resp) {
        if (preg.length == n) {
            for (int i = 0; i < preg.length; i++) {
                String[] subpreg;
                if (preg[i].contains("and")) {
                    subpreg = preg[i].split(" and ");
                    if (resp[i] == "no") {
                        for (int j = 0; j < subpreg.length; j++){
                            tratar(subpreg[i], "yes");
                        }
                    } else {

                    }

                } else if (preg[i].contains("or")) {
                    subpreg = preg[i].split(" or ");
                    if (resp[i] == "yes") {
                        for (int j = 0; j < subpreg.length; j++){
                            tratar(subpreg[i], "no");
                        }
                    } else {

                    }
                } else {
                    String respuesta = (resp[i] == "yes") ? "no" : "yes";
                    tratar(preg[i], respuesta);
                }
            }
        } else if (n == 0) {
            for (int i = 0; i < preg.length; i++) {
                String[] subpreg;
                if (preg[i].contains("and")) {
                    subpreg = preg[i].split(" and ");
                    if (resp[i] == "yes") {
                        for (int j = 0; j < subpreg.length; j++){
                            tratar(subpreg[i], "yes");
                        }
                    } else {

                    }

                } else if (preg[i].contains("or")) {
                    subpreg = preg[i].split(" or ");
                    if (resp[i] == "no") {
                        for (int j = 0; j < subpreg.length; j++){
                            tratar(subpreg[i], "no");
                        }
                    } else {

                    }
                } else {
                    tratar(preg[i], resp[i]);
                }
            }
        }
        return null;
    }

    public static void tratar(String pregunta, String respuesta) {
        String[] estaPreg = pregunta.split(" ");
        if (estaPreg[0] == "color") {
            if (respuesta == "no") {
                answ[Integer.parseInt(estaPreg[1]) - 1] = (answ[Integer.parseInt(estaPreg[1]) - 1].contains(estaPreg[2])) ?  answ[Integer.parseInt(estaPreg[1]) - 1].replace(estaPreg[2], "") : answ[Integer.parseInt(estaPreg[1]) - 1];
            } else {
                answ[Integer.parseInt(estaPreg[1]) - 1] = estaPreg[2];
            }
        } else {

        }
    }
}
