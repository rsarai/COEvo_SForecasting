package evolutionary;

import java.util.Random;

public class Particle {
	private double[][] current_position;
	private double[] solution;
	private double[] strategy_parameters;
	private double[] best_particle;
	private double fitness;
	private Function function_wrapper;
	private MLP mlp;
	
	public Particle(Function f, double[][] c, double[] s, double[] sol){
		this.function_wrapper = f;
		this.current_position = c;
		this.strategy_parameters = s;
		this.solution = sol;
		aply_function_on_current_position();
	}
	
	public Particle(Function f){
		this.function_wrapper = f;
		this.current_position = getRandomPosition();
		this.strategy_parameters = getRandomPositionStrategies();
		this.fitness = f.activationFunction(current_position, this.solution);
		aply_function_on_current_position();
	}
	
	public double[] getRandomPositionStrategies(){
		double [] position = new double[3];
		for (int i = 0; i < 3; i++){
			position[i] = function_wrapper.getBottomDomainLimit() + Math.random() * (function_wrapper.getTopDomainLimit() - function_wrapper.getBottomDomainLimit() );
		}
		return position;
	}
	
	public double[][] getRandomPosition(){
		/*for (int i = 0; i < 30; i++){
			position[i] = function_wrapper.getBottomDomainLimit() + Math.random() * (function_wrapper.getTopDomainLimit() - function_wrapper.getBottomDomainLimit() );
		}*/
		Coevolution c = new Coevolution();
		c.getDatabase();
		double [][] position = new double[c.getTreinamentoSize()][3];
		this.solution =  new double[c.getTreinamentoSize()];
		Random r = new Random();
		for (int j = 0; j < c.getTreinamentoSize(); j++){
			int value = r.nextInt(c.getTreinamento().size() - 3);
			for (int i = 0; i < 3; i++){
				position[j][i] = (c.getTreinamento().get(value + i)); 
			}
			solution[j] = position[j][2];
		}
		return position;
	}
	
	public void aply_function_on_current_position(){
		double error = 0;
		double v = this.function_wrapper.activationFunction(this.current_position, this.solution);
		if (v < this.fitness){
			this.fitness = v;
			this.mlp = ((NeuralPrevision) this.function_wrapper).getMlp();
		}
		this.setMlp(((NeuralPrevision) this.function_wrapper).getMlp());
		error = this.mlp.evaluateNetwork();
		this.fitness = this.fitness + error;
	}

	public double[][] getCurrent_position() {
		return current_position;
	}

	public void setCurrent_position(double[][] current_position) {
		this.current_position = current_position;
	}

	public double[] getStrategy_parameters() {
		return strategy_parameters;
	}

	public void setStrategy_parameters(double[] strategy_parameters) {
		this.strategy_parameters = strategy_parameters;
	}

	public double[] getBest_particle() {
		return best_particle;
	}

	public void setBest_particle(double[] best_particle) {
		this.best_particle = best_particle;
	}

	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public Function getFunction_wrapper() {
		return function_wrapper;
	}

	public void setFunction_wrapper(Function function_wrapper) {
		this.function_wrapper = function_wrapper;
	}

	public double[] getSolution() {
		return solution;
	}

	public void setSolution(double[] solution) {
		this.solution = solution;
	}

	public MLP getMlp() {
		return mlp;
	}

	public void setMlp(MLP mlp) {
		this.mlp = mlp;
	}
}
