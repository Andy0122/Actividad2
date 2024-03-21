import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ListaSimpleTest {

    @Test
    public void testInsertarLista() {
        ListaSimple<Integer> lista1 = new ListaSimple<>();
        lista1.insertAtEnd(1);
        lista1.insertAtEnd(2);

        ListaSimple<Integer> lista2 = new ListaSimple<>();
        lista2.insertAtEnd(3);
        lista2.insertAtEnd(4);

        lista1.insertarLista(lista2);

        assertEquals(4, lista1.size());
    }

    @Test
    public void testSubLista() {
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.insertAtEnd(1);
        lista.insertAtEnd(2);
        lista.insertAtEnd(3);
        lista.insertAtEnd(4);
        lista.insertAtEnd(5);

        ListaSimple<Integer> sublista = lista.SubLista(1, 3);

        assertEquals(3, sublista.size());
        assertTrue(sublista.contains(2) && sublista.contains(3) && sublista.contains(4));
    }

    @Test
    public void testInvertirLista() {
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.insertAtEnd(1);
        lista.insertAtEnd(2);
        lista.insertAtEnd(3);

        lista.invertir();

        assertEquals(Integer.valueOf(3), lista.get(0));
        assertEquals(Integer.valueOf(2), lista.get(1));
        assertEquals(Integer.valueOf(1), lista.get(2));
    }
    @Test
    public void testInsertarListaConStrings() {
        ListaSimple<String> lista1 = new ListaSimple<>();
        lista1.insertAtEnd("uno");
        lista1.insertAtEnd("dos");

        ListaSimple<String> lista2 = new ListaSimple<>();
        lista2.insertAtEnd("tres");
        lista2.insertAtEnd("cuatro");

        lista1.insertarLista(lista2);

        assertEquals(4, lista1.size());
        assertEquals("uno", lista1.get(0));
        assertEquals("cuatro", lista1.get(3));
    }

    @Test
    public void testSubListaConStrings() {
        ListaSimple<String> lista = new ListaSimple<>();
        lista.insertAtEnd("primero");
        lista.insertAtEnd("segundo");
        lista.insertAtEnd("tercero");
        lista.insertAtEnd("cuarto");
        lista.insertAtEnd("quinto");

        ListaSimple<String> sublista = lista.SubLista(1, 3);

        assertEquals(3, sublista.size());
        assertEquals("segundo", sublista.get(0));
        assertEquals("cuarto", sublista.get(2));
    }

    @Test
    public void testInvertirListaConStrings() {
        ListaSimple<String> lista = new ListaSimple<>();
        lista.insertAtEnd("a");
        lista.insertAtEnd("b");
        lista.insertAtEnd("c");

        lista.invertir();

        assertEquals("c", lista.get(0));
        assertEquals("b", lista.get(1));
        assertEquals("a", lista.get(2));
    }
    @Test
    public void testInsertarListaConFloats() {
        ListaSimple<Float> lista1 = new ListaSimple<>();
        lista1.insertAtEnd(1.1f);
        lista1.insertAtEnd(2.2f);

        ListaSimple<Float> lista2 = new ListaSimple<>();
        lista2.insertAtEnd(3.3f);
        lista2.insertAtEnd(4.4f);

        lista1.insertarLista(lista2);

        assertEquals(4, lista1.size());
        assertEquals(1.1f, lista1.get(0), 0.001);
        assertEquals(4.4f, lista1.get(3), 0.001);
    }

    @Test
    public void testSubListaConFloats() {
        ListaSimple<Float> lista = new ListaSimple<>();
        lista.insertAtEnd(1.1f);
        lista.insertAtEnd(2.2f);
        lista.insertAtEnd(3.3f);
        lista.insertAtEnd(4.4f);
        lista.insertAtEnd(5.5f);

        ListaSimple<Float> sublista = lista.SubLista(1, 3);

        assertEquals(3, sublista.size());
        assertEquals(2.2f, sublista.get(0), 0.001);
        assertEquals(4.4f, sublista.get(2), 0.001);
    }

    @Test
    public void testInvertirListaConFloats() {
        ListaSimple<Float> lista = new ListaSimple<>();
        lista.insertAtEnd(1.1f);
        lista.insertAtEnd(2.2f);
        lista.insertAtEnd(3.3f);

        lista.invertir();

        assertEquals(3.3f, lista.get(0), 0.001);
        assertEquals(2.2f, lista.get(1), 0.001);
        assertEquals(1.1f, lista.get(2), 0.001);
    }
}
