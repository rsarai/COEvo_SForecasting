package evolutionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EvolutionDifferencial {
	private Function functionWrapper;
	private List<Particle> population;
	private static int populationSize = 30;
	private static int iterations = 1000;
	private static int dimensions = 3;
	private int numOffspring = 1;
	private static double scaleFactor = 0.9;
	private static double probabilityOfRecombination = 0.6;
	
	private List<Particle> bestResults;
	private Random random;
	
	public EvolutionDifferencial(Function f){
		this.functionWrapper = f;
	}
	
	public MLP search(){
		Particle best = null;
		initializePopulation();
		for (int i = 0; i < this.iterations; i++){
			bestResults = new ArrayList<>();
			for (Particle p: this.population){
				double[][] trialVector = createTrialVector(p);
				double[][] offspring = createOffspring(p, trialVector);
				Particle newp = new Particle(this.functionWrapper, offspring, offspring[0], p.getSolution());
				if (p.getFitness()  < newp.getFitness()){
					bestResults.add(p);
					
				}else{
					bestResults.add(newp);
				}
			}
			this.population = new ArrayList<>();
			this.population = bestResults;
			best = selectBestFromPopulation();
			updateParameter();
		}
		
		return best.getMlp();
	}
	
	public Particle selectBestFromPopulation(){
		Particle best = this.population.get(0);
		
		for (Particle p: this.population){
			if(p.getFitness() < best.getFitness()){
				best = p;
			}
		}
		//System.out.println(best.getFitness());
		return best; 
	}
	
	public void updateParameter(){
		this.scaleFactor -= (0.9 - 0.4) / 10000;
	}
	
	public double[][] createOffspring(Particle p, double[][] trial){
		double[][] offspring = new double[trial.length][3];
		
		for (int i = 0; i < p.getCurrent_position().length; i++){
			for (int j = 0; j < 2; j++){
				double limiar = Math.random();
				if (limiar < probabilityOfRecombination){
					offspring[i][j] = trial[i][j];
				}else{
					offspring[i][j] = p.getCurrent_position()[i][j];
				}
			}
		}
		
		return offspring;
	}
	
	public double[][] createTrialVector(Particle p){
		Random random = new Random();
		Particle destiny = this.population.get(random.nextInt(populationSize));
		Particle vect1 = this.population.get(random.nextInt(populationSize));
		Particle vect2 = this.population.get(random.nextInt(populationSize));
		double[][] trialVector = new double[destiny.getCurrent_position().length][3];
		
		for (int i = 0; i < destiny.getCurrent_position().length; i++){
			for (int j = 0; j < 2; j++){
				trialVector[i][j] = destiny.getCurrent_position()[i][j] + scaleFactor * (vect1.getCurrent_position()[i][j] - vect1.getCurrent_position()[i][j]);
			}
		}
		
		return trialVector;
	}
	
	public List<Particle> initializePopulation(){
		population = new ArrayList<>();
		for (int i = 0; i < populationSize; i++){
			Particle p = new Particle(this.functionWrapper);			
			this.population.add(p);
		}
		return this.population;
	}
}
