import java.util.*;

/**
 * Created by lucas on 22/10/16.
 */
public class Nokia {

    static double r = 6378.137;

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        HashMap<String, Client> clients = new HashMap<String, Client>();

        String[] lonlat = scanner.nextLine().split(",");
        double latitude = Double.parseDouble(lonlat[0]) * 2 * Math.PI / 360;
        double longitude = Double.parseDouble(lonlat[1]) * 2 * Math.PI / 360;

        double dist = Double.parseDouble(scanner.nextLine());
        scanner.nextLine();

        while (scanner.hasNextLine()) {
            String[] div1 = scanner.nextLine().split(" ");
            String[] div2 = div1[1].split(",");

            Client c = new Client(div1[0], div2[0], div2[1], div2[2], div2[3]);

            if (clients.containsKey(div2[3])) {
                if (c.date.after(clients.get(div2[3]).date)) {
                    clients.put(div2[3], c);
                }
            } else {
                clients.put(div2[3], c);
            }
        }

        ArrayList<String> sol = new ArrayList<>();
        for (String num: clients.keySet()) {
            Client cl = clients.get(num);
            double d = distancia(latitude, longitude, cl.lat, cl.lon);
            if (dist > distancia(latitude, longitude, cl.lat, cl.lon)) {
                sol.add(num);
            }
        }
        Collections.sort(sol);
        String s = "";
        for (String st: sol) {
            s += st + ",";
        }
        s = s.substring(0, s.length()-1);
        System.out.println(s);

    }



    public static double distancia(double lat1, double long1, double lat2, double long2) {
        return 2 * r * Math.asin(Math.sqrt(Math.pow(Math.sin((lat1-lat2)/2), 2) + Math.cos(lat1)*Math.cos(lat2)*Math.pow(Math.sin((long1-long2)/2), 2)));
    }
}

class Client {

    GregorianCalendar date;
    double lat, lon;
    String number;

    public Client(String d, String time, String lat, String lon, String number) {
        String[] dte = d.split("/");
        String[] tim = time.split(":");
        this.date = new GregorianCalendar(Integer.parseInt(dte[2]) + 1900, Integer.parseInt(dte[0]), Integer.parseInt(dte[1]), Integer.parseInt(tim[0]), Integer.parseInt(tim[1]));

        this.lat = Double.parseDouble(lat) * 2 * Math.PI / 360;
        this.lon = Double.parseDouble(lon) * 2 * Math.PI / 360;
        this.number = number;
    }

    public boolean compareNumber(Client c) {
        return this.number.equals(c.number);
    }

    public boolean after(Client c) {
        return this.date.after(c.date);
    }
}
