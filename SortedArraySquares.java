public class SortedArraySquares {
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int current = squares.length - 1, left = 0, right = arr.length - 1;
        while(left<=right){
            int leftSquare = arr[left] * arr[left];
            int rightSquare = arr[right] * arr[right];
            if(leftSquare>rightSquare){
                squares[current--] = leftSquare;
                left++;
            }
            else{
                squares[current--] = rightSquare;
                right--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] results = SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3});// 4, 1, 0, 4, 9
        for(int num: results){
            System.out.print(String.valueOf(num));
        }
        System.out.println("");

        results = SortedArraySquares.makeSquares(new int[]{ -3, -1, 0, 1, 2});// 9, 1, 0, 1, 2
        for(int num: results){
            System.out.print(String.valueOf(num));
        }
        System.out.println("");
    }
}
