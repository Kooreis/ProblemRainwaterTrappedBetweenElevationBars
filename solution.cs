Here is a C# console application that calculates how much rainwater can be trapped between elevation bars:

```C#
using System;
using System.Linq;

class Program
{
    static void Main(string[] args)
    {
        Console.WriteLine("Enter the elevation bars separated by space:");
        var bars = Console.ReadLine().Split(' ').Select(int.Parse).ToArray();
        Console.WriteLine("The amount of rainwater that can be trapped is " + CalculateRainwater(bars));
    }

    static int CalculateRainwater(int[] bars)
    {
        int n = bars.Length;
        if (n <= 2) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = bars[0];
        for (int i = 1; i < n; i++)
            leftMax[i] = Math.Max(leftMax[i - 1], bars[i]);

        rightMax[n - 1] = bars[n - 1];
        for (int i = n - 2; i >= 0; i--)
            rightMax[i] = Math.Max(rightMax[i + 1], bars[i]);

        int water = 0;
        for (int i = 0; i < n; i++)
            water += Math.Min(leftMax[i], rightMax[i]) - bars[i];

        return water;
    }
}
```

This program reads a line of integers separated by spaces from the console, which represent the heights of the elevation bars. It then calculates the amount of rainwater that can be trapped between these bars and prints the result to the console. The calculation is done by finding the maximum height of a bar to the left and right of each bar, then subtracting the height of the bar itself from the minimum of these two values. The result is the amount of water that can be trapped above this bar. The total amount of trapped water is the sum of the amounts above each bar.