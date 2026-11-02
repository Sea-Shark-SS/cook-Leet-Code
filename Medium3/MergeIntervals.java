package Medium3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][0]; // Handle empty input case
        }

        // Sort the intervals based on the starting times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the next one
            if (currentInterval[1] >= intervals[i][0]) {
                // Merge the intervals by updating the end time
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // No overlap, add the current interval to the merged list
                merged.add(currentInterval);
                currentInterval = intervals[i]; // Move to the next interval
            }
        }

        // Add the last interval
        merged.add(currentInterval);

        // Convert the list to a 2D array and return
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged1 = merge(intervals1);
        System.out.println(Arrays.deepToString(merged1)); // Output: [[1, 6], [8, 10], [15, 18]]

        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] merged2 = merge(intervals2);
        System.out.println(Arrays.deepToString(merged2));
 }
}
