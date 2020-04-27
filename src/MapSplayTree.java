/*
*							     
*@author Juan Pablo pineda 19087
*@author Eduardo Ramírez 19946
*/

public class MapSplayTree<K extends Comparable<K>, V> implements TranslatorInterface<K,V>{

    private SplayTree<Association<K,V>> tree;

    public MapSplayTree(){
        this.tree = new SplayTree<>();
    }

    @Override
    public V remove(K key) {
        return this.tree.remove(new Association<K,V>(key,null)).getValue();
    }

    @Override
    public V put(Association<K,V> association) {
        V value = null;
        
        if(this.tree.isEmpty()){
            this.tree.setValue(association);
        }else{
            this.tree.add(association, tree);
        }
        
		return value;
    }

    @Override
    public int size() {
        return this.tree.size();
    }

    @Override
    public boolean searchValue(K searched) {
        return this.tree.contains(this.tree, new Association<K,V>(searched,null));
    }

    @Override
    public V get(K key) {
        return this.tree.get(this.tree, new Association<K,V>(key,null)).getValue();
    }
}