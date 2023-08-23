public class MinMaxDivAndCon {
    static int max1 = Integer.MIN_VALUE;
    static int min1 = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static void minMax(int arr[],int l,int r){
        if(l==r){
            min = max = arr[l];
        }
        else if(l+1==r){
            if(arr[l]>arr[r]){
                min = arr[r];
                max = arr[l];
            }
            else{
                min = arr[l];
                max = arr[r];
            }
        }
        else{
            int m = (l+r)/2;
            minMax(arr, l, m);
            minMax(arr, m+1, r);
        }
        if(min<min1)
            min1 = min;
        if(max>max1)
            max1 = max;
    }
    public static void main(String[] args) {
        int arr[] = {-1,4,105,1,19};
        minMax(arr, 0, 4);
        System.out.println(min1+" "+max1);
    }
}
