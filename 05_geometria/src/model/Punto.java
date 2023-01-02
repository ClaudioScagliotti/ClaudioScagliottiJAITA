package model;

public class Punto {
private int x;
private int y;
public Punto(int x, int y){
		this.x=x;
		this.y=y;

	}
@Override
public String toString() {
	return "("+this.x+","+this.y+")";
}

public int getX() {
	return x;
}


public int getY() {
	return y;
}


}
