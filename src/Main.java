/*
*
*@author Juan Pablo pineda 19087
*@author Eduardo Ramírez 19946
*/

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main{
	public static void main(String[] args) {

		Factory<String,String> factory = new Factory<>();
		TranslatorInterface<String,String> dictionary = null;

		//Solicitar al usuario la implementacion hasta que la seleccione correctamente
		while(dictionary == null){
			String implementacion = JOptionPane.showInputDialog(null, "Ingrese '1' para implementar un HASHING \nIngrese '2' para implementar SPLAY TREE");
			if(implementacion.equals("1")){
				dictionary = factory.getTranslator(1); //Usar implmentacion de hashing
			}else if(implementacion.equals("2")){
				dictionary = factory.getTranslator(2); //Usar implementacion de SplayTree
			}else{
				JOptionPane.showMessageDialog(null, "Por favor ingrese una opcion valida >:(");
			}
		}

		//Manejar visualizador de archivos
		JFileChooser jfc = new JFileChooser();
		jfc.setCurrentDirectory(new File(System.getProperty("user.dir")));

		//Solicitar archivo de traducciones
		JOptionPane.showMessageDialog(null, "A continuacion ingerse un archivo con traducciones");
		jfc.showOpenDialog(null); 
		File file = jfc.getSelectedFile();

		//Solicitar archivo con frase a traducir
		JOptionPane.showMessageDialog(null, "A continuacion ingerse un archivo con la frase a traducir");
		jfc.showOpenDialog(null); 
		File file2 = jfc.getSelectedFile();

		//Realizar traduccion
		Translator translator = new Translator(file,file2,dictionary);
		translator.agregarDiccionario();
		String oracion = translator.getOracion();
		String traduccion = translator.traducir();

		//Mostrar resultados
		System.out.println(oracion+"\n"+traduccion);
		JOptionPane.showMessageDialog(null, oracion+"\nSe traduce como: \n"+traduccion);
	}
}


