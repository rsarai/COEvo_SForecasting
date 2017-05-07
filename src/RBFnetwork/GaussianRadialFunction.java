package RBFnetwork;

public class GaussianRadialFunction extends Function {
	private double r0;
	
	public GaussianRadialFunction(double scale) {
        r0 = scale;
	}

	@Override
	public double activationFunction(double center) {
		center /= r0;
		return Math.exp((-0.5 * center * center)/Math.E * Math.E);
	}

	@Override
	public double derivate(double value) {
		// TODO Auto-generated method stub
		return 0;
	}

}
	