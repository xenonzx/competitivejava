import java.util.Arrays;

public class Heap<E> {
    int lastPosition;
    int size;
    E[] array;
    Heap(int size){
        this.size = size;
        this.lastPosition = -1;
        array =(E[])  new Object[size];
    }


    void add(E value){
        if (lastPosition == size-1){
            // cant add more
            return;
        }
        lastPosition++ ;
        array[lastPosition] = value ;
        trickleUp(lastPosition);
    }
    E remove(){
        E result = null;
        if (lastPosition == 0){
            // cant remove more
            return result;
        }
        result = array[0];
        array[0] = array[lastPosition];
        trickleDown(0);
        array[lastPosition] = null;
        lastPosition --;
        return result;
    }

    void trickleDown(int parentIndex) {
        int lIndex = leftChildIndex(parentIndex);
        int rIndex = rightChildIndex(parentIndex);
        int biggerValueChildIndex = biggerValueIndex(lIndex, rIndex);

        // stopping condition: if parent is now a leaf and has no children to swap with
        if (biggerValueChildIndex == -1){
            return;
        }

        // stopping condition if parent value is greater than children
        if (((Comparable<E>)array[parentIndex]).compareTo(array[biggerValueChildIndex])>0){
            return;
        } else {
            swapValues(parentIndex, biggerValueChildIndex);
            // biggerValueChildIndex now has the value that we need to trackle down
            trickleDown(biggerValueChildIndex);
        }


    }

    private int biggerValueIndex(int lIndex, int rIndex) {
        int biggerValueIndex  = -1;
        E leftValue = null;
        E rightValue = null ;

        // instead of null checking  i can check on index and check if its less than lastIndex
        try {
            leftValue = array[lIndex];
        } catch (ArrayIndexOutOfBoundsException e){

        }

        try {
            rightValue = array[rIndex];
        } catch (ArrayIndexOutOfBoundsException e){

        }

        if (rightValue == null && leftValue ==null){
            return biggerValueIndex;
        }else if(rightValue ==null){
            return lIndex;
        }else if(leftValue ==null){
            return rIndex;
        }

        if (((Comparable<E>)rightValue).compareTo(leftValue)>0){
            //left is greater
            biggerValueIndex = rIndex;
        } else {
            biggerValueIndex = lIndex;
        }
        return biggerValueIndex;
    }

    void trickleUp(int itemIndex){
        // stopping condition: you have reached root
        if(itemIndex == 0)
            return;
        int pIndex = parentIndex(itemIndex);

        if (((Comparable<E>)array[pIndex]).compareTo(array[itemIndex])>0){
            // value at parent is greater or equal
            return;
        } else {
            swapValues(pIndex,itemIndex);
            // now pindex holds the value
            trickleUp(pIndex);
        }
        // if item value is greater than its parent
    }

    void swapValues(int index1 , int index2){
        E temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    int parentIndex(double index){
        return (int) Math.floor((index-1.0)/2.0);
    }

    int leftChildIndex(int parentIndex){
        return 2*parentIndex + 1;
    }

    int rightChildIndex(int parentIndex){
        return 2*parentIndex + 2;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "lastPosition=" + lastPosition +
                ", size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
