package lab.java7;

public class Main {
    public static void main(String[] args) {
        System.out.println(ArraySum.calculateSum(new int[]{1,2,3,4}, 2));
        System.out.println(MatrixMaxElement.findMaxElement(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        }));
        WarehouseTransfer warehouseTransfer = new WarehouseTransfer();
        warehouseTransfer.transfer();
    }
}
