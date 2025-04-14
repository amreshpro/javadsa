
class DynArray {

    // properties
    private int lastIndex;
    private int[] ptr;

    // constructor
    public DynArray(int size) {
        ptr = new int[size];
        lastIndex = -1;
    }

    // methods
    // doubled the size
    public void doubledTheSize() {
        int[] doubledArray = new int[this.ptr.length * 2];
        for (int i = 0; i < this.ptr.length; i++) {
            doubledArray[i] = this.ptr[i];
        }
        this.ptr = doubledArray;
    }

    // half the size of array
    public void halfTheSize() {
        int[] halfArray = new int[this.ptr.length / 2];
       int limit = Math.min(halfArray.length, this.ptr.length);
        for (int i = 0; i < limit; i++) {
            halfArray[i] = this.ptr[i];
        }
        this.lastIndex = limit -1;
        this.ptr = halfArray;

    }

    // append
    public void append(int data) {
      
            if (lastIndex == this.ptr.length - 1) {
                doubledTheSize();
            }
            this.ptr[++lastIndex] = data;

       
    }

    // printArray
    public void printArray() {
        System.out.println("\n--------------------------------");
        for (int i = 0; i <= lastIndex; i++) {
            System.out.print(this.ptr[i] + ", ");
        }
        System.out.println("\n--------------------------------");

    }

    // insert
    public void insert(int index, int data) {

        try {
            if (index < 0 || index > lastIndex+1) {
                throw new IndexOutOfBoundsException("invalid index");
            }

            if (isFull()) {
                doubledTheSize();
            }

            for (int i = lastIndex; i >= index; i--) {
                // right shift
                this.ptr[i + 1] = this.ptr[i];

            }
            this.ptr[index] = data;
            ++lastIndex;

        } catch (IndexOutOfBoundsException e) {
            e.getMessage();
        }

    }

    // delete
    public void delete(int index) {
        try {
            if (isEmpty() || index < 0 || index > lastIndex) {
                throw new IndexOutOfBoundsException("Invalid index for deletion");
            }

            if(totalElement() < getCapacity() / 4){
                halfTheSize();
            }

            for (int i = index; i < lastIndex; i++) {
                this.ptr[i] = this.ptr[i + 1];
            }
            --lastIndex;

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    // total number of element
    public int totalElement() {
        return this.lastIndex + 1;
    }

    // get value stored at given index
    public int valueAt(int index) {
        try {
            if (index < 0 || index > this.lastIndex) {
                throw new IndexOutOfBoundsException("try to access element beyond size or negative index");
            }

            return this.ptr[index];
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    // check array empty or  not
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    // capacity of the array
    public int getCapacity() {
        return this.ptr.length;
    }

    // is array full
    public boolean isFull() {
        return this.lastIndex == this.ptr.length - 1;
    }

}

public class DynamicArray {

    public static void main(String[] args) {
        DynArray arr = new DynArray(10);
        arr.append(10);
        arr.append(20);
        arr.append(30);
        arr.append(40);
        arr.printArray();
        arr.insert(0, 11);
        arr.insert(0, 22);
        arr.insert(0, 33);
        arr.insert(0, 34);
        arr.insert(0, 35);
        arr.insert(9, 36);
        arr.printArray();
        arr.delete(0);
        arr.printArray();
        arr.delete(9);
        arr.printArray();
        arr.delete(4);
        arr.printArray();
        System.out.println("valueat5: " + arr.valueAt(5));

    }
}
