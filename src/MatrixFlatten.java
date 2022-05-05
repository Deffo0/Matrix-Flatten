import java.util.ArrayList;

public class MatrixFlatten<T extends Comparable<T>> {
    private final ArrayList<T> vector;
    private int firstDimSize;
    private int secondDimSize;
    private int thirdDimSize;

    public MatrixFlatten(T[][][] matrix){
        this.firstDimSize = matrix.length;
        this.secondDimSize = matrix[0].length;
        this.thirdDimSize = matrix[0][0].length;
        // initialize the vector and fill it
        this.vector = new ArrayList<>(this.firstDimSize * this.secondDimSize * this.thirdDimSize);
        for (int i = 0; i < this.firstDimSize; i++) {
            for (int j = 0; j < this.secondDimSize; j++) {
                for (int k = 0; k < this.thirdDimSize; k++) {
                    this.vector.add(matrix[i][j][k]);
                }
            }
        }
    }

    public T get(int i, int j, int k){
        // get the desired element by dealing with each dimension as a building contain the other smaller dimensions
        return vector.get((i * this.secondDimSize * this.thirdDimSize) + (j * this.thirdDimSize) + k);
    }
}
