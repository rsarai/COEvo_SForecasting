package RBFnetwork;

import java.util.ArrayList;
import java.util.List;

public class Layer {
	private List<Neuron> neuronios;
	
	public Layer(int numNeuronios){
		this.neuronios = new ArrayList<>();
		//add bias
		for (int i = 0; i < numNeuronios; i++){
			this.neuronios.add(new Neuron(numNeuronios));
		}
	}
	
	public Layer(List<Neuron> neurons){
		this.neuronios = neurons;
	}

	public List<Neuron> getNeuronions() {
		return neuronios;
	}

	public void setNeuronions(List<Neuron> neuronions) {
		this.neuronios = neuronions;
	}
	
	//TODO
	public double activationFunction(double value){
		return 0;
	}
	
	//TODO
	public double derivate(double value){
		return 0;
	}
}
