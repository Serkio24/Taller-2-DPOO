package uniandes.dpoo.estructuras.logica;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
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
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	int[] copia = new int[arregloEnteros.length];
    	
    	for (int i =0; i < arregloEnteros.length; i++)
    	{
    		copia[i] = arregloEnteros[i];
    	}
    	
        return copia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	String[] copia = new String[arregloCadenas.length];
    	
    	for (int i = 0; i < arregloCadenas.length; i++)
    	{
    		copia[i] = arregloCadenas[i];
    	}
        return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
    	int[] arregloEActualizado = new int[arregloEnteros.length+1];
    	
    	for (int i = 0; i < arregloEActualizado.length; i++)
    	{
    		if (i < arregloEnteros.length)
    		{
    			arregloEActualizado[i] = arregloEnteros[i];
    		}
    		else
    		{
    			arregloEActualizado[i] = entero;
    		}
    	}
    	arregloEnteros = arregloEActualizado;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] arregloSActualizado = new String[arregloCadenas.length+1];
    	
    	for (int i = 0; i < arregloSActualizado.length; i++)
    	{
    		if (i < arregloCadenas.length)
    		{
    			arregloSActualizado[i] = arregloCadenas[i];
    		}
    		else
    		{
    			arregloSActualizado[i] = cadena;
    		}
    	}
    	arregloCadenas = arregloSActualizado;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	int tamanyo = 0;
    	for (int i = 0; i < arregloEnteros.length; i++)
    	{
			if (arregloEnteros[i] == valor)
			{
				tamanyo++;
			}
		}
    	
    	int[] arregloErased = new int[arregloEnteros.length-tamanyo];
    	int contador = 0;
    	for (int elem: arregloEnteros) 
    	{
			if(elem != valor)
			{
				arregloErased[contador] = elem;
				contador++;
			}
		}
    	arregloEnteros = arregloErased;

    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	int tamanyo = 0;
    	for (int i = 0; i < arregloCadenas.length; i++)
    	{
			if (arregloCadenas[i].equals(cadena))
			{
				tamanyo++;
			}
		}
    	int contador = 0;
    	String[] arregloErased = new String[arregloCadenas.length-tamanyo];
    	for (String elem: arregloCadenas)
    	{
    		if (!elem.equals(cadena))
    		{
    			arregloErased[contador] = elem;
    			contador++;
    		}
    	}
    	arregloCadenas = arregloErased;
   
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	int[] arregloInsertado = new int[arregloEnteros.length+1];
    	
    	if (posicion <= 0)
    	{
    		arregloInsertado[0] = entero;
    		int contador = 1;
    		for (int num: arregloEnteros)
    		{
    			arregloInsertado[contador] = num;
    			contador++;
    		}
    	}
    	
    	else {if(posicion >= arregloEnteros.length)
    		{
    			for (int i = 0; i < arregloEnteros.length; i++)
    			{
					arregloInsertado[i] = arregloEnteros[i];
				}
    			arregloInsertado[arregloEnteros.length] = entero;	
    		}
    	else
    		{
    			int contador = 0;
    			for (int i = 0; i < arregloInsertado.length; i++) 
    			{
					if (i == posicion)
					{
						arregloInsertado[i] = entero;
					}
					else
					{
						arregloInsertado[i] = arregloEnteros[contador];
						contador++;
					}
				}
    		}
    		}    	
    	arregloEnteros = arregloInsertado;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	int[] arregloErased = new int[arregloEnteros.length-1];
    	int contador = 0;
    	if (posicion < 0 || posicion >= arregloEnteros.length)
    	{
    		return;
    	}
    	if (posicion >= 0 && posicion < arregloEnteros.length)
    	{
    		for (int i = 0; i < arregloEnteros.length; i++) {
    	        if (i != posicion) 
    	        { 
    	            arregloErased[contador] = arregloEnteros[i];
    	            contador++;
    	        }
    	    }
	    	arregloEnteros = arregloErased;
    	}

    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	int[] arregloReiniciado = new int[valores.length];
    	for (int i = 0; i < valores.length; i++)
    	{
			arregloReiniciado[i] = (int) valores[i];
		}
    	this.arregloEnteros = arregloReiniciado;
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	String[] arregloReiniciadoC = new String[objetos.length];
    	for (int i = 0; i < objetos.length; i++) 
    	{
			arregloReiniciadoC[i] = objetos[i].toString();
		}
    	this.arregloCadenas = arregloReiniciadoC;

    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	for (int i = 0; i < arregloEnteros.length; i++) 
    	{
    		if (arregloEnteros[i] < 0)
    		{
    			arregloEnteros[i] = arregloEnteros[i]* -1;
    		}
		}
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	Arrays.sort(arregloEnteros);
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	Arrays.sort(arregloCadenas);
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	int contador = 0;
    	
    	for (int elem: arregloEnteros)
    	{
    		if (elem == valor)
    		{
    			contador++;
    		}
    	}
        return contador;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	int contador = 0;
    	for (String elem: arregloCadenas)
    	{
    		if (elem.equalsIgnoreCase(cadena))
    		{
    			contador++;
    		}
    	}
        return contador;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	int contador = 0;
    	for (int i = 0; i < arregloEnteros.length; i++) 
    	{
			if (valor == arregloEnteros[i])
			{
				contador++;
			}
		}
    	
    	int[] pos = new int[contador];
    	int contDos = 0;
    	for (int i = 0; i < arregloEnteros.length; i++)
    	{
    		if (valor == arregloEnteros[i])
			{
    			pos[contDos] = i;
				contDos++;
			}
		}
        return pos;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	if (arregloEnteros.length == 0)
    	{
    		int[] retorno = new int[]{};
    		return retorno;
    	}
    	
    	int[] rango = new int[2];
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	for (int elem: arregloEnteros) 
    	{
			if (elem < min)
			{
				min = elem;
			}
			if (elem > max)
			{
				max = elem;
			}
		}
    	rango[0] = min;
    	rango[1] = max;
   
        return rango;
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> histograma = new HashMap<>();
    	
    	for (int elem: arregloEnteros)
    	{
    		histograma.put(elem, (histograma.getOrDefault(elem, 0)+1));
    	}
        return histograma;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	HashMap<Integer, Integer> histograma = calcularHistograma();
    	int contador = 0;
    	
    	for (int elem: histograma.values())
    	{
    		if (elem > 1)
    		{
    			contador++;
    		}
    	}
        return contador;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	boolean centinela = true;
    	int contador = 0;
    	
    	if (arregloEnteros.length == 0 || otroArreglo.length == 0)
    	{
    		return false;
    	}
    	while (centinela && (contador < arregloEnteros.length || contador < otroArreglo.length))
    	{
			if (arregloEnteros[contador] != otroArreglo[contador])
			{
				centinela = false;
			}
			contador++;
		}
        return centinela;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	if (otroArreglo.length == 0 && arregloEnteros.length == 0)
    	{
    		return true;
    	}
    	boolean maybe = compararArregloEnteros(otroArreglo);
    	if (maybe == true)
    	{
    		return maybe;
    	}
    	organizarEnteros();
    	int[] Arreglo2Ord = Arrays.copyOf(otroArreglo, otroArreglo.length);
    
    	Arrays.sort(Arreglo2Ord);
    	
    	boolean retorno = compararArregloEnteros(otroArreglo);
    	return retorno;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	int[] arregloRandom = new int[cantidad];
    	
    	for (int i = 0; i < arregloRandom.length; i++) 
    	{
			arregloRandom[i] =  minimo + (int) (Math.random() * (maximo - minimo + 1));
		}
    	arregloEnteros = arregloRandom;
    }

}
