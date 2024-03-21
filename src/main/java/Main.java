public class Main {

    public void main(String[] args) {
        ListaSimple<String> lista = new ListaSimple<>();
        lista.insertAtEnd("Hello");
        lista.insertAtEnd("World");

        ListaSimple<String>.Iterador iterador = lista.getIterador();
        while (iterador.hasNext()) {
            String valor = iterador.next();
            System.out.println(valor);
        }
    }
}