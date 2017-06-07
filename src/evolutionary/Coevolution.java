package evolutionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;

public class Coevolution {
	List<Double> teste = new ArrayList<>();
	List<Double> treinamento = new ArrayList<>();
	List<String> dados = new ArrayList<>();
	double[] valoresEntrada;
	int treinamentoSize;
	int testSize;
	
	public void normaliza(){	
		StandardDeviation sd = new StandardDeviation();
		
		//valor = (valor - media)/desvio padrão
		double max, min;
		double media = 0;
		valoresEntrada = new double[dados.size()];
		double[] auxEntrada = new double[dados.size()];
		
		max = min = Double.parseDouble(dados.get(0));
		
		for(int  i = 0; i < dados.size(); i++){
			valoresEntrada[i] = Double.parseDouble(dados.get(i));
			media = media + valoresEntrada[i];
			
			if(valoresEntrada[i] > max){
				max = valoresEntrada[i];
			}
			if(valoresEntrada[i] < min){
				min = valoresEntrada[i];
		}
			
		}
		auxEntrada = valoresEntrada;
		media = media/valoresEntrada.length;
		
		for(int j = 0; j < valoresEntrada.length; j++){
			valoresEntrada[j] = (auxEntrada[j] - media)/sd.evaluate(auxEntrada);
		}
	}
	
	public Coevolution(){
		dados = (ArrayList<String>) readFile("res/Stock.txt");
		normaliza();
		treinamentoSize = Math.round((dados.size() * 80) / 100);
		testSize = dados.size() - treinamentoSize;
		getDatabase();
	}
	
	public void getDatabase(){
		for (int i = 0; i < treinamentoSize; i++){
			treinamento.add(valoresEntrada[i]);
		}
		
		for (int i = treinamentoSize; i < treinamentoSize + testSize; i++){
			teste.add(valoresEntrada[i]);
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
		    dados = records;
		    return records;
		  }catch (Exception e)
		  {
		    System.err.format("Exception occurred trying to read '%s'.", filename);
		    e.printStackTrace();
		    return null;
		  }
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

	public List<Double> getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(List<Double> treinamento) {
		this.treinamento = treinamento;
	}

	public double[] getValoresEntrada() {
		return valoresEntrada;
	}

	public void setValoresEntrada(double[] valoresEntrada) {
		this.valoresEntrada = valoresEntrada;
	}

	public List<Double> getTeste() {
		return teste;
	}

	public void setTeste(List<Double> teste) {
		this.teste = teste;
	}
}
