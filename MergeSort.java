import java.util.Arrays;
public class MergeSort {
    public static void main(String[] args) {
        // merge2sortedarray();
        int[] arr={4,2,6,4,8,55,82,5,9,7,0,12};
        System.out.println(Arrays.toString(arr));
        Sort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void Sort(int[] arr,int s,int e){
        if(e-s == 1){
            return;
        }
        int mid=s+(e-s)/ 2;

        Sort(arr,s,mid);
        Sort(arr,mid,e);
        merge2sortedarray(arr,s,mid,e);
    }


    static void merge2sortedarray(int[] arr,int s,int mid,int e){

        // int[] left=new int[mid-s+1];
        // int[] right=new int[e-mid];

        int[] mix=new int[e-s];



        int i=s,j=mid,k=0;
        while(i<mid && j< e){
            if(arr[i] < arr[j]){
                mix[k++]=arr[i++];
            }
            else{
                mix[k++]=arr[j++];
            }
        }

        while(i<mid){
            mix[k++]=arr[i++];
        }

        while(j<e){
            mix[k++]=arr[j++];
        }
        // Copying elements of mix into original array
        // s is the start index of the array
        for(int l=0;l<e-s;l++){
            arr[s+l]=mix[l];
        }
    }
}