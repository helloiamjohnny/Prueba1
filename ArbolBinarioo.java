public class ArbolBinario {
    public static void main(String[] args) {
        Nodo abb = new  Nodo(100);
        abb.agregar(5);
        abb.agregar(3);
        abb.agregar(9);
        abb.agregar(1);
        abb.agregar(8);
        abb.agregar(7);
        abb.agregar(2);
        abb.agregar(4);
        abb.agregar(0);
        abb.agregar(6);

        System.out.println("Arbol original");
        abb.ImprimirInOrder();
        abb.eliminar(5);
        abb.eliminar(7);
        abb.eliminar(6);
        System.out.println("Arbol despues de la eliminacion");
        abb.ImprimirInOrder();
       
        	

    }
}
