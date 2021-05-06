package java_vit;
import java.util.*;
import java.io.*;

public class Team implements Serializable {

    public static boolean string_is_integer(String str) {
        try {
            Integer.parseInt(str);
        }

        catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static String printInitials(String str) {
        Scanner tmp = new Scanner(str);

        String res = "";

        while (tmp.hasNext()) {
            res = res + Character.toLowerCase(tmp.next().charAt(0));
        }
        tmp.close();
        return res;
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the name of the team please : ");

        String team_name = sc.nextLine();

        File file = new File("Teams.txt");

        sc.close();

        sc = new Scanner(file);

        sc.nextLine(); // reads the first line with headings

        int flag = 0;

        while (sc.hasNext()) {
            String line = sc.nextLine(); // reads the next team details

            Scanner scan_line = new Scanner(line);

            String tname = "", token = "";

            while (scan_line.hasNext()) // scans the team details
            {
                token = scan_line.next();

                if (!string_is_integer(token)) {
                    tname = tname + token + " ";
                }

                else
                    break;
            }

            if (tname.equals(team_name)) {

                int home_wins = Integer.parseInt(token);
                int away_wins = Integer.parseInt(scan_line.next());
                int home_matches = Integer.parseInt(scan_line.next());
                int away_matches = Integer.parseInt(scan_line.next());

                scan_line.close();

                double home_win_percent = ((double) home_wins / (double) home_matches) * 100;
                double away_win_percent = ((double) away_wins / (double) away_matches) * 100;

                String hwp = "Home Win % : " + home_win_percent;
                String awp = "Away Win % : " + away_win_percent;

                System.out.println(hwp);
                System.out.println(awp);

                String filename = printInitials(tname) + ".ser";

                File fileout = new File(filename);

                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileout));

                out.writeObject(tname);
                out.writeObject(hwp);
                out.writeObject(awp);

                out.close();

                flag = 1;
                break;
            }

            else {
                continue;
            }
        }

        if (flag == 0)
            System.out.println("Team Not Found");

        sc.close();
        
    }

}
