import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaSimple<T> {

    public static class Node<T> {
        public T valor;
        public Node<T> next = null;
        public Node(T valor) {
            this.valor = valor;
        }
    }
    private Node<T> head = null;
    private int size = 0;
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        return this.size;
    }
    public boolean contains(T element) {
        Node<T> current = head; // Comienza en la cabeza de la lista
        while (current != null) { // Recorre la lista hasta el final
            if (current.valor.equals(element)) { // Comprueba si el valor del nodo actual es igual al elemento buscado
                return true; // Elemento encontrado
            }
            current = current.next; // Avanza al siguiente nodo
        }
        return false; // Elemento no encontrado
    }
    public T get(int index) {
        if (index < 0) {
            return null;
        }
        Node<T> current = head;
        int count = 0; // Iniciar contador de posición
        while (current != null) {
            if (count == index) { // Verifica si se ha alcanzado el índice deseado
                return current.valor; // Retorna el valor del nodo actual
            }
            count++; // Incrementa el contador
            current = current.next; // Avanza al siguiente nodo
        }
        // Si el índice es mayor que el número de elementos en la lista
        return null;
    }


    public void insert(T element) {
        Node<T> nuevo = new Node<T>(element);
        if (isEmpty()) {
            head = nuevo;
        } else {
            nuevo.next = head;
            head = nuevo;
        }
        this.size++;
    }
    public void insertAtEnd(T element) {
        if (isEmpty()) {
            this.insert(element);
            return;
        } else {
            Node<T> nuevo = new Node<>(element);
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = nuevo;
        }
        this.size++;
    }
    public void deleteLast() {
        if (isEmpty()) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        this.size--;
    }
    public void deleteFirst(){
        if (isEmpty()){
            return;
        }else {
            head = head.next;
        }
        this.size--;
    }
    public void printList() {
        System.out.print("Lista:[");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.valor);
            if (temp.next != null) {
                System.out.print(", ");
            }
            temp = temp.next;
        }
        System.out.println("]");
    }

    public void insertarLista(ListaSimple<T> otraLista) {
        if (otraLista.head == null) return;  // Si la otra lista está vacía, no hacer nada.

        if (this.head == null) {
            this.head = otraLista.head;  // Si la lista original está vacía, simplemente apuntar a la cabeza de la otra lista.
        } else {
            Node temp = this.head;
            while (temp.next != null) {  // Recorre hasta el final de la lista original
                temp = temp.next;
            }
            temp.next = otraLista.head;  // Enlazar el final de la lista original con el comienzo de la otra lista
        }
        this.size = this.size + otraLista.size();
    }
    public ListaSimple<T> SubLista(int inicio, int tamaño) {
        ListaSimple<T> sublista = new ListaSimple<>();
        Node<T> actual = this.head;
        int index = 0;

        // Avanzar hasta la posición de inicio
        while (actual != null && index < inicio) {
            actual = actual.next;
            index++;
        }

        // Copiar los elementos al tamaño especificado en la nueva lista
        while (actual != null && tamaño > 0) {
            sublista.insertAtEnd(actual.valor); // En esta linea esta el problema
            actual = actual.next;
            tamaño--;
        }

        return sublista;
    }
    public void invertir() {
        Node<T> previo = null;
        Node<T> actual = head;
        Node<T> siguiente = null;

        while (actual != null) {
            siguiente = actual.next; // Guarda el siguiente nodo
            actual.next = previo; // Invierte el enlace del nodo actual
            previo = actual; // Mueve previo al nodo actual
            actual = siguiente; // Avanza al siguiente nodo
        }
        head = previo; // Actualiza la cabeza para apuntar al nuevo primer nodo
    }
    /* Interfaz Iterador definida dentro de ListaSimple
    public interface Iterador {
        boolean hasNext();
        T next();
    }

    // Clase ListaIterador interna que implementa la interfaz Iterador
    private class ListaIterador implements Iterador {
        private Node<T> current;

        private ListaIterador() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            T valor = current.valor;
            current = current.next;
            return valor;
        }
    }

    public Iterador getIterador() {
        return new ListaIterador();
    }*/
}




