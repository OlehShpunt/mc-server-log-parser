import java.util.*;
import java.io.*;

public class Driver {

    public static void main(String[] args) {

        Player listOfPLayers[] = {
                new Player("JustOlezha"),
                new Player("MellowConch8924"),
                new Player("Uppex23"),
                new Player("Mykola45"),
                new Player("BlahPlayer78194"),
                new Player("RomanSuperSila"),
                new Player("Andruha2103"),
                new Player("ItsSofiakika"),
                new Player("Dima Vorob"),
                new Player("TTnightNt"),
                new Player("myphonemax"),
                new Player("Dimas1k11")

        };

        createTextFile("logFiles/latest.log");
        for (Player player : listOfPLayers) {
            calculateTime(player, "textFile.txt");
            //ADD TO results.txt all sout-s
            /*try {
                FileWriter tempWriter = new FileWriter("results.txt", true);
                tempWriter.write("" + "\n");
                tempWriter.write(player.playerName + "\n");
                tempWriter.write("------------" + "\n");
                tempWriter.write(player.getHoursPlayed() + " hours" + "\n");
                tempWriter.write(player.getMinutesPlayed() + " minutes" + "\n");
                tempWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }*/

            System.out.println();
            System.out.println(player.playerName);
            System.out.println("------------");
            System.out.println(player.getHoursPlayed() + " hours");
            System.out.println(player.getMinutesPlayed() + " minutes");
        }
    }

    public static void createTextFile(String logFile) {

        try {
            Scanner scanner = new Scanner(new File(logFile));
            FileWriter output = new FileWriter("textFile.txt");
            while (scanner.hasNext()) {
                String toWrite = scanner.nextLine() + "\n";
                if (!toWrite.contains("AutoCompaction")) {
                output.write(toWrite);
                }
            }
            scanner.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
    }

    public static void calculateTime(Player player, String fileSource) {
        try {
            Scanner scanner = new Scanner(new File(fileSource));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                 if (line.contains("disconnected") && line.contains(player.playerName) && player.isConnected()) {
                    player.setConnected(false);
                    player.setDisconnectedDate(line);
                    int allTimeInMinutes = calculateMinutes(player);
                    int allHours = (int)Math.floor((allTimeInMinutes / 60));
                    player.setHoursPlayed(player.getHoursPlayed() + allHours);
                    player.setMinutesPlayed(player.getMinutesPlayed() + (Math.abs(allHours * 60 - allTimeInMinutes)));
                } else if (line.contains("connected") && line.contains(player.playerName)){
                    player.setConnected(true);
                    player.setConnectedDate(line);
                }
            }
            scanner.close();
            int addLastHours = player.getMinutesPlayed() / 60;
            int setLastMinutes = player.getMinutesPlayed() - addLastHours * 60;
            player.setHoursPlayed(player.getHoursPlayed() + addLastHours);
            player.setMinutesPlayed(setLastMinutes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static int calculateHours(Player player) {
        long differenceInHours = player.getDisconnectedDate() / 1000 / 60 / 60 - player.getConnectedDate()/1000 / 60 / 60;
        return (int)differenceInHours;
    }

    public static int calculateMinutes(Player player) {
        long differenceInHours = player.getDisconnectedDate() / 1000 / 60 - player.getConnectedDate() / 1000 / 60;
        return (int) differenceInHours;
    }
}