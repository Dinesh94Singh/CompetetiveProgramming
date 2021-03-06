import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Result {
    public static boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = 0;
        int idx = 0;
        for (char i : instructions.toCharArray()) {
            if (i == 'L')
                idx = (idx + 3) % 4;
            else if (i == 'R')
                idx = (idx + 1) % 4;
            else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }
        return (x == 0 && y == 0) || (idx != 0);
    }
    public static List<String> doesCircleExist(List<String> commands) {
        List<String> result = new ArrayList<>();
        if (commands.isEmpty() || commands.size() == 1)
            return result; // no moves to make

        for(int k = 1; k < commands.size(); k++) {
            String i = commands.get(k);
            Boolean b = Result.isRobotBounded(i);
            if (b == true) {
                result.add("YES");
            } else {
                result.add("NO");
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("case 2 - " + doesCircleExist(Arrays.asList(new String[]{"2", "G", "L"})));
        System.out.println("case 1 - " + doesCircleExist(Arrays.asList(new String[]{"1", "GRGL"})));
    }
}

// public class Solution {
//     public static void main(String[] args) throws IOException {

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int commandsCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<String> commands = IntStream.range(0, commandsCount).mapToObj(i -> {
//            try {
//                return bufferedReader.readLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        })
//            .collect(toList());
//
//        List<String> result = Result.doesCircleExist(commands);
//
//        bufferedWriter.write(
//            result.stream()
//                .collect(joining("\n"))
//            + "\n"
//        );
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
// }
