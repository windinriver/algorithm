package base.struct.list;

import java.util.Arrays;

/**
 * 2022/08/09初始化
 */
public class YwfArrayList<E> {

    private  static final int DEFAULT_CAPACITY = 10;

    //EMPTY_ELEMNTDATA 用来记录第一次初始化的大小用的
    private static final Object[] EMPTY_ELEMNTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    //懒加载,第一次add时初始化为DEAULT_CAPACITY大小
    transient Object[] elementData;

    private int size;

    public YwfArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public YwfArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity ==0 ){
            this.elementData = EMPTY_ELEMNTDATA;
        }
    }

    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    /**
     * 确保有足够容量
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        //如果需要的容量比原有的大，就需要扩容了
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        //每次扩容1.5倍
        int newCapacity = oldCapacity + (oldCapacity>>1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public E get(int i) {
        return (E)elementData[i];
    }
}
