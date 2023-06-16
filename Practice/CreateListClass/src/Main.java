public class Main {
    public static void main(String[] args) {

        MyList<Integer> list = new MyList<>();

        System.out.println("List Status : " + (list.isEmpty() ? "Empty" : "Full"));
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(20);
        list.add(50);
        list.add(60);
        list.add(70);

        System.out.println("List Status : " + (list.isEmpty() ? "Empty" : "Full"));

        // get first index
        System.out.println("Index : " + list.indexOf(20));

        // If can not find, return -1
        System.out.println("Index :" + list.indexOf(100));

        // get last index
        System.out.println("Index : " + list.lastIndexOf(20));

        // return to List as Object[] array
        Object[] arr = list.toArray();
        System.out.println("First Elements in Object List :" + arr[0]);

        // created a subList as List value type.
        MyList<Integer> subList = list.subList(0, 3);
        System.out.println(subList.toString());

        // searched value in list
        System.out.println("20 value in list ?: " + list.contains(20));
        System.out.println("120 value int list ?: " + list.contains(120));

        // clear whole list and return default
        list.clear();
        System.out.println(list.toString());
    }
}