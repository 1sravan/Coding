class Solution {
    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        int n = arr.length;

        for (int num : arr) {
            if (num == 0) zeros++;
        }

        int i = n - 1;
        int j = n + zeros - 1;

        while (i < j) {
            if (j < n) {
                arr[j] = arr[i];
            }

            if (arr[i] == 0) {
                j--;
                if (j < n) {
                    arr[j] = 0;
                }
            }

            i--;
            j--;
        }

        // boolean goahead=false;
        // for(int num : arr){
        //     if(num==0) {
        //         goahead=true;
        //         break;
        //     }
        // }
        // if(goahead){
        //     for (int i = 0; i < arr.length; i++) {
        //         if(arr[i] == 0){
        //             for (int j = arr.length-1; j > i ; j--) {
        //                 arr[j] = arr[j-1];
        //             }
        //             i++;
        //         }
        //     }
        // }       
    }
}
