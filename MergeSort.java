public class MergeSort {
    static void merge(int arr[],int l,int m,int h){
        int newarr[] = new int[h-l+1];
        int x = 0, idx1 = l, idx2 = m+1;
        while(idx1<=m&&idx2<=h){
            if(arr[idx1]<=arr[idx2])
                newarr[x++] = arr[idx1++];
            else
                newarr[x++] = arr[idx2++];
        }
        while(idx1<=m)
            newarr[x++] = arr[idx1++];
        while(idx2<=h)
            newarr[x++] = arr[idx2++];
        for(int i=0,j=l;i<h-l+1;i++,j++)
            arr[j] = newarr[i];
    }
    static void mergeSort(int arr[],int l,int h){
        if(l<h){
            int mid = (l+h)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid+1, h);
            merge(arr,l,mid,h);
        }
    }
    public static void main(String[] args) {
        int arr[] = {10, 20, 45, 30, 15, 2, 28, 19, 22};
        int n = arr.length;
        mergeSort(arr,0,n-1);
        for(int i=0;i<n;i++)
            System.out.print(arr[i]+" ");
    }
}
