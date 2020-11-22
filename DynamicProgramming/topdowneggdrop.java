class Solution {
  public int eggDrop(int totalEggs, int totalFloors) {
    int[][] cache = new int[totalEggs + 1][totalFloors + 1];
    initializeCache(totalEggs, totalFloors, cache);

    return eggDrop(totalEggs, totalFloors, cache);
  }

  private int eggDrop(int totalEggs, int totalFloors, int[][] cache) {
    if (totalFloors == 1 || totalFloors == 0) {
      return totalFloors;
    }
    if (totalEggs == 1) {
      return totalFloors;
    }

    if (cache[totalEggs][totalFloors] != Integer.MAX_VALUE) {
      return cache[totalEggs][totalFloors];
    }

    for (int floor = 1; floor <= totalFloors; floor++) {

        int costOfWorstOutcome = Math.max(eggDrop(totalEggs - 1, floor - 1, cache),
                                          eggDrop(totalEggs, totalFloors - floor, cache));

        int accountingForDroppingAtThisSubproblem = 1 + costOfWorstOutcome;
        cache[totalEggs][totalFloors] = Math.min(cache[totalEggs][totalFloors],
                                                 accountingForDroppingAtThisSubproblem);
    }

    return cache[totalEggs][totalFloors];
  }

  private void initializeCache(int totalEggs, int totalFloors, int[][] cache) {
    for (int eggs = 2; eggs <= totalEggs; eggs++) {
      for (int floor = 2; floor <= totalFloors; floor++) {
        cache[eggs][floor] = Integer.MAX_VALUE;
      }
    }
  }
}