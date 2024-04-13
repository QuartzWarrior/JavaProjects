package FriendList;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FriendList {
    public static void main(String[] args) {
        ArrayList<Friend> friends = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Let's enter your friends in the system!");
        System.out.println(
                "When you are ready to stop entering friends, put a \"d\" for the first or the last name entry. That entry will not be added to your list.");

        while (true) {
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            if (firstName.equalsIgnoreCase("d")) {
                break;
            }

            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            if (lastName.equalsIgnoreCase("d")) {
                break;
            }

            System.out.print("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            friends.add(new Friend(firstName, lastName, age));
        }

        System.out.println("You have entered " + friends.size() + " friends.");
        printFriends(friends);

        boolean running = true;
        while (running) {
            System.out.println("Choose from the following items:");
            System.out.println("1. Sort by First Name");
            System.out.println("2. Sort by Last Name");
            System.out.println("3. Sort by Age");
            System.out.println("4. Randomly Shuffle List");
            System.out.println("5. Find the Oldest");
            System.out.println("6. Find the average age");
            System.out.println("7. Quit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                sortByFirstName(friends);
                printFriends(friends);
            } else if (choice == 2) {
                sortByLastName(friends);
                printFriends(friends);
            } else if (choice == 3) {
                sortByAge(friends);
                printFriends(friends);
            } else if (choice == 4) {
                shuffleList(friends);
                printFriends(friends);
            } else if (choice == 5) {
                Friend oldest = findOldestFriend(friends);
                System.out.println("The oldest friend is: " + oldest);
            } else if (choice == 6) {
                double averageAge = calculateAverageAge(friends);
                System.out.println("The average age is: " + averageAge);
            } else if (choice == 7) {
                scanner.close();
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please choose a number between 1 and 7.");
            }
        }
    }

    private static void sortByFirstName(ArrayList<Friend> friends) {
        int n = friends.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (friends.get(j).getFirstName().compareTo(friends.get(j + 1).getFirstName()) > 0) {
                    Friend temp = friends.get(j);
                    friends.set(j, friends.get(j + 1));
                    friends.set(j + 1, temp);
                }
            }
        }
    }

    private static void sortByLastName(ArrayList<Friend> friends) {
        int n = friends.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (friends.get(j).getLastName().compareTo(friends.get(j + 1).getLastName()) > 0) {
                    Friend temp = friends.get(j);
                    friends.set(j, friends.get(j + 1));
                    friends.set(j + 1, temp);
                }
            }
        }
    }

    private static void sortByAge(ArrayList<Friend> friends) {
        int n = friends.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (friends.get(j).getAge() > friends.get(j + 1).getAge()) {
                    Friend temp = friends.get(j);
                    friends.set(j, friends.get(j + 1));
                    friends.set(j + 1, temp);
                }
            }
        }
    }

    private static void shuffleList(ArrayList<Friend> friends) {
        Random rand = new Random();
        int n = friends.size();
        for (int i = 0; i < n; i++) {
            int randomIndex = i + rand.nextInt(n - i);

            Friend temp = friends.get(randomIndex);
            friends.set(randomIndex, friends.get(i));
            friends.set(i, temp);
        }
    }

    private static void printFriends(ArrayList<Friend> friends) {
        System.out.println("Here is your list of friends:");
        int index = 1;
        for (Friend friend : friends) {
            System.out.println(index + ". " + friend);
            index++;
        }
    }

    private static Friend findOldestFriend(ArrayList<Friend> friends) {
        Friend oldestFriend = null;
        int maxAge = 0;
        for (Friend friend : friends) {
            if (friend.getAge() > maxAge) {
                maxAge = friend.getAge();
                oldestFriend = friend;
            }
        }
        return oldestFriend;
    }

    private static double calculateAverageAge(ArrayList<Friend> friends) {
        int totalAge = 0;
        for (Friend friend : friends) {
            totalAge += friend.getAge();
        }
        return (double) totalAge / friends.size();
    }
}