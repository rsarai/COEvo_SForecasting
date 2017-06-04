package evolutionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Coevolution {
	List<String> teste = new ArrayList<String>();
	List<String> treinamento = new ArrayList<String>();
	List<String> dados = new ArrayList<>();
	int treinamentoSize;
	int testSize;
	
	public Coevolution(){
		dados = (ArrayList<String>) readFile("res/sunspot.txt");
		treinamentoSize = Math.round((dados.size() * 80) / 100);
		testSize = dados.size() - treinamentoSize;
	}
	
	public void getDatabase(){
		for (int i = 0; i < treinamentoSize; i++){
			treinamento.add(dados.get(i));
		}
		
		for (int i = 0; i < testSize; i++){
			teste.add(dados.get(i));
		}	
	}
		
	public List<String> readFile(String filename){
		  List<String> records = new ArrayList<String>();
		  try{
		    BufferedReader reader = new BufferedReader(new FileReader(filename));
		    String line;
		    while ((line = reader.readLine()) != null)
		    {
		      records.add(line);
		    }
		    reader.close();
		    teste = records;
		    return records;
		  }catch (Exception e)
		  {
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		    return null;
		  }
	}

	public List<String> getTeste() {
		return teste;
	}

	public void setTeste(List<String> teste) {
		this.teste = teste;
	}

	public List<String> getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(List<String> treinamento) {
		this.treinamento = treinamento;
	}

	public List<String> getDados() {
		return dados;
	}

	public void setDados(List<String> dados) {
		this.dados = dados;
	}

	public int getTreinamentoSize() {
		return treinamentoSize;
	}

	public void setTreinamentoSize(int treinamentoSize) {
		this.treinamentoSize = treinamentoSize;
	}

	public int getTestSize() {
		return testSize;
	}

	public void setTestSize(int testSize) {
		this.testSize = testSize;
	}
}
