package uniandes.dpoo.estructuras.logica;

// Hay un problema en las pruebas de acuerdo a John, aquellas que fallan si funcionan, pero toca iniciarlas por separado :,)
import java.util.HashMap;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre
 * arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y
 * arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas
 * como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos {
    private static final int Integer = 0;
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;
    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero
     * vacíos (tamaño 0)
     */
    public SandboxArreglos() {
        arregloEnteros = new int[] {};
        arregloCadenas = new String[] {};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo
     * tamaño que contiene copias de los valores del arreglo original
     * 
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros() {
        int[] nuevoArreglo = new int[this.arregloEnteros.length];
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            nuevoArreglo[i] = this.arregloEnteros[i];
        }
        return nuevoArreglo;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo
     * tamaño que contiene copias de los valores del arreglo original
     * 
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas() {
        String[] nuevoArreglo = new String[arregloCadenas.length];
        for (int i = 0; i < arregloCadenas.length; i++) {
            nuevoArreglo[i] = arregloCadenas[i];
        }
        return nuevoArreglo;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * 
     * @return
     */
    public int getCantidadEnteros() {
        return this.arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * 
     * @return
     */
    public int getCantidadCadenas() {
        return this.arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre
     * debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero(int entero) {
        int[] nuevoArreglo = new int[this.arregloEnteros.length + 1];
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            nuevoArreglo[i] = this.arregloEnteros[i];
        }
        nuevoArreglo[nuevoArreglo.length - 1] = entero;

        this.arregloEnteros = nuevoArreglo;

    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre
     * debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena(String cadena) {
        String[] nuevoArreglo = new String[arregloCadenas.length + 1];
        for (int i = 0; i < this.arregloCadenas.length; i++) {
            nuevoArreglo[i] = this.arregloCadenas[i];
        }
        nuevoArreglo[nuevoArreglo.length - 1] = cadena;
        this.arregloCadenas = nuevoArreglo;

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de
     * enteros
     * 
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero(int valor) {
        int contador = 0;
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (this.arregloEnteros[i] != valor) {
                contador++;
            }
        }
        int[] nuevoArreglo = new int[contador];
        int j = 0;

        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (this.arregloEnteros[i] != valor) {
                nuevoArreglo[j] = this.arregloEnteros[i];
                j++;
            }
        }
        this.arregloEnteros = nuevoArreglo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de
     * cadenas
     * 
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena(String cadena) {
        int contador = 0;
        for (String elemento : this.arregloCadenas) {
            if (elemento != cadena) {
                contador++;
            }
        }
        int j = 0;
        String[] nuevoArreglo = new String[contador];
        for (int i = 0; i < this.arregloCadenas.length; i++) {
            if (this.arregloCadenas[i] != cadena) {
                nuevoArreglo[j] = this.arregloCadenas[i];
                j++;
            }
        }

        this.arregloCadenas = nuevoArreglo;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero   El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo
     *                 aumentado. Si la posición es menor a 0, se inserta el valor
     *                 en la primera posición. Si la
     *                 posición es mayor que el tamaño del arreglo, se inserta el
     *                 valor en la última posición.
     */
    public void insertarEntero(int entero, int posicion) {
        int[] nuevoArreglo = new int[this.arregloEnteros.length + 1];
        int i = 0;
        int j = 0;
        if (posicion < 0) {
            posicion = 0;
        } else if (posicion > this.arregloEnteros.length) {
            posicion = this.arregloEnteros.length;
        }
        while (i < posicion) {
            nuevoArreglo[i] = arregloEnteros[i];
            i++;
            j++;

        }
        nuevoArreglo[i] = entero;
        i++;
        while (i < this.arregloEnteros.length + 1) {
            nuevoArreglo[i] = arregloEnteros[j];
            i++;
            j++;
        }
        this.arregloEnteros = nuevoArreglo;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * 
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si
     *                 el parámetro posicion no corresponde a ninguna posición del
     *                 arreglo de enteros, el método
     *                 no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < this.arregloEnteros.length) {
            int[] nuevoArreglo = new int[this.arregloEnteros.length - 1];
            int j = 0;
            for (int i = 0; i < this.arregloEnteros.length; i++) {
                if (i != posicion) {
                    nuevoArreglo[j] = this.arregloEnteros[i];
                    j++;
                }

            }
            this.arregloEnteros = nuevoArreglo;
        }
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del
     * parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería
     * quedar el entero 3.
     * 
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros(double[] valores) {
        int[] nuevoArreglo = new int[valores.length];
        int i = 0;
        for (double valor : valores) {
            nuevoArreglo[i] = (int) valor;
            i++;
        }
        this.arregloEnteros = nuevoArreglo;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los
     * objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * 
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas(Object[] objetos) {
        String[] nuevoArreglo = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) {
            nuevoArreglo[i] = objetos[i].toString();
        }
        this.arregloCadenas = nuevoArreglo;
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar
     * el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos() {
        int[] nuevoArreglo = new int[this.arregloEnteros.length];
        for (int i = 0; i < this.arregloEnteros.length; i += 1) {
            if (this.arregloEnteros[i] < 0) {
                nuevoArreglo[i] = this.arregloEnteros[i] * -1;
            } else {
                nuevoArreglo[i] = this.arregloEnteros[i];
            }
        }
        this.arregloEnteros = nuevoArreglo;

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados
     * de menor a mayor.
     */
    public void organizarEnteros() {
        for (int i = 1; i < this.arregloEnteros.length; i++) {
            int anterior = i - 1;
            int elemento = this.arregloEnteros[i];
            while (anterior >= 0 && elemento < this.arregloEnteros[anterior]) {
                this.arregloEnteros[anterior + 1] = this.arregloEnteros[anterior];
                anterior--;
            }
            this.arregloEnteros[anterior + 1] = elemento;
        }

    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados
     * lexicográficamente.
     */
    public void organizarCadenas() {
        for (int i = 1; i < this.arregloCadenas.length; i++) {
            int anterior = i - 1;
            String elemento = this.arregloCadenas[i];
            while (anterior >= 0 && elemento.compareTo(arregloCadenas[anterior]) < 0) {
                this.arregloCadenas[anterior + 1] = this.arregloCadenas[anterior];
                anterior--;
            }
            this.arregloCadenas[anterior + 1] = elemento;
        }

    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de
     * enteros
     * 
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones(int valor) {
        short contador = 0;
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (this.arregloEnteros[i] == valor) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo
     * de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * 
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones(String cadena) {
        int contador = 0;
        for (int i = 0; i < this.arregloCadenas.length; i++) {
            String arregloCadenasMinuscula = this.arregloCadenas[i].toLowerCase();
            if (arregloCadenasMinuscula.equalsIgnoreCase(cadena)) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se
     * recibe en el parámetro
     * 
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros
     *         en las que se encuentra el valor buscado. Si el valor no se
     *         encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero(int valor) {
        int contador = 0;
        for (int entero : this.arregloEnteros) {
            if (entero == valor) {
                contador++;
            }
        }

        int[] nuevoArreglo = new int[contador];
        int j = 0;
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (this.arregloEnteros[i] == valor) {
                nuevoArreglo[j] = i;
                j++;
            }
        }
        return nuevoArreglo;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * 
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el
     *         valor mínimo en el arreglo de enteros; en la segunda posición, debe
     *         estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un
     *         arreglo vacío.
     */
    public int[] calcularRangoEnteros() {
        int minimo = 999999;
        int maximo = -999999;
        boolean cambio = false;
        int[] nuevoArreglo = new int[0];
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (this.arregloEnteros[i] < minimo) {
                minimo = this.arregloEnteros[i];
                cambio = true;
            }
            if (this.arregloEnteros[i] > maximo) {
                maximo = this.arregloEnteros[i];
                cambio = true;
            }
        }
        if (cambio == true) {
            nuevoArreglo = new int[2];
            nuevoArreglo[0] = minimo;
            nuevoArreglo[1] = maximo;
        }

        return nuevoArreglo;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve
     * como un mapa donde las llaves son los valores del arreglo y los valores son
     * la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * 
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma() {
        HashMap<Integer, Integer> Mapa = new HashMap<>();
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            if (Mapa.containsKey(this.arregloEnteros[i])) {
                int valor = Mapa.get(this.arregloEnteros[i]);
                Mapa.put(this.arregloEnteros[i], valor + 1);
            } else {
                Mapa.put(this.arregloEnteros[i], 1);
            }
        }
        return Mapa;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * 
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos() {
        int[] enterosRepetidos = new int[this.arregloEnteros.length];
        int indiceRepetidos = 0;
        int contador = 0;
        // Se busca si un elemento ya se ha identificado como repetido
        for (int i = 0; i < this.arregloEnteros.length; i++) {
            boolean repetido = false;
            for (int j = 0; j < indiceRepetidos; j++) {
                if (this.arregloEnteros[i] == enterosRepetidos[j]) {
                    repetido = true;
                }

            }
            // Sino ha sido identificado como repetido, se cuenta cuantas veces se repite en
            // el arreglo
            if (repetido == false) {
                int contador2 = 0;
                for (int k = 0; k < this.arregloEnteros.length; k++) {
                    if (this.arregloEnteros[i] == this.arregloEnteros[k]) {
                        contador2++;
                    }
                }
                // Si se repite más de una vez, se le suma al contador y se añade al arreglo de
                // repetidos
                if (contador2 > 1) {
                    enterosRepetidos[indiceRepetidos] = this.arregloEnteros[i];
                    contador++;
                    indiceRepetidos++;
                }
            }
        }
        return contador;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son
     * iguales, es decir que contienen los mismos elementos exactamente en el mismo
     * orden.
     * 
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros(int[] otroArreglo) {
        int[] nuevoArreglo = getCopiaEnteros();
        int contador = 0;
        if (nuevoArreglo.length == otroArreglo.length) {
            for (int i = 0; i < nuevoArreglo.length; i++) {
                if (nuevoArreglo[i] == otroArreglo[i]) {
                    contador++;
                }
            }

        }

        if (contador == nuevoArreglo.length && (otroArreglo.length != 0 && nuevoArreglo.length != 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que
     * tengan los mismos elementos, aunque podría ser en otro orden.
     * 
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros(int[] otroArreglo) {
        if (this.arregloEnteros.length != 0 || otroArreglo.length != 0) {
            int[] nuevoArreglo = getCopiaEnteros();
            for (int i = 1; i < nuevoArreglo.length; i++) {
                int anterior = i - 1;
                int elemento = nuevoArreglo[i];
                while (anterior >= 0 && elemento < nuevoArreglo[anterior]) {
                    nuevoArreglo[anterior + 1] = nuevoArreglo[anterior];
                    anterior--;
                }
                nuevoArreglo[anterior + 1] = elemento;
            }
            // Organizar el otro arreglo
            for (int i = 1; i < otroArreglo.length; i++) {
                int anterior = i - 1;
                int elemento = otroArreglo[i];
                while (anterior >= 0 && elemento < otroArreglo[anterior]) {
                    otroArreglo[anterior + 1] = otroArreglo[anterior];
                    anterior--;
                }
                otroArreglo[anterior + 1] = elemento;
            }
            int contador = 0;
            if (nuevoArreglo.length == otroArreglo.length) {
                for (int i = 0; i < nuevoArreglo.length; i++) {
                    if (nuevoArreglo[i] == otroArreglo[i]) {
                        contador++;
                    }
                }
            }

            if (contador == nuevoArreglo.length && (otroArreglo.length != 0 && nuevoArreglo.length != 0)) {
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores
     * generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando
     * Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * 
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo   El valor mínimo para los números generados
     * @param maximo   El valor máximo para los números generados
     */
    public void generarEnteros(int cantidad, int minimo, int maximo) {
        int[] nuevaLista = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            nuevaLista[i] = minimo + (int) (Math.random() * (maximo - minimo + 1));
        }
        this.arregloEnteros = nuevaLista;
    }

}
