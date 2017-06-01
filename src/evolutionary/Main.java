package evolutionary;

public class Main {

	public static void main(String[] args) {
		EvolutionStrategies es = new EvolutionStrategies(new SphereFunction(-30, 30));
		es.search();
	}

}
