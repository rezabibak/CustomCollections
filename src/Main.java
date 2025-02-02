import java.util.Iterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        IterableCustom<Integer> number = new IterableCustom<>();
        number.add(1);
        number.add(2);
        number.add(100);
        number.add(4);
        number.add(32);
        number.add(1);
        number.add(2);
        number.add(100);
        number.add(4);
        number.remove(2);
        number.add(32);
        number.add(1);

        for (Object i : number) {
            System.out.println(i);
        }
        System.out.println("-----------------------------------------------------------");

        Iterator<Integer> iteratorNumber = number.iterator();
        while (iteratorNumber.hasNext()) {
            System.out.println(iteratorNumber.next());
            //remove all number
            iteratorNumber.remove();
        }

        System.out.println("-----------------------------------------------------------");


        IterableCustom<String> name = new IterableCustom<>();
        name.add("reza");
        name.add("Ali");
        name.add("mohamed");
        name.add("sina");


        for (String n : name) {
            System.out.println(n);
            for (String n2 : name) {
                System.out.println(n2);
            }
        }
        System.out.println("-----------------------------------------------------------");

        Iterator<String> iteratorName = name.iterator();
        while (iteratorName.hasNext()) {
            System.out.println(iteratorName.next());
        }

        System.out.println("=============================== test remove by value");
        name.remove("Ali");
        System.out.println("=============================== end test remove by value");
        for (String n : name) {
            System.out.println(n);
        }
    }
}
