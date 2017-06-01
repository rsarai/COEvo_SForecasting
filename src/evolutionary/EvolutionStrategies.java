package evolutionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EvolutionStrategies {
	private Function functionWrapper;
	private List<Particle> population;
	private static int iterations = 10000;
	private static int numOffspring = 245;
	private List<Particle> bestResults;
	private Random random;
	
	public EvolutionStrategies(Function f){
		random = new Random();
		this.functionWrapper = f;
		this.population = new ArrayList<>();
		this.bestResults = new ArrayList<>();
	}
	
	public void search(){
		initializePopulation();
		for (int i = 0; i < this.iterations; i++){
			for (Particle p: this.population){
				p.aply_function_on_current_position();
			}
			
			Particle parents = this.population.get(0);
			
			for (int j = 0; j < this.numOffspring; j++){
				//crossover
				Particle newIndividuo = mutateOffspring(parents);
				newIndividuo.aply_function_on_current_position();
				population.add(newIndividuo);
			}
			Particle best = selectBestFromPopulation();
			population = new ArrayList<>();
			population.add(best);
		}
		
	}
	
	public Particle selectBestFromPopulation(){
		Particle best = this.population.get(0);
		
		for (Particle p: this.population){
			if(p.getFitness() < best.getFitness()){
				best = p;
			}
		}
		bestResults.add(best);
		System.out.println(best.getFitness());
		return best; 
	}
	
	public Particle mutateOffspring(Particle offspring){
		double[] currentPosition= new double[offspring.getCurrent_position().length];
		double[] strategyParameters = adaptStepsize(offspring);
		
		for (int i = 0; i < offspring.getCurrent_position().length; i++){
			currentPosition[i] = offspring.getCurrent_position()[i] + strategyParameters[i] * random.nextGaussian();
			currentPosition[i] = verifyBound(currentPosition[i]);
		}
		Particle p = new Particle(functionWrapper, currentPosition, strategyParameters);
		return p;
	}
	
	public double verifyBound(double pos){
		if (pos > this.functionWrapper.getTopDomainLimit()){
			return this.functionWrapper.getTopDomainLimit();
		}
		
		if (pos < this.functionWrapper.getBottomDomainLimit()){
			return this.functionWrapper.getBottomDomainLimit();
		}
		
		return pos;
	}
	
	public double[] adaptStepsize(Particle p){
		double[] strategies = new double[30];
		double tl = 1/Math.sqrt(2 * 30);
		double t = 1/Math.sqrt(2 * Math.sqrt(30));
		for (int i = 0; i < 30; i++){
			strategies[i] = p.getStrategy_parameters()[i] * Math.exp(tl * random.nextGaussian() + t * random.nextGaussian());
			if (strategies[i] > this.functionWrapper.getTopDomainLimit()){
				strategies[i] = this.functionWrapper.getTopDomainLimit();
			}
			
			if (strategies[i] < this.functionWrapper.getBottomDomainLimit()){
				strategies[i] = this.functionWrapper.getBottomDomainLimit();
			}
		}
		return strategies;
	}
	
	public List<Particle> initializePopulation(){
		Particle p = new Particle(this.functionWrapper);
		this.population.add(p);
		return this.population;
	}
	
}
