/*
*@author Juan Pablo pineda 19087
*@author Eduardo Ramírez 19946
*/

import java.io.File;
import java.io.*; 

public class Translator{

    private String diccionario;
    private String oracion;
    private TranslatorInterface<String,String> mapeo;

    /**
     * Constructor sin parametros
     */
    public Translator(){}

    /**
     * Constructor con parametros
     * @param diccionario
     * @param oracion
     */
    public Translator(File diccionario, File oracion, TranslatorInterface<String,String> mapeo){
        this.diccionario = leer(diccionario);
        this.oracion = leer(oracion);
        this.mapeo = mapeo;
    }

    /**
     * Agrega una definicion al diccionario
     * @param diccionario cadena de texto con las traducciones
     */
    public void agregarDiccionario(String diccionario){
        String[] asociaciones = diccionario.split("\n");
        for(int i=0; i<asociaciones.length; i++){
            String[] traduccion = asociaciones[i].split("\t");
            try{
                Association<String,String> as = new Association<String,String>(traduccion[0], traduccion[1].split(", ")[0]);
                this.mapeo.put(as);
            }catch(ArrayIndexOutOfBoundsException e){
                //Ignorar errores que se dan cuando se trata de guardar un texto que no esta en formato de traduccion, como comentarios dentro del texto
            }
            
        }
    }

    /**
     * Agregar diccionario sin parametros
     */
    public void agregarDiccionario(){
        agregarDiccionario(this.diccionario);
    }

    /**
     * @param oracion texto que se va a traducir
     * @return Traduccion de una oracion
     */
    public String traducir(String oracion){
        String[] palabras = oracion.split(" ");
        String traduccion = "";
        for(int i=0; i<palabras.length; i++){
            Association<String,String> asociacion = new Association<String,String>(palabras[i], null);
            if(this.mapeo.searchValue(asociacion.getKey())){
                traduccion += this.mapeo.get(asociacion.getKey()) + " ";
            }else{
                traduccion += "*" + palabras[i] + "* ";
            }
        }
        return traduccion;
    }

    /**
     * traduccion sin parametros
     */
    public String traducir(){
        return traducir(this.oracion);
    }

    /**
     * Metodo para leer archivos ed texto
     * @param archivo ruta local del archivo
     * @return Cadena de texto que contiene el archivo
     */
    public String leer(File archivo){
        BufferedReader reader = null;
        String cad = "";
        try {
            String line;
            File file = archivo;
            reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                cad += line+"\n";
            }
        
        } catch (IOException e) {
            System.out.println("Ingrese la direccion a un archivo valido");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return cad.substring(0, cad.length()-1).replace(".", "");
    }

    /**
     * @return oracion que se va a traducir
     */
    public String getOracion(){
        return this.oracion;
    }
    
}