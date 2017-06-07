package evolutionary;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random r = new Random();
		Coevolution c = new Coevolution();
		/*for (int i = 0; i < 30; i++){
			NeuralPrevision n = new NeuralPrevision(-1000, 1000);
			EvolutionStrategies es = new EvolutionStrategies(n);
			MLP m = es.search();
			int rand = r.nextInt(c.getTestSize() - 3);
			double[][] d = {{c.getTeste().get(rand), c.getTeste().get(rand+1)}};
			m.setEntradas(d);
			System.out.println(Math.pow(m.prevision() - c.getTeste().get(rand+2), 2)/2 );
		}
		System.out.println("------------");*/
		for (int i = 0; i < 30; i++){
			NeuralPrevision n = new NeuralPrevision(-1000, 1000);
			EvolutionDifferencial es = new EvolutionDifferencial(n);
			MLP m = es.search();
			int rand = r.nextInt(c.getTestSize() - 3);
			double[][] d = {{c.getTeste().get(rand), c.getTeste().get(rand+1)}};
			m.setEntradas(d);
			System.out.println(Math.pow(m.prevision() - c.getTeste().get(rand+2), 2)/2 );
		}
	}
}
