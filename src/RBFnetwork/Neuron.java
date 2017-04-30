package RBFnetwork;

import java.util.ArrayList;
import java.util.List;

public class Neuron {
	private double input;
	private double output;
	private List<Double> weights;
	private String activationFunction;
	
	public Neuron(int numSinapse){
		this.weights = new ArrayList<>();
		
		for (int i = 0; i < numSinapse; i++){
			this.weights.add(Math.random());
		}
	}
	
	public double getInput() {
		return input;
	}
	public void setInput(double input) {
		this.input = input;
	}
	public double getOutput() {
		return output;
	}
	public void setOutput(double output) {
		this.output = output;
	}
	public String getActivationFunction() {
		return activationFunction;
	}
	public void setActivationFunction(String activationFunction) {
		this.activationFunction = activationFunction;
	}

	public List<Double> getWeights() {
		return weights;
	}

	public void setWeights(List<Double> weights) {
		this.weights = weights;
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
