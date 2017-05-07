package RBFnetwork;

import java.util.ArrayList;
import java.util.List;

public class Layer {
	private List<Neuron> neuronios;
	private Function function;
	
	public Layer(int numNeuronios, Function function){
		this.neuronios = new ArrayList<>();
		this.function = function;
		this.neuronios.add(new Neuron(numNeuronios, function, 1));
		for (int i = 0; i < numNeuronios; i++){
			this.neuronios.add(new Neuron(numNeuronios, function));
		}
	}
	
	public Layer(double[] inputs, Function function){
		this.neuronios = new ArrayList<>();
		this.function = function;
		this.neuronios.add(new Neuron(inputs.length, function, 1));
		for (int i = 0; i < inputs.length; i++){
			this.neuronios.add(new Neuron(inputs.length, function, inputs[i]));
		}
	}
	
	
	
	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
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
}
