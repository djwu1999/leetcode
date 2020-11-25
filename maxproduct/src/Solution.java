import java.util.ArrayList;
import java.util.List;

class Solution {
    private class  Array<E> {

        private E[] data;

        private int size;

        public Array(int capacity){
            data = (E[]) new Object[capacity];
            size = 0;
        }

        public Array(){
            this(10);
            size = 0;
        }

        public Array(E[] arr){
            data = (E[]) new Object[arr.length];
            for (int i = 0; i < arr.length; i++) {
                data[i] = arr[i];
            }
            size = arr.length;
        }

        public int getSize() {
            return size;
        }

        public int getCapacity(){
            return data.length;
        }

        public boolean isEmpty(){
            return size == 0;
        }

        public void addLast(E e){

            this.add(size, e);
        }

        public void addfirst(E e){
            add(0, e);
        }

        public void add(int index, E e){

            if(index < 0 || index > size) {
                throw new IllegalArgumentException("AddLast failed.Array is full");
            }
            if(size == data.length)
                resize(2 * data.length);

            for(int i = size - 1; i >= index; i--){
                data[i + 1] = data[i];
            }
            data[index] = e;
            size ++;
        }

        E get(int index){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Get fail. Index is illegal.");
            return data[index];
        }

        void set(int index, E e){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Get fail. Index is illegal.");
            data[index] = e;
        }

        public boolean contains(E e){
            for (int i = 0; i < size; i++) {
                if(data[i] == e){
                    return true;
                }
            }
            return false;
        }

        //查找不到元素e，返回-1
        public int find(E e){
            for (int i = 0; i < size; i++) {
                if(data[i].equals(e)){
                    return i;
                }
            }
            return -1;
        }

        public List<Integer> findAll(E e){
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if(data[i].equals(e)){
                    list.add(i);
                }
            }
            return list;
        }

        public E remove(int index){
            if(index < 0 || index >= size)
                throw new IllegalArgumentException("Remove fail. Index is illegal.");
            E ret = data[index];
            for(int i = index + 1; i < size; i ++){
                data[i - 1] = data[i];
            }
            size --;
            //手动复制loitering objects
            data[size] = null; //  loitering objects != memory leak

            if(size == data.length / 4 && data.length / 2 != 0){
                resize(data.length / 2);
            }
            return ret;
        }

        public E removeFirst(){
            return remove(0);
        }

        public E removeLast(){
            return remove(size - 1);
        }

        //从数组中删除元素e
        public boolean removeElement(E e){
            int index = find(e);
            if(index != -1){
                remove(index);
                return true;
            }
            return false;
        }

        public boolean removeAllElement(E e){
            if(find(e) == -1)
                return false;
            while(find(e) != -1){
                int index = find(e);
                remove(index);
            }
            return true;
        }

        public void swap(int i, int j){
            if(i < 0 || i >= size || j < 0 || j >= size){
                throw new IllegalArgumentException("Index is illegal.");
            }
            E t = data[i];
            data[i] = data[j];
            data[j] = t;
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
            res.append('[');
            for (int i = 0; i < size; i++) {
                res.append(data[i]);
                if(i != size - 1){
                    res.append(", ");
                }
            }
            res.append(']');
            return res.toString();
        }

        private void resize(int newCapacity){
            E[] newData = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    public class MaxHeap<E extends Comparable> {

        private Array<E> data;

        public MaxHeap(int capacity){
            data = new Array<>(capacity);
        }

        public MaxHeap(){
            data = new Array<>();
        }

        public MaxHeap(E[] arr){
            data = new Array<>(arr);
            for(int i = parent(arr.length - 1); i >= 0; i --){
                siftDown(i);
            }
        }

        //返回堆中的元素个数
        public int size(){
            return data.getSize();
        }

        //返回一个布尔值，表示堆中是否为空
        public boolean isEmpty(){
            return data.isEmpty();
        }

        //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
        private int parent(int index){
            if(index == 0){
                throw new IllegalArgumentException("index-0 doesn't have parent.");
            }
            return (index - 1) / 2;
        }

        //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
        private int leftChild(int index){
            return index * 2 + 1;
        }

        //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
        private int rightChild(int index){
            return index * 2 + 2;
        }

        //向堆中添加元素
        public void add(E e){
            data.addLast(e);
            siftUp(data.getSize() - 1);
        }

        private void siftUp(int k){

            while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
                data.swap(k, parent(k));
                k = parent(k);
            }
        }

        //看堆中的最大元素
        public E findMax(){
            if(isEmpty()){
                throw new IllegalArgumentException("Can not findMax when heap is empty");
            }
            return data.get(0);
        }

        //取出堆中最大元素
        public E extractMax(){

            E ret = findMax();

            data.swap(0, data.getSize() - 1);
            data.removeLast();
            siftDown(0);

            return ret;
        }

        private void siftDown(int k){

            while(leftChild(k) < data.getSize()){

                int j = leftChild(k);
                if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                    j = rightChild(k);
                    //data[j] 是leftChild 和 rightChild中的最大值
                }
                if(data.get(k).compareTo(data.get(j)) >= 0){
                    break;
                }
                else{
                    data.swap(k, j );
                    k = j;
                }
            }
        }

        //取出堆中的最大元素，并且替换成元素e
        public E replace(E e){

            E ret = findMax();
            data.set(0, e);
            siftDown(0);
            return ret;
        }

        //

        @Override
        public String toString(){
            return data.toString();
        }


    }


    public int[] sortArray(int[] nums) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int num : nums) {
            maxHeap.add(num);
        }
        int[] res = new int[nums.length];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = maxHeap.extractMax();
        }

        return res;
    }
}