
class Student{
    private String name;
    private double math;
    private double program;
    private double DSA1;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMath() {
		return this.math;
	}

	public void setMath(double math) {
		this.math = math;
	}

	public double getProgram() {
		return this.program;
	}

	public void setProgram(double program) {
		this.program = program;
	}

	public double getDSA1() {
		return this.DSA1;
	}

	public void setDSA1(double DSA1) {
		this.DSA1 = DSA1;
	}

    Student(String name, double m,double p,double dsa1){
        this.name = name;
        this.math = m;
        this.program = p;
        this.DSA1 = dsa1;
    }

    public double avg(){
		double k = (double) 1/3;
        return k*(this.math + this.DSA1 + this.program);
	}
	
	public String toString(){
		return "Ten: "+this.name+" --Toan: "+this.math+" --Lap trinh: "+this.program+" --DSA1: "+this.DSA1+" --TBC: "+this.avg();
	}
}