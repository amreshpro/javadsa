
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
       

            if (isFull()) {
                throw new Exception("Memory Full can't add more data");
            } else {
              
                this.ptr[++lastIndex] = data;
            }

        

    }

//  insert the value at given index
    public void insert(int index,int data) throws Exception {

        if (index < 0) {

            throw new Exception("index can't be negative");
        }

        if (lastIndex == this.capacity - 1) {

            throw new Exception("memory is full can't add more items ");

        }

        // shift item right
        for (int i = lastIndex; i >= index; i--) {

            int temp = this.ptr[i];

            this.ptr[i + 1] = temp;

        }

        this.ptr[index] = data;
        ++lastIndex;

    }

    public void delete(int index) throws Exception {

        if (index < 0) {

            throw new Exception("index can't be negative");
        }

        if (isEmpty()) {

            throw new Exception("can't delete item from an empty list ");

        }

        // shift item left
        for (int i = index; i < lastIndex; i++) {

            this.ptr[i] = this.ptr[i+1];

        }
        --lastIndex;

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
        if (index > lastIndex) {
            throw new Exception("can't access index beyond current size");
        }

        return this.ptr[index];

    }

    public void editArrayElementAtGivenIndex(int data, int index) throws Exception {
        if (index < 0) {
            throw new Exception("Index can't be negative");
        }
        if (index > lastIndex) {
            throw new Exception("can't edit element beyond size ");
        }

        this.ptr[index] = data;

    }

    public void display() {
        for (int i = 0; i <=lastIndex; i++) {
            System.out.print(this.ptr[i] + ", ");
        }
        System.out.println();
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
        System.out.println("get: " + array.getValueAtIndex(4));

        array.insert(4, 99);
        array.display();
        array.delete(2);
        array.display();


    }

}
