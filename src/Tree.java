public interface Tree<E>{

	public boolean contains (String key);
	
	/**
	pre: el valor no es nulo
	post: retorna verdader si la lista contiene un objeto del mismo valor
	@param key valor que se desea encontrar
	@return true or false
	**/

	public String get(String key);

	/**
	post: retorna el valor asociado con la llave prevista
	@param key valor que se desea encontrar
	@return  valor asociado con el Key
	**/


	public void put(String key, String val);

	/**
	post: inserta un nuevo node en el árbol
	@param key 
	@param val 
	**/
}