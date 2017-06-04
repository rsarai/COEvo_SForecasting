package evolutionary;

public abstract class Function {
	private String name;
	private double bottomDomainLimit;
    private double topDomainLimit;

    public Function(double bottomDomainLimit, double topDomainLimit)
    {
	this.bottomDomainLimit = bottomDomainLimit;
	this.topDomainLimit = topDomainLimit;
    }
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public abstract double activationFunction(double[][] value);
	
	public double getBottomDomainLimit() {
		return bottomDomainLimit;
	}

	public void setBottomDomainLimit(double bottomDomainLimit) {
		this.bottomDomainLimit = bottomDomainLimit;
	}

	public double getTopDomainLimit() {
		return topDomainLimit;
	}

	public void setTopDomainLimit(double topDomainLimit) {
		this.topDomainLimit = topDomainLimit;
	}

	public abstract double activationFunction(double[][] current_position, double[] solution);
}
 