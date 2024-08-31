package uniandes.dpoo.estructuras.logica;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
        List<String> lista= new ArrayList<String>();
        for (String key:this.mapaCadenas.keySet()) {
        	lista.add(this.mapaCadenas.get(key));
        }
        lista.sort(null);
        return lista;
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	List<String> lista= new ArrayList<String>();
        for (String key:this.mapaCadenas.keySet()) {
        	lista.add(key);
        }
        Collections.sort(lista,Collections.reverseOrder());
        return lista;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	boolean cambio=false;
    	String menor="zzzzzzz";
        if (this.mapaCadenas.size()!=0) {
        	for (String llave:this.mapaCadenas.keySet()) {
        		if (llave.compareTo(menor)<0) {
        			menor=llave;
        			cambio=true;
        		}
        	}
        	
        }
        if(cambio==true) {
        	return menor;
        }
        else {
        	return null;
        }
    	
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	boolean cambio=false;
    	String mayor="AAAAAAAAAA";
        if (this.mapaCadenas.size()!=0) {
        	for (String llave:this.mapaCadenas.keySet()) {
        		if (llave.compareTo(mayor)>0) {
        			mayor=llave;
        			cambio=true;
        		}
        	}
        	
        }
        if(cambio==true) {
        	return mayor;
        }
        else {
        	return null;
        }
    	
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	Collection<String> coleccion=new ArrayList<String>();
    	for(String llave:this.mapaCadenas.keySet()) {
    		llave=llave.toUpperCase();
    		coleccion.add(llave);
    	}
        return coleccion;
        }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	Map<String,Integer> cantidad=new HashMap<String,Integer>();
    	for (String valor:mapaCadenas.values()) {
    		if (cantidad.containsKey(valor)){
    			cantidad.put(valor, cantidad.get(valor)+1);
    		}
    		else {
    			cantidad.put(valor, 1);
    		}
    	}
    	return cantidad.size();
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	String nueva=new String();
    	for (int i=cadena.length();i>0;i--) {
    		nueva=nueva.concat(cadena.substring(i-1, i));
    	}
    	this.mapaCadenas.put(nueva, cadena);
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	if (this.mapaCadenas.containsKey(llave)==true) {
    	this.mapaCadenas.remove(llave);
    	}
    	
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	for (Map.Entry<String, String> elemento:this.mapaCadenas.entrySet()) {
    		if (elemento.getValue()==valor){
    			this.mapaCadenas.remove(elemento.getKey());
    		}
    	}

    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	
    	
    	Map<String,String> mapa= new HashMap<>();     
    	for (Object cadena:objetos) {
    		String nueva=new String();
    		String cadena2=cadena.toString();
    		for (int i=cadena2.length();i>0;i--) {
        		nueva=nueva.concat(cadena2.substring(i-1, i));
        	}
    		mapa.put(nueva, cadena2);
    	}
    	this.mapaCadenas=mapa;
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	Map<String,String> nuevoMapa = new HashMap<>();
    	for(Map.Entry<String, String> entrada:this.mapaCadenas.entrySet()) {
    		String llave=entrada.getKey();
    		String valor=entrada.getValue();
    		llave=llave.toUpperCase();
    		nuevoMapa.put(llave, valor);
;    	}
    	this.mapaCadenas=nuevoMapa;

    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	for (String elemento:otroArreglo) {
        	if (this.mapaCadenas.containsValue(elemento)==false){
        		return false;
        	}
    	}
    	return true;
    }
    	
    

}
