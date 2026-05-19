public class Trapez extends Parallelogram {
	
	protected double gama; //Winkel an Punkt c
	protected double delta; //Winkel an Punkt d

	
	
	
protected Trapez() {
	this(new Punkt(0,0), new Punkt(1,1), new Punkt(3,1), new Punkt(4,0), " ", " "); //Standartwerte eines Trapez welches nicht weiter definiert wurde.
}

public Trapez (punkt a, punkt b, punkt c, punkt d) {
	this(a, b, c, d, " ", " ") // Name und Farbe werden als leere Strings gespeichert
} 

public Trapez (punkt a, punkt b, punkt c, punkt d, String name, String farbe) {
this.a = a;
this.b = b;
this.c = c;
this.d = d;
this.name = name;
this.farbe = farbe;
berechneAlles();
}

public double getGama() { // gibt den Winkel gama zuruek
        return gama; 
    }
public double getDelta() { // gibt den Winkel delta zuruek
        return delta;
    }



protected  void berechne_alpha () { // berechnet den Winkel alpha der an Punkt a liegt
    double alpha = winkelBerechnen(getVektor(a, b), getVektor(a, d));
}
protected void berechne_beta () {  // berechnet den Winkel beta der an Punkt b liegt
    double beta = winkelBerechnen(getVektor(b, c), getVektor(b, a));
}
 protected void berechne_gama () { // berechnet den Winkel gama der an Punkt c liegt
	double gama = winkelBerechnen(getVektor(c, d), getVektor(c, b));
}
protected void berechne_delta () { // berechnet den Winkel delta der an Punkt d liegt
    double delta = winkelBerechnen(getVektor(d, a), getVektor(d, c));
}

protected void berechneFlaeche() {
	if (alpha <= 90 && gamma <= 90){
private double flaeche = (distanz(a, d) + distanz(b, c)) / 2 * hoehe // Formel: Parallele Seiten addieren die Summe durch 2 rechnen und mal die Hoehe rechnen

    }
else{
private double flaeche = (distanz(a, b) + distanz(c, d)) / 2 * hoehe

}

}
protected void berechenMittelpunkt() {
	
}

protected double berechneHoehe() {
	if (alpha <= 90 && delta <= 90 || beta <= 90 && gama <= 90){ //Hierbei wird mit der Annahme das wir uns in einem Trapez befinden geguckt ob ad und bc parralel sind.
hoehe = distanz(a, b) * sin(alpha) // hoehe ist die gegenkatethe und die nicht parallele ab Gerade ist die Hypotenuse

    }
    else{ // wenn ad und bc nicht parallel sind müssen die anderen beiden Seiten parallel sein
hoehe = distanz(a, d) * sin(alpha) // hoehe ist die gegenkatethe und die nicht parallele ad Gerade ist die Hypotenuse

    }
}
protected boolean istValide() {
 private double parrallelitaet1 = berechneSteigung(a, d) - berechneSteigung(b, c); // Wenn die beiden geraden ad und bc parallel sind ist die Differenz 0.
  private double parrallelitaet2 = berechneSteigung(a, b) - berechneSteigung(c, d); //Wenn die beiden geraden ab und cd parallel sind ist die Differenz 0.
	if(parrallelitaet1 == 0 || parrallelitaet2 == 0){ // Wenn eine der beiden gegenüberliegenden Seiten parallel ist ist das Viereck ein Trapez.
        return true;
    }
    else{
        return false;
    }
}
public static boolean istValide(a, b, c, d) {
	private double parrallelitaet1 = berechneSteigung(a, d) - berechneSteigung(b, c); // Wenn die beiden geraden ad und bc parallel sind ist die Differenz 0.
  private double parrallelitaet2 = berechneSteigung(a, b) - berechneSteigung(c, d); //Wenn die beiden geraden ab und cd parallel sind ist die Differenz 0.
	if(parrallelitaet1 == 0 || parrallelitaet2 == 0){ // Wenn eine der beiden gegenüberliegenden Seiten parallel ist ist das Viereck ein Trapez.
        return true;
    }
    else{
        return false;
    }
}

 private double winkelBerechnen(double[] v1, double[] v2) {
        double skalar = v1[0] * v2[0] + v1[1] * v2[1];
        double betrag1 = Math.sqrt(v1[0]*v1[0] + v1[1]*v1[1]);
        double betrag2 = Math.sqrt(v2[0]*v2[0] + v2[1]*v2[1]);

        double cos = skalar / (betrag1 * betrag2);
        return Math.toDegrees(Math.acos(cos));
 }


private double berechneSteigung(Punkt p1, Punkt p2){
private double xP = p2.x - p1.x;
private double yP = p2.y - p1.y;
return yP / xP;

}


private void berechneAlles(){
berechne_alpha ();
berechne_beta ();
berechne_gama ();
berechne_delta ();
berechneHoehe();
berechneFlaeche();

if (!istValide()) {
            throw new IllegalArgumentException("Ungültiges Trapez");
        }

}


}