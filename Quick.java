public class Quick {
    static int partition(int arr[],int l,int h){
        int pivot = l;
        while(l<h){
            while(l<h&&arr[l]<=arr[pivot])
                l++;
            while(arr[h]>arr[pivot])
                h--;
            if(h>l){
                int temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp; 
            }
            int t = arr[h];
            arr[h] = arr[pivot];
            arr[pivot] = t;
        }
        return h;
    }
    static void quickSort(int arr[],int l,int h){
        if(l<h){
            int i = partition(arr,l,h);
            quickSort(arr, l, i-1);
            quickSort(arr, i+1, h);
        }
    }
    public static void main(String[] args) {
        int arr[] = {10,7,2,6,9};
        int n = arr.length;
        quickSort(arr,0,n-1);
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
    }
}

