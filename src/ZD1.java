// public class ZD1 {
//
//    public static void main(String[] args) {
//
//        int[] numbers = { 3, 6, 1, 7, 2, 8, 10, 4, 9, 5 };
//        int n = numbers.length;
//
//        selectionSort(numbers, 0, n - 1);
//
//        for (int i = 0; i < n; i++)
//            System.out.print(numbers[i] + " ");
//    }
//
//    // Алгоритм сортировки по выбору
//    public static void selectionSort(int[] numbers, int low, int high) {
//        for (int h = low; h <= high; h++)
//            swap(numbers, h, getSmallest(numbers, h, high));
//    }
//
//    // Получение позиции наименьшего значения от numbers[low] до numbers[high]
//    public static int getSmallest(int[] numbers, int low, int high) {
//        int small = low;
//        for (int i = low + 1; i <= high; i++)
//            if (numbers[i] < numbers[small])
//                small = i;
//        return small;
//    }
//
//    // сменные номера
//    public static void swap(int[] numbers, int i, int j) {
//        int temp = numbers[i];
//        numbers[i] = numbers[j];
//        numbers[j] = temp;
//    }
//
//}

public class ZD1 {
    public static void main(String[] args) {
        int[] num = { 55,65,12,-5,2,8,10,4,9,5};
        int n = num.length;

        mergeSort(num, 0, n - 1);

        for (int i : num) System.out.print(i + " ");
    }

    public static void mergeSort(int[] elements, int low, int high) {
        if (low < high) { // список содержит не менее 2 элементов
            int mid = (low + high) / 2;
            mergeSort(elements, low, mid); // рекурсия : сортировка первой половины
            mergeSort(elements, mid + 1, high); // рекурсия : сортировка второй половины
            merge(elements, low, mid, high); // объединить обе отсортированные половины
        }
    }


    private static void merge(int[] subset, int low, int mid, int high) {

        int n = high-low+1;
        int[] Temp = new int[n];

        int i = low, j = mid + 1;
        int k = 0;

        while (i <= mid || j <= high) {
            if (i > mid)
                Temp[k++] = subset[j++];
            else if (j > high)
                Temp[k++] = subset[i++];
            else if (subset[i] < subset[j])
                Temp[k++] = subset[i++];
            else
                Temp[k++] = subset[j++];
        }
        for (j = 0; j < n; j++)
            subset[low + j] = Temp[j];
    } // завершить
}
