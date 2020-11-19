package MainTask;

public class _4_CalculateArgumentsSum {
    public static void main(String[] args) {
        System.out.print("Arguments: ");
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + "   ");
        }

        double sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += Double.parseDouble(args[i]);
        }
        System.out.println("\nSummary of arguments: " + sum);
    }
}
