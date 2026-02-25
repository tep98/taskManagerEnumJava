import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> titles = new ArrayList<>();
        ArrayList<Integer> sizes = new ArrayList<>();

        int count = scanner.nextInt();
        scanner.nextLine();

        int i = 0;
        int index = 0;

        while (i < count) {

            String title = scanner.nextLine();
            if (index % 2 == 0) {
                titles.add(title);
            }
            index++;

            int size = scanner.nextInt();
            scanner.nextLine();
            if (index % 2 == 1) {
                sizes.add(size);
            }
            index++;

            i++;
        }

        int limit = scanner.nextInt();

        for (int j = 0; j < titles.size(); j++) {
            System.out.println(titles.get(j) + " " + sizes.get(j));
        }

        for (int j = 0; j < sizes.size(); j++) {

            int size = sizes.get(j);
            int cmp = Integer.compare(size, limit);

            switch (cmp) {
                case -1:
                    System.out.println(size + " < " + limit);
                    break;
                case 0:
                    System.out.println(size + " = " + limit);
                    break;
                case 1:
                    System.out.println(size + " > " + limit);
                    break;
            }
        }

        scanner.close();
    }
}