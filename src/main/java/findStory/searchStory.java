package findStory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class searchStory {

	static ArrayList<String> gerarListaDeArquivos(String enderecoRaiz){
	        File dir = new File(enderecoRaiz);
	        File auxDir = null;
	        int i;
	        ArrayList<String> listaDeArquivos = new ArrayList();               
	        
	        for(i=0;i<dir.list().length;i++){
	            auxDir = new File(dir.getAbsolutePath() + "\\" + dir.list()[i]);     
	            if(auxDir.isDirectory()){//--Se for um diretório recursiona
	                listaDeArquivos.addAll(gerarListaDeArquivos(auxDir.getAbsolutePath()));
	            }
	            else{                     //--Se não coloca na lista
	                listaDeArquivos.add(auxDir.getAbsolutePath());
	            }
	        }    
	        return listaDeArquivos;
	    }
	    
	    static ArrayList<String> arquivosQueContemAPalavra(String enderecoRaiz, String palavra) throws FileNotFoundException, IOException{
	        int i, linhaNumber;
	        ArrayList<String> listaDeArquivos = new ArrayList();
	        ArrayList<String> listaSaida = new ArrayList();
	        
	        listaDeArquivos = searchStory.gerarListaDeArquivos(enderecoRaiz);
	        
	        for(i=0;i<listaDeArquivos.size();i++){ 
	            FileReader arquivo = new FileReader(listaDeArquivos.get(i)); 
	            BufferedReader lerArquivo = new BufferedReader(arquivo);

	            String linha = lerArquivo.readLine();
	            
	            linhaNumber = 0;
	            while(linha != null){
	            	if(linha.contains(palavra)){
	            	   System.out.println("AQUI!!!");
	                listaSaida.add(new File(listaDeArquivos.get(i)).getName());                
	               }
	                   linhaNumber++; 
	                   linha = lerArquivo.readLine();
	            }
	            arquivo.close();
	        }
	        return listaSaida;
	    }	
}
