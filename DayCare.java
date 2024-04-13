import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * DayCare.java
 *
 * @author - Isaiah Martinez
 * @author - Period H
 *
 */
public class DayCare {
    public static void main(String[] args) {
        String[] rows = null;
        int numOfLines = 0;
        try {
            File file = new File("info.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line = br.readLine();

            while (line != null) {
                numOfLines++;
                line = br.readLine();
            }
            br.close();

            rows = new String[numOfLines];

            BufferedReader br2 = new BufferedReader(new FileReader(file));
            line = br2.readLine();
            int i = 0;
            while (line != null) {
                rows[i] = line;
                line = br2.readLine();
                i++;
            }

            br2.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        String[] names = new String[numOfLines];
        int[] ages = new int[numOfLines];
        String[] gender = new String[numOfLines];
        String[] hometown = new String[numOfLines];
        int[] days = new int[numOfLines];
        String[] number = new String[numOfLines];

        for (int i = 0; i < numOfLines; i++) {
            String[] row = rows[i].split(",");

            names[i] = row[0];
            ages[i] = Integer.parseInt(row[1]);
            gender[i] = row[2];
            hometown[i] = row[3];
            days[i] = Integer.parseInt(row[4]);
            number[i] = row[5];
        }

        for (int i = 0; i < numOfLines; i++) {
            System.out.println(names[i]);
        }

        int sum = 0;
        int sumMale = 0;
        int numMale = 0;
        int sumFemale = 0;
        int numFemale = 0;
        for (int i = 0; i < numOfLines; i++) {
            sum += ages[i];
            if (gender[i].equals("M")) {
                sumMale += ages[i];
                numMale++;
            } else {
                sumFemale += ages[i];
                numFemale++;
            }
        }
        System.out.println("Average age: " + sum / numOfLines);
        System.out.println("Average female age: " + sumFemale / numFemale);
        System.out.println("Average male age: " + sumMale / numMale);

        System.out.println("\nHistogram of towns:");
        for (int i = 0; i < numOfLines; i++) {
            boolean isAlreadyPrinted = false;
            for (int j = 0; j < i; j++) {
                if (hometown[i].equals(hometown[j])) {
                    isAlreadyPrinted = true;
                    break;
                }
            }
            if (!isAlreadyPrinted) {
                int count = 0;
                for (int j = 0; j < numOfLines; j++) {
                    if (hometown[i].equals(hometown[j])) {
                        count++;
                    }
                }
                System.out.println(hometown[i] + ": " + "*".repeat(count));
            }
        }

        int firstYears = 0;
        int secondYears = 0;
        int thirdYears = 0;
        int fourthYears = 0;
        int fifthYears = 0;
        for (int i = 0; i < numOfLines; i++) {
            if (ages[i] == 1) {
                firstYears++;
            } else if (ages[i] == 2) {
                secondYears++;
            } else if (ages[i] == 3) {
                thirdYears++;
            } else if (ages[i] == 4) {
                fourthYears++;
            } else if (ages[i] == 5) {
                fifthYears++;
            }
        }
        int total = firstYears * 35 + secondYears * 30 + thirdYears * 25 + fourthYears * 20 + fifthYears * 15;
        System.out.println("The total weekly income for the daycare is: $" + total);

        for (int i = 0; i < numOfLines; i++) {
            System.out.println((i + 1) + ") " + names[i]);
        }
        System.out.print("Enter the number of the student you want to look up: ");
        int choice = Integer.parseInt(System.console().readLine());
        System.out.println("Name: " + names[choice - 1]);
        System.out.println("Age: " + ages[choice - 1]);
        System.out.println("Gender: " + gender[choice - 1]);
        System.out.println("Hometown: " + hometown[choice - 1]);
        System.out.println("Days attending daycare: " + days[choice - 1]);
        System.out.println("Phone Number: " + number[choice - 1]);

        String[] lastNames = new String[numOfLines];

        for (int i = 0; i < numOfLines; i++) {
            String[] name = names[i].split(" ");
            lastNames[i] = name[name.length - 1];
        }

        for (int i = 0; i < numOfLines - 1; i++) {
            for (int j = 0; j < numOfLines - i - 1; j++) {
                if (lastNames[j].compareTo(lastNames[j + 1]) > 0) {
                    String tempLastName = lastNames[j];
                    lastNames[j] = lastNames[j + 1];
                    lastNames[j + 1] = tempLastName;

                    String tempName = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempName;

                    int tempAge = ages[j];
                    ages[j] = ages[j + 1];
                    ages[j + 1] = tempAge;

                    String tempGender = gender[j];
                    gender[j] = gender[j + 1];
                    gender[j + 1] = tempGender;

                    String tempHometown = hometown[j];
                    hometown[j] = hometown[j + 1];
                    hometown[j + 1] = tempHometown;

                    int tempDays = days[j];
                    days[j] = days[j + 1];
                    days[j + 1] = tempDays;

                    String tempNumber = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = tempNumber;
                }
            }
        }

        System.out.println("\nSorted Students:");
        for (int i = 0; i < numOfLines; i++) {
            System.out.println(names[i] + ", " + ages[i] + ", " + gender[i] + ", " + hometown[i] + ", " + number[i]);
        }

    }
}