class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Arrays.stream(candies).max().orElse(0);
        return Arrays.stream(candies).mapToObj(c->c+extraCandies>=max).collect(Collectors.toList());
    }
}