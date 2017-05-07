package RBFnetwork;

public class Main {

	public static void main(String[] args) {
		double[] centers = {1,1,1,1};
		double[] radius = {1,1,1,1};
		double[] inputs = {1,1,1,1};
		RBF rbf = new RBF(centers, radius, inputs);
		System.out.println(rbf.prevision()[0]);
	}

}
