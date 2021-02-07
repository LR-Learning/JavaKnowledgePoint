package Test1;

import java.util.Objects;

/**
 * @Author: LR
 * @Descriprition: 自动装箱拆箱问题
 * @Date: Created in 17:35 2021/2/3
 * @Modified By:
 **/
public class Demo1 {
    public static void main(String[] args) {
        /*
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2); // true
        System.out.println(i3 == i4); // false

        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
        // 当 "=="运算符的两个操作数都是 包装器类型的引用，则是比较指向的是否是同一个对象，而如果其中有一个操作数是表达式（即包含算术运算）则比较的是数值（即会触发自动拆箱的过程）
        // 另外，对于包装器类型，equals方法并不会进行类型转换。
        System.out.println(c==d); //true
        System.out.println(e==f); //false
        System.out.println(c==(a+b)); // true   自动拆箱 调用intValue
        System.out.println(c.equals(a+b)); // true
        System.out.println(g==(a+b)); // true
        System.out.println(g.equals(a+b)); // false
        System.out.println(g.equals(a+h)); // true


        String a = new String("abc");
        String b = new String("abc");
        String aa = "a";
        String bb = "a";

        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // true   String 中的equals方法被重写过，比较的是对象的值
        System.out.println(aa == bb); // true
        System.out.println(aa.equals(bb)); // true
        */

        Person p1 = new Person("a", 10);
        Person p2 = new Person("a", 10);

        System.out.println(p1.equals(p2));
    }

    private static class Person{
        String name;
        int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        // 覆盖equals方法
        public boolean equals(Object o) {
            //如果是同一个对象返回true，反之返回false
            if (this == o) return true;
            // 如果为空或类型不相同则返回false
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age && name.equals(person.name);
        }


    }
}
