
import java.io.*;
import java.util.*;

class Result {
	static int countWays(int arr[], int n)
	{
		int[] prefix_sum = new int[n];
		prefix_sum[0] = arr[0];
		for (int i = 1; i < n; i++)
			prefix_sum[i]
				= prefix_sum[i - 1] + arr[i];

		int[] suffix_sum = new int[n];

		suffix_sum[n - 1] = arr[n - 1];

		for (int i = n - 2; i >= 0; i--)
			suffix_sum[i]
				= suffix_sum[i + 1] + arr[i];

		int s = 1, e = 1;
		int curr_subarray_sum = 0, count = 0;

		while (s < n - 1 && e < n - 1) {

			while (e < n - 1
				&& curr_subarray_sum
						< prefix_sum[s - 1]) {
				curr_subarray_sum += arr[e++];
			}

			if (curr_subarray_sum <= suffix_sum[e]) {
				count++;
			}

			curr_subarray_sum -= arr[s++];
		}
		return count;
	}
	public static void main(String args[])
	{

		int[] arr = { 2, 3, 1, 7 };
		int n = arr.length;
		System.out.println(countWays(arr, n));
	}
}
