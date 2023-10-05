Here is a Java console application that calculates how much rainwater can be trapped between elevation bars:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of bars:");
        int n = scanner.nextInt();
        System.out.println("Enter the heights of the bars:");
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("The maximum amount of trapped rainwater is: " + calculateRainwater(height));
    }

    private static int calculateRainwater(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
        int water = 0;
        for (int i = 0; i < n; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }
}
```

This program first takes the number of bars and their heights as input. It then calculates the maximum amount of rainwater that can be trapped between the bars using the `calculateRainwater` method. This method uses two auxiliary arrays, `leftMax` and `rightMax`, to store the maximum height of a bar from the start to the current position and from the end to the current position, respectively. The amount of water that can be trapped at a certain position is the minimum of `leftMax` and `rightMax` at that position minus the height of the bar at that position. The total amount of trapped water is the sum of the water at all positions.