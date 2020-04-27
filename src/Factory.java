/*	
*
*@author Juan Pablo pineda 19087
*@author Eduardo Ramírez 19946
*/

public class Factory<K extends Comparable<K>,V>{
	/**
	//Pre: Haber elegido un traductor 
	//Post: Intancia de tipo de tranductor seleccionado
	 * @param tipoTranslator   Tipo de translator a instanciar
	*/
	public TranslatorInterface<K, V> getTranslator(int tipoTranslator){
		if (tipoTranslator == 1) { //Es un hash map
			return new Hashing<K,V>();
		} else { //Es un splay tree
			return new MapSplayTree<K,V>();
		}
	}
}