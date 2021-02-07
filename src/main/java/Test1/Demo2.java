package Test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 * @Author: LR
 * @Descriprition: Comparable和Comparator的区别
 * @Date: Created in 14:19 2021/2/7
 * @Modified By:
 **/
public class Demo2 {
    public static void main(String[] args) {
        // Comparator定制排序
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        System.out.println("原始数组");
        System.out.println(arrayList);

        System.out.println("反转后");
        Collections.reverse(arrayList); // 反转
        System.out.println(arrayList);

        System.out.println("自然排序");
        Collections.sort(arrayList); // 按自然的升序排序
        System.out.println(arrayList);

        // 定制排序的用法
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        System.out.println("定制排序后的");
        System.out.println(arrayList);
    }
}
