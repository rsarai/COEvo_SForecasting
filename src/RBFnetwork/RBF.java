package RBFnetwork;

import java.util.Random;

public class RBF {
	private double bias1[];
	private double bias2[];
	
	private int numberInput = 3;
	private int numberOutputs = 1;
	private int numberHiddenNeurons = 4;
	private double [] centers;
	private double [] radius;
	private double [] inputs;
	private double [][] weights;
	private double [][] weights2;
	
	private double [] net1;
	private double [] net2;
	private double [] fnet1;
	private double [] netout; 
	
	public RBF(double[] centers, double[] radius, double[] inputs){
		this.inputs = inputs;
		this.net1 = new double[getNumberHiddenNeurons()];
		this.net2 = new double[getNumberOutputs()];
		this.netout = new double[getNumberOutputs()];
		this.fnet1 = new double[getNumberHiddenNeurons()];
		this.bias1 = new double[getNumberHiddenNeurons()];
		this.bias2 = new double[getNumberOutputs()];
		this.weights = new double[getNumberHiddenNeurons()][getNumberInput()];
		this.weights2 = new double[getNumberOutputs()][getNumberHiddenNeurons()];
		this.centers = centers;
		this.radius = radius;
		randomize();
	}
	
	public void randomize(){
		Random random = new Random();
		
		for (int j=0; j<getNumberHiddenNeurons(); j++) {
			for (int i=0; i<getNumberInput(); i++) {
				setBias1(j,-1+random.nextInt(8192)/8192);
				this.weights[j][i] = random.nextInt(8192)/8192-0.5d;
			}
		}
		for (int j=0; j<getNumberOutputs(); j++) {
			for (int i=0; i<getNumberHiddenNeurons(); i++) {
				setBias2(j,-0.1d + random.nextInt(8192)/8192);
				this.weights2[j][i] = 0.1d * random.nextInt(8192)/8192-0.5d;
			}
		}
	}
	
	public double[] prevision(){
		double eb;
		for (int j=0;j<getNumberHiddenNeurons();j++) {
			setNet1(j, getBias1()[j]);
			
			for(int i=0; i < getNumberInput(); i++){
				setNet1(j,getNet1()[j]+ (getWeights()[j][i] * getInputs()[i]));
			}
			
			setFnet1(j, Math.exp((-0.5 * Math.pow(getNet1()[j] - getCenters()[j], 2) )/(getRadius()[j] * getRadius()[j])));
		}

		for(int j = 0; j < getNumberOutputs(); j++){
			setNet2(j, getBias2()[j]);
			
			for(int i = 0; i < getNumberHiddenNeurons(); i++){
				setNet2(j, getNet2()[j] + (getWeights2()[j][i] * getFnet1()[i]));
			}
			eb=(double)(Math.exp((double)((-1.0d)*(getNet2()[j]))));
			setNetout(j, (double) (1.0/(1.0+eb)));
		}
		
		return getNetout();
	}

	private void setNetout(int col, double value){
		netout[col] = value;
	}

	public int getNumberInput() {
		return numberInput;
	}

	public void setNumberInput(int numberInput) {
		this.numberInput = numberInput;
	}

	public int getNumberOutputs() {
		return numberOutputs;
	}

	public void setNumberOutputs(int numberOutputs) {
		this.numberOutputs = numberOutputs;
	}

	public int getNumberHiddenNeurons() {
		return numberHiddenNeurons;
	}

	public void setNumberHiddenNeurons(int numberHiddenNeurons) {
		this.numberHiddenNeurons = numberHiddenNeurons;
	}

	public double[] getCenters() {
		return centers;
	}

	public void setCenters(double[] centers) {
		this.centers = centers;
	}

	public double[] getRadius() {
		return radius;
	}

	public void setRadius(double[] radius) {
		this.radius = radius;
	}

	public double[] getInputs() {
		return inputs;
	}

	public void setInputs(double[] inputs) {
		this.inputs = inputs;
	}

	public double[][] getWeights() {
		return weights;
	}

	public void setWeights(double[][] weights) {
		this.weights = weights;
	}

	public double[][] getWeights2() {
		return weights2;
	}

	public void setWeights2(double[][] weights2) {
		this.weights2 = weights2;
	}

	public double[] getNet1() {
		return net1;
	}

	public void setNet1(int index, double value) {
		this.net1[index] = value;
	}

	public double[] getNet2() {
		return net2;
	}

	public void setNet2(int col, double value){
		this.net2[col] = value;
	}

	public double[] getFnet1() {
		return fnet1;
	}

	public void setFnet1(int index, double value) {
		fnet1[index]=value;
	}

	public double [] getNetout() {
		return netout;
	}

	public void setNetout(double [] netout) {
		this.netout = netout;
	}

	public double[] getBias1() {
		return bias1;
	}

	public void setBias1(int index, double value){
		bias1[index]=value;
	}

	public double[] getBias2() {
		return bias2;
	}

	public void setBias2(int index, double value){
		bias2[index]=value;
	}
	
}
