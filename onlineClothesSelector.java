import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Map.Entry;

class randNumberGenerator {
    public HashMap<String, Double> randGenerator(LinkedList<String> itemList, int noOfItems) {
        HashMap<String, Double> itemAndProb = new HashMap<>();
        HashMap<String, Double> itemAndProbWinner = new HashMap<>();

        double probList[] = new double[noOfItems];

        for (int i = 0; i < noOfItems; i++) {
            double prob = Math.random();
            itemAndProb.put(itemList.get(i), prob);
            probList[i] = prob;
        }

        Arrays.sort(probList);

        for (Entry<String, Double> entry : itemAndProb.entrySet()) {
            if (entry.getValue() == probList[0]) {
                itemAndProbWinner.put(entry.getKey(), probList[0]);
                break;
            }
        }
        System.out.println(itemAndProb);
        return itemAndProbWinner;
    }
}

public class onlineClothesSelector {
    public static void main(String[] args) {
        Scanner item = new Scanner(System.in);
        Scanner no_Of_Items = new Scanner(System.in);
        LinkedList<String> itemList = new LinkedList<>();

        System.out.println("How many items are there");
        int noOfItems = no_Of_Items.nextInt();

        System.out.println("Enter the items that you want: ");
        for (int i = 0; i < noOfItems; i++) {
            System.out.print(i + 1 + ": ");
            String itemNumber = item.nextLine();
            itemList.add(itemNumber);
        }

        randNumberGenerator winner = new randNumberGenerator();
        HashMap<String, Double> Winner = new HashMap<>();
        Winner = winner.randGenerator(itemList, noOfItems);

        System.out.println(Winner);
        System.out.println("The Loser is " + Winner);
    }
}
