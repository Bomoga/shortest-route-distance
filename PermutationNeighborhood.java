
public class PermutationNeighborhood
{

    private final int[] p; //permutation
    private final int SIZE; //size of permutation
    private int loc1; //loc1 and loc2 are the locations of
    private int loc2; //p that will be swapped next

    public PermutationNeighborhood(int[] a) {
        this.p = a.clone();
        this.SIZE = a.length;
        this.loc1 = 0;
        this.loc2 = 1;
    }

    public boolean hasNext() {
        return loc1 < SIZE - 1;
    }

    public int[] next() {
        if (!hasNext()) {
            return null;
        }

        int[] neighbor = p.clone();
        int temp = neighbor[loc1];
        neighbor[loc1] = neighbor[loc2];
        neighbor[loc2] = temp;

        loc2++;
        if (loc2 == SIZE) {
            loc1++;
            loc2 = loc1 + 1;
        }

        return neighbor;
    }
}