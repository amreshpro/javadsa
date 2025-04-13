
import java.util.Scanner;

class Array {

    //  instace variable
    int lastIndex = -1;
    int[] ptr = null;
    int capacity;

    //  constructor
    public Array(int size) throws Exception {
        if (size > 0) {
            this.ptr = new int[size];
            this.capacity = size;
        } else {
            throw new Exception("size can't be negative or zero");
        }

    }

    // check size is full or not
    public boolean isFull() {
        return lastIndex == this.capacity - 1;
    }

    // append data in array
    public void append(int data) throws Exception {
        if (lastIndex < 0) {
            ++lastIndex; // -1 + 1 = 0
            this.ptr[lastIndex] = data;
        } else {

            if (isFull()) {
                throw new Exception("Memory Full can't add more data");
            } else {
                ++lastIndex;
                this.ptr[lastIndex] = data;
            }

        }

    }

    //  get total number in array
    public int getTotalNumberInArray() {
        return lastIndex + 1;
    }

    // check is empty or not
    public boolean isEmpty() {
        return this.lastIndex == -1;
    }

    //  get size of  array
    public int getSize() {
        return lastIndex + 1;
    }

    // get capacity of array
    public int getCapacity() {
        return this.capacity;
    }

// get value at given index 
    public int getValueAtIndex(int index) throws Exception {
        if (index < 0) {
            throw new Exception("Index can't be negative");
        }
        if (index > capacity) {
            throw new Exception("can't access out of the capacity ");
        }

        return this.ptr[index];

    }

    public void editArrayElementAtGivenIndex(int data, int index) throws Exception {
        if (index < 0) {
            throw new Exception("Index can't be negative");
        }
        if (index > capacity) {
            throw new Exception("can't access out of the capacity ");
        }

        this.ptr[index] = data;

    }

    public void display() {
        for (int data : this.ptr) {
            System.out.println(data + ", ");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Enter size: ");
        int size = new Scanner(System.in).nextInt();
        Array array = new Array(size);
        array.append(20);
        array.append(30);
        array.append(40);
        array.append(50);
        array.append(60);
        array.display();
        System.out.println("epmty:" + array.isEmpty());
        System.out.println("full:" + array.isFull());
        System.out.println("size:" + array.getSize());
        System.out.println("cap:" + array.getCapacity());
        array.editArrayElementAtGivenIndex(78, 4);
        System.out.println("get: "+array.getValueAtIndex(4));
        array.display();

    }

}
