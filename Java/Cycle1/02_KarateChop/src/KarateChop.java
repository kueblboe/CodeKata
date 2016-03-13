/**
 * Created by Liz on 13/03/2016.
 */
public class KarateChop {

    public static int chop(int value, int[] array) {

        if(array.length == 1) {
            if(array[0] == value) {
                return 0;
            }
        } else if(array.length > 1) {
            if(value <= getMiddleValue(array)){
                return chopLeftHalf(value, array);
            } else {
                return chopRightHalf(value, array);
            }
        }

        return -1;
    }

    private static int chopLeftHalf(int value, int[] array) {
        int left[] = {array[0]};
        return chop(value, left);
    }

    private static int[] getSubArray(int start, int finish, int[] array) {

        int newArray[] = new int[finish-start];
        for (int i = start; i < finish; i++) {
            newArray[i-start] = array[i];
        }
        return newArray;
    }

    private static int chopRightHalf(int value, int[] array) {
        int right[] = getSubArray((int) Math.ceil(array.length/2), array.length, array);
        int rightValue = chop(value, right);
        if (rightValue == -1) {
            return -1;
        } else {
            return array.length/2 + rightValue;
        }
    }

    private static int getMiddleValue(int[] array) {
        int middle = array.length/2;
        return array[middle-1];
    }
}
