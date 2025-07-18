class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        // Use HashSets to store unique elements from both arrays
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        // Populate set1 with elements from nums1
        for (int num : nums1) {
            set1.add(num);
        }

        // Populate set2 with elements from nums2
        for (int num : nums2) {
            set2.add(num);
        }

        // Lists to store elements that are unique to each array
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        // Find elements in set1 that are NOT in set2
        for (int num : set1) {
            if (!set2.contains(num)) {
                list1.add(num);
            }
        }

        // Find elements in set2 that are NOT in set1
        for (int num : set2) {
            if (!set1.contains(num)) {
                list2.add(num);
            }
        }

        // Return the two lists as a single result
        return Arrays.asList(list1, list2);
    }
}