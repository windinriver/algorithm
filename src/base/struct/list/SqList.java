package base.struct.list;

//线性表--顺序表
//01 交换，指向区间
//02 移动
public class SqList {

    //定义顺序表的默认容量,扩容操作
    private static int DEFAULT_SIZE = 50;

    private int data[]; //存放数据
    private int length; //存放当前数组长度


    //----------------------对数据的操作--------------------------

    //01-初始化长度为n个数据的顺序表
    public void createList(int data[], int n) {
        for (int i = 0 ; i < n; i++) {
            this.data[i] = data[i];
        }
        this.length = n;
    }

    //02-判断线性表是否为空表
    public boolean isEmpty() {
        return length == 0;
    }

    //03-打印线性表
    public void printList() {

        for (int i = 0; i < length; i++) {
            System.out.print(data[i] + ", ");
        }
        System.out.println("----------------");
    }

    //04-获取某个数据元素值
    public int getElem(int i) {
        return data[i];
    }

    //05-查找元素
    public int locateElem(int e) {
        for (int i = 0 ; i < length; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    //06-在i位置插入元素e
    public boolean insertElem(int i, int e) {
        if (i < 0 || i > DEFAULT_SIZE -1) {
            return false;
        }
        //将i位置开始的元素往后移动
        for (int j = length - 1; j >= i; j--) {
            data[j+1] = data[j];
        }
        //i位置元素赋值
        data[i] = e;
        length++;
        return true;
    }

    //07-删除第i个元素
    public boolean deleteElem(int i) {
        if (i < 0 || i > DEFAULT_SIZE -1) {
            return false;
        }
        //将i+1开始的元素往前复制就行了
        for (int j = i + 1; j < length ; j++) {
            data[j-1] = data[j];
        }
        length--;
        return true;
    }
    //--------------------------------顺序表应用示例
    //01-删除所有值等于x的元素
    //解法一思路: 空间重用, （双指针）用k记录新表位置,i扫描数组
    public void delNode(int x) {
        int k = 0;
        for (int i = 0 ; i < length; i++) {
            if (data[i]!= x) {
                data[k] = data[i];
                k++;
            }
        }
        length = k;
    }

    //解法二思路: 空间重用, （双指针）用k记录有多少个值等于x,i扫描数组,将元素往前移k个位置
    public void delNode2(int x) {
        int k = 0;
        for(int i = 0; i < length; i++) {
            if(data[i] != x) {
                data[i - k] = data[i];
            } else {
                k++;
            }
        }
        length-=k;
    }

    //02-以第一个元素为基准，将所有小与等于基准的元素移动到其前面
    //解法一思路：以第一个元素为基准，从右向左找一个小于等于基准的元素x，从左向右找一个大于基准的元素y，将两者交换,直到全部找完
    public void partition1() {
        if (length==0) {
            return;
        }
        int i = 0, j = length -1;
        //基准
        int privor = data[0];
        //双指针
        while (i < j) {
            //01从右向左扫描，找到一个小于等于privor的元素// 01和02不能交换顺序
            while (i < j && data[j] > privor) {
                j--;
            }

            //02从左向右找一个大于基准的元素y
            while (i < j && data[i] <= privor) {
                i++;
            }

           if (i < j) {
               //交换
               swap(data, i , j);
           }

        }
        //data[0]和data[i]交换
        swap(data, 0 , i);
    }

    private void swap(int[] data, int i , int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    //解法思路二: 快排思想:保存基准值，从右向左找一个小于等于基准的元素x放到基准的位置,从左向右找一个大于基准的元素y放到上一个找到的位置
    // ,最后将临时值赋值回去
    public void partition2() {
        if (length==0) {
            return;
        }
        int privor = data[0];
         int i = 0, j = length -1;
         while (i < j) {
             while (i < j && data[j] > privor) {
                 j--;
             }
             data[i] = data[j];

             //从左向右找一个大于基准的元素y
             while (i < j && data[i] <= privor) {
                 i++;
             }
             data[j] = data[i];
         }
         data[i] = privor;
    }

    //03将所有奇数移动到偶数前面
    //解法一:和02解法一一致
    //解法二: 用i标志奇数区间位置，从左向右扫描, 奇数则和当前奇数区间指针位置进行交换
    public void move() {
        int i = -1;
        for (int j = 0 ; j < length;  j++) {
            if (data[j] % 2 == 1) {
                i++;
                if (i != j) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    //实现两个有序数组合并为一个有序数组
    //思路：两个指针指向合并的数组，对比两个指针指向的元素大小，较小的放入新数组
    public static SqList hbSortList(SqList list1, SqList list2) {
        int i = 0, j = 0;
        int k = 0;
        SqList newList = new SqList();
        while (i < list1.length && j < list2.length) {
            if (list1.getElem(i) < list2.getElem(j)) {
                newList.data[k] = list1.getElem(i);
                i++;
            } else {
                newList.data[k] = list2.getElem(j);
                j++;
            }
            k++;
        }
        //剩下的接到数组里边
        while (i < list1.length) {
            newList.data[k++] = list1.getElem(i);
            i++;
        }
        while (j < list2.length) {
            newList.data[k++] = list2.getElem(j);
            j++;
        }
        newList.length = k;
        return newList;

    }

    //-----------------------构造,get and set
    public SqList() {
        data = new int[DEFAULT_SIZE];
        length = 0;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
