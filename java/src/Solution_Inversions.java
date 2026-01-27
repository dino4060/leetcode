import java.util.Arrays;

public class Solution_Inversions {
    private static final int LIMIT = 1_000_000_000;

    public int solution(int[] A) {
        long result = countInversions(A, 0, A.length - 1);
        return result > LIMIT ? -1 : (int) result;
    }

    private long countInversions(int[] arr, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;

            count += countInversions(arr, left, mid);
            if (count > LIMIT) return count;

            count += countInversions(arr, mid + 1, right);
            if (count > LIMIT) return count;

            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    private long mergeAndCount(int[] arr, int l, int m, int r) {
        int[] leftArr = Arrays.copyOfRange(arr, l, m + 1);
        int[] rightArr = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l;
        long swaps = 0;

        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
                swaps += (leftArr.length - i);
            }
        }
        
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        
        while (j < rightArr.length) arr[k++] = rightArr[j++];

        return swaps;
    }
}
