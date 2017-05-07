package RBFnetwork;

import java.util.Random;

public class Neuron {
	private double output;
	private double [] weights;
	private Function activationFunction;
	private Random random = new Random();
	
	public Neuron(int numNeuronios, Function function, double value){
		this.weights = new double[numNeuronios];
		this.output = value;
		this.activationFunction = function;
		
		for (int i = 0; i < numNeuronios; i++){
			this.weights[i] = random.nextInt(8192)/8192-0.5d;
		}
	}
	
	public Neuron(int numNeuronios, Function function){
		this.weights = new double[numNeuronios];
		this.output = -1;
		this.activationFunction = function;
		
		for (int i = 0; i < numNeuronios; i++){
			this.weights[i] = random.nextInt(8192)/8192-0.5d;
		}
	}
	
	public Neuron(double[] inputs, Function function){
		this.weights = new double[inputs.length];
		this.output = -1;
		this.activationFunction = function;
		
		for (int i = 0; i < inputs.length; i++){
			this.weights[i] = random.nextInt(8192)/8192-0.5d;
		}
	}
	
	public double getOutput() {
		return output;
	}
	public void setOutput(double output) {
		this.output = output;
	}
	public Function getActivationFunction() {
		return activationFunction;
	}
	public void setActivationFunction(Function activationFunction) {
		this.activationFunction = activationFunction;
	}
	
	public double[] getWeights() {
		return weights;
	}

	public void setWeights(double[] weights) {
		this.weights = weights;
	}
}
