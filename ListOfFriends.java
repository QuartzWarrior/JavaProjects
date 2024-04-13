import java.util.ArrayList;
import java.util.Scanner;

/**
 * ListOfFriends.java
 *
 * @author - Isaiah Martinez
 * @author - Period H
 *
 */
public class ListOfFriends {
    public static void main(String[] args) {
        ArrayList<String> friendList = new ArrayList<String>();
        System.out.println("Please enter your friends' first name. Press \"d\" when you are done.");
        Scanner scanner = new Scanner(System.in);
        boolean notDone = true;
        while (notDone) {
            String friend = scanner.next();
            if (friend.equals("d")) {
                break;
            }
            friendList.add(friend);
        }
        System.out.println("You have entered " + friendList.size() + " friends.");
        int curr = 1;
        System.out.println("Here is your list of friends:");
        for (String friend : friendList) {
            System.out.println(curr + ". " + friend);
            curr++;
        }
        int choice1 = (int) (Math.random() * friendList.size()) + 1;
        int choice2 = (int) (Math.random() * friendList.size()) + 1;
        System.out.println("The two friends that have been randomly chosen to go to the movies with you are:");
        System.out.println(friendList.get(choice1));
        System.out.println(friendList.get(choice2));
        System.out.println(
                "Which friends would you like to take off your friend list and add to your best friend list? ( Indicate with the number next to each name. Press \"0\" to end )");
        notDone = true;
        ArrayList<String> bestFriendList = new ArrayList<String>();
        ArrayList<Integer> removingFriends = new ArrayList<Integer>();
        while (notDone) {
            int friendNum = scanner.nextInt();
            if (friendNum == 0) {
                break;
            }
            removingFriends.add(friendNum);
            bestFriendList.add(friendList.get(friendNum - 1));
        }
        for (int i = 0; i < removingFriends.size() - 1; i++) {
            for (int j = 0; j < removingFriends.size() - i - 1; j++) {
                if (removingFriends.get(j) < removingFriends.get(j + 1)) {
                    int temp = removingFriends.get(j);
                    removingFriends.set(j, removingFriends.get(j + 1));
                    removingFriends.set(j + 1, temp);
                }
            }
        }
        for (int i : removingFriends) {
            friendList.remove(i - 1);
        }
        System.out.println("Here is your list of friends:");
        curr = 1;
        for (String friend : friendList) {
            System.out.println(curr + ". " + friend);
            curr++;
        }
        curr = 1;
        System.out.println("Here is your list of best friends:");
        for (String friend : bestFriendList) {
            System.out.println(curr + ". " + friend);
            curr++;
        }
        scanner.close();
    }
}