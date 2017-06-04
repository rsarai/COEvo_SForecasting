package evolutionary;

public class NeuralPrevision extends Function{
	private MLP mlp;
	
	public NeuralPrevision(double bottomDomainLimit, double topDomainLimit) {
		super(bottomDomainLimit, topDomainLimit);
	}

	public double activationFunction(double[][] value, double[] saidas) {
		mlp = new MLP();
		mlp.setSemente(1315);
		mlp.setCiclos(1000);
		mlp.setCicloAtual(0);
		mlp.setNumInputs(2);
		mlp.setNumHidden(4);
		mlp.setNumOutputs(1);
		mlp.setNumTraining(7);
		mlp.setAlfa(0.1);
		mlp.setBeta(0.6);
		
		mlp.init();
		mlp.setEntradas(value);
		mlp.setSaida(saidas);
		mlp.Forward();
		
		return mlp.prevision();
	}

	public MLP getMlp() {
		return mlp;
	}

	public void setMlp(MLP mlp) {
		this.mlp = mlp;
	}

}
