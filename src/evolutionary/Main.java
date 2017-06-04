package evolutionary;

public class Main {

	public static void main(String[] args) {
		NeuralPrevision n = new NeuralPrevision(-1000, 1000);
		EvolutionStrategies es = new EvolutionStrategies(n);
		MLP m = es.search();
		Coevolution c = new Coevolution();
		c.getDatabase();
		double[][] d = {{38, 141.7}};
		m.setEntradas(d);
		System.out.println(m.prevision());
	}

}
