public class MedianofArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1_index = 0;
        int nums2_index = 0;
        int ab_size = nums1.length + nums2.length;
        int size = (ab_size)/2 + 1;

        int[] c = new int[size];

        System.out.println(size);

        for (int i = 0; i < size; i++){
            if(nums1_index == nums1.length){
                c[i] = nums2[nums2_index];
                nums2_index += 1;
            } else if (nums2_index == nums2.length){
                c[i] = nums1[nums1_index];
                nums1_index +=1;
            } else if(nums1[nums1_index] <= nums2[nums2_index]){
                c[i] = nums1[nums1_index];
                nums1_index += 1;
            } else {
                c[i] = nums2[nums2_index];
                nums2_index += 1;
            }
        }

        for(int i = 0; i < c.length; i++)
            System.out.print(c[i] + " ");

        if(ab_size % 2 == 0){
            double median = ((double)c[size - 1] + c[size - 2])/2;
            System.out.println(median);
            return median;
        } else
            return c[c.length-1];
    }

    public static void main(String[] args) {
        MedianofArrays m = new MedianofArrays();
        int[] arr1 = {1,4};
        int[] arr2 = {2,3,};

        System.out.println("\nThe median is: " + m.findMedianSortedArrays(arr1, arr2));;
    }
}
