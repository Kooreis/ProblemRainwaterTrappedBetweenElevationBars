Here is a Python console application that calculates how much rainwater can be trapped between elevation bars:

```python
def find_water(arr, n):
    left = [0]*n
    right = [0]*n
    water = 0
    left[0] = arr[0]
    for i in range( 1, n):
        left[i] = max(left[i-1], arr[i])
    right[n-1] = arr[n-1]
    for i in range(n-2, -1, -1):
        right[i] = max(right[i + 1], arr[i]);
    for i in range(0, n):
        water += min(left[i], right[i]) - arr[i]
    return water

def main():
    arr = list(map(int, input("Enter the elevation bars separated by space: ").split()))
    n = len(arr)
    print("Maximum water that can be trapped is", find_water(arr, n))

if __name__ == "__main__":
    main()
```

In this application, you can input the elevation bars as a space-separated list of integers. The application will then calculate and print the maximum amount of water that can be trapped between the bars.