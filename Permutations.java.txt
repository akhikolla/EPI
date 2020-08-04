class Solution {
  public List<List<Integer>> permute(int[] originalArray) {
    List<List<Integer>> allPermutations = new ArrayList<>();
    generateAllPermutations(new ArrayList<>(), originalArray, allPermutations);
    return allPermutations;
  }

  private void generateAllPermutations(
    List<Integer> runningChoices,
    int[] originalArray,
    List<List<Integer>> allPermutations
  ) {
    if (runningChoices.size() == originalArray.length) {
      allPermutations.add(new ArrayList<>(runningChoices));
      return;
    }
    for (int i = 0; i < originalArray.length; i++) {
      int choice = originalArray[i];
      if (runningChoices.contains(choice)) {
        continue;
      }
      runningChoices.add(choice);
      generateAllPermutations(runningChoices, originalArray, allPermutations);
      runningChoices.remove(runningChoices.size() - 1);
    }
  }
}