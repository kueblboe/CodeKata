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
            return chopArray(value, array);
        }
        return -1;
    }

    private static int chopArray(int value, int[] array) {
        if(value < getMiddleValue(array)){
            return chopLeftHalf(value, array);
        } else {
            return chopRightHalf(value, array);
        }
    }

    private static int chopLeftHalf(int value, int[] array) {
        int leftHalf[] = getSubArray(0, getMiddlePos(array), array);
        return chop(value, leftHalf);
    }

    private static int chopRightHalf(int value, int[] array) {
        int rightHalf[] = getSubArray(getMiddlePos(array), array.length, array);
        int rightValue = chop(value, rightHalf);
        if (rightValue == -1) {
            return -1;
        } else {
            return getMiddlePos(array) + rightValue;
        }
    }

    private static int[] getSubArray(int start, int finish, int[] array) {
        int length = finish - start;
        int newArray[] = new int[length];
        for (int i = 0; i < length; i++) {
            newArray[i] = array[i+start];
        }
        return newArray;
    }

    private static int getMiddlePos(int[] array) {
        return (int) Math.floor(array.length/2);
    }

    private static int getMiddleValue(int[] array) {
        int middleValue = array[getMiddlePos(array)];
        return middleValue;
    }
}
