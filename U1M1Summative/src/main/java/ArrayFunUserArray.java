public class ArrayFunUserArray {
    public int[] newUserArray (int a, int b, int c, int d, int e){
        int[] newArray = new int[5];
        newArray[0] = a;
        newArray[1] = b;
        newArray[2] = c;
        newArray[3] = d;
        newArray[4] = e;
        for (int i = 0; i < newArray.length; i++){
        System.out.println(newArray[i]);
        }
        return newArray;

    }
}
