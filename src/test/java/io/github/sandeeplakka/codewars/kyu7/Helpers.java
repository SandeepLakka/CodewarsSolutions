package io.github.sandeeplakka.codewars.kyu7;

//helper and support code
public class Helpers {
    public static <T> Node<T> listFromArray(T... arr) {
        Node<T> pointer = new Node<>(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            T val = arr[i];
            Node<T> curNode = new Node<>(val);
            Node<T> last = pointer;
            while (last.next != null) {
                last = last.next;
            }
            last.next = curNode;
        }
        return pointer;
    }
}
