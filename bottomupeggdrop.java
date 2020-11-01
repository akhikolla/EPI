class Solution {
  public int eggDrop(int totalEggs, int totalFloors) {
    int cache[][] = new int[totalEggs + 1][totalFloors + 1];
    for (int eggs = 1; eggs <= totalEggs; eggs++) {
      cache[eggs][0] = 0;
      cache[eggs][1] = 1;
    }
    for (int floor = 1; floor <= totalFloors; floor++) {
      cache[1][floor] = floor;
    }
    for (int eggs = 2; eggs <= totalEggs; eggs++) {
      for (int floor = 2; floor <= totalFloors; floor++) {
        cache[eggs][floor] = Integer.MAX_VALUE;
        for (int attemptFloor = 1; attemptFloor <= floor; attemptFloor++) {
          int costOfWorstOutcome = Math.max(cache[eggs - 1][attemptFloor - 1],
                                            cache[eggs][floor - attemptFloor]);
          int accountingForDroppingAtThisSubproblem = 1 + costOfWorstOutcome;
          cache[eggs][floor] = Math.min(cache[eggs][floor], accountingForDroppingAtThisSubproblem);

        }
      }
    }
    return cache[totalEggs][totalFloors];
  }
}