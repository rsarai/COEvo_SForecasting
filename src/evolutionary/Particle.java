package evolutionary;

public class Particle {
	private double[] current_position;
	private double[] strategy_parameters;
	private double[] best_particle;
	private double fitness;
	private Function function_wrapper;
	
	public Particle(Function f, double[] c, double[] s){
		this.function_wrapper = f;
		this.current_position = c;
		this.strategy_parameters = s;
		aply_function_on_current_position();
	}
	
	public Particle(Function f){
		this.function_wrapper = f;
		this.current_position = getRandomPosition();
		this.strategy_parameters = getRandomPosition();
		this.fitness = f.activationFunction(current_position);
		aply_function_on_current_position();
	}
	
	public double[] getRandomPosition(){
		double [] position = new double[30];
		for (int i = 0; i < 30; i++){
			position[i] = function_wrapper.getBottomDomainLimit() + Math.random() * (function_wrapper.getTopDomainLimit() - function_wrapper.getBottomDomainLimit() );
		}
		return position;
	}
	
	public void aply_function_on_current_position(){
		this.fitness = this.function_wrapper.activationFunction(this.current_position);
	}

	public double[] getCurrent_position() {
		return current_position;
	}

	public void setCurrent_position(double[] current_position) {
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
}
