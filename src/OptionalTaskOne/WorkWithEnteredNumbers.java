package OptionalTaskOne;

import java.util.*;

public class WorkWithEnteredNumbers {
    public static void main(String[] args) {
        System.out.print("Enter numbers: ");
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        Integer longest = getLongestInteger(list);
        Integer shortest = getShortestInteger(list);
        System.out.println("LongestNumber: " + longest + "; Length: " + longest.toString().length());
        System.out.println("ShortestNumber: " + shortest + "; Length: " + shortest.toString().length());

        list.sort((o1, o2) -> o1.toString().length() - o2.toString().length());
        System.out.print("\nSorted list: ");
        for (int i = 0; i < list.size(); i++) {
            //System.out.print(list.get(i) + " (" + getCountOfDifferentDigits(list.get(i)) + ")   ");
            System.out.print(list.get(i) + "   ");
        }

        double avglength = getAverageLength(list);
        System.out.print("\n\nAverage length: " + avglength);
        System.out.print("\nLess than avg length: ");
        for (int i = 0; i < list.size(); i++) {
            if ((double)list.get(i).toString().length() < avglength)
            System.out.print(list.get(i) + "   ");
        }
        System.out.print("\nMore than avg length: ");
        for (int i = 0; i < list.size(); i++) {
            if ((double)list.get(i).toString().length() > avglength)
                System.out.print(list.get(i) + "   ");
        }

        System.out.println("\nNumber with max different digits: " + getNumberWithMaxDifferentDigits(list));
    }

    public static Integer getLongestInteger(ArrayList<Integer> list) {
        Integer longest = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).toString().length() > longest.toString().length()) {
                longest = list.get(i);
            }
        }
        return longest;
    }
    public static Integer getShortestInteger(ArrayList<Integer> list) {
        Integer shortest = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).toString().length() < shortest.toString().length()) {
                shortest = list.get(i);
            }
        }
        return shortest;
    }
    public static double getAverageLength(ArrayList<Integer> list) {
        double avg = 0;
        for (int i = 0; i < list.size(); i++) {
            avg += (double)list.get(i).toString().length();
        }
        avg /= (double)list.size();
        return  avg;
    }
    public static int getNumberWithMaxDifferentDigits(ArrayList<Integer> list) {
        int withMaxDifferentDigits = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (getCountOfDifferentDigits(withMaxDifferentDigits) < getCountOfDifferentDigits(list.get(i))) {
                withMaxDifferentDigits = list.get(i);
            }
        }
        return withMaxDifferentDigits;
    }
    public static int getCountOfDifferentDigits(Integer number) {
        int count = 0;
        for (Integer i = 0; i <= 9; i++) {
            if (number.toString().indexOf(i.toString().charAt(0)) != -1) {
                count++;
            }
        }
        return count;
    }



}
