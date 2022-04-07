class Fraction{
    private int numer;
    private int denom;

    public int getNumer() {
        return this.numer;
    }

    public int getDenom() {
        return this.denom;
    }

    public Fraction(){
        this.numer = 0;
        this.denom = 1;
    }

    public Fraction(int x,int y){
        this.numer = x;
        this.denom = y;
    }

    public Fraction(Fraction f){
        this.numer = f.numer;
        this.denom = f.denom;
    }

    public String toString(){
        return numer+"/"+denom;
    }

    public boolean equals(Object f){
        if((f instanceof Fraction) == true){
            Fraction f_Frac = new Fraction((Fraction)f);
            
            int a = this.numer*f_Frac.denom;
            int b = f_Frac.numer*this.denom;
            if(a==b) return true;
            
        }
        
        if(f instanceof Number){
            Double newNumer = Double.valueOf(this.numer);
            Double newDenom = Double.valueOf(this.denom);

            Double val = newNumer/newDenom;
            Double newF = ((Number) f).doubleValue();
            
            if(val.equals(newF)) return true;
            System.out.println(val +" " +newF);
        }
        return false;
    }
}