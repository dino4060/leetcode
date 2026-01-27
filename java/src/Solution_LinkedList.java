class Solution_LinkedList {
    public int solution(int[] A) {
        int length = 0;
        int currentIdx = 0;

        while (currentIdx != -1) {
            length++;

            currentIdx = A[currentIdx];
        }

        return length;
    }
}