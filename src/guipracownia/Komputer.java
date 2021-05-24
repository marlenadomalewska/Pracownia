package guipracownia;

import java.io.Serializable;
/**
 * <i>Klasa Komputer dziedzicząca z klasy Urzadzenie implementująca interfejsy Cloneable, Serializable</i>
 * @author <p>Marlena Domalewska</p>
 */


public class Komputer extends Urzadzenie implements Cloneable, Serializable{

    /**
     * Pole klasy Komputer przechowujace wartosc zasilania
     */
    protected float zasilanie;
    /**
     * Pole klasy Komputer przechowujace cene
     */
    protected double cena;

    /**
     * Konstruktor parametryczny klasy Komputer
     * @param zasilanie zasilanie komputera
     * @param cena cena komputera
     */
    public Komputer(float zasilanie, double cena) {
        this.zasilanie = zasilanie;
        this.cena = cena;
    }
    /**
     * Konstruktor domniemany klasy Komputer
     */
    public Komputer(){
        this.cena = 0.0;
        this.zasilanie = (float) 0.0;
    }
    /**
     * Konstruktor kopiujący klasy Komputer
     * @param source kopiowany obiekt klasy Komputer
     */
    Komputer(Komputer source){
        this.cena = source.cena;
        this.zasilanie = source.zasilanie;
    }
    /**
     * Nadpisana metoda Info z klasy abstrakcyjnej Urzadzenie. Zwraca ciag znakow zawierajacy informacje o obiekcie. 
     * @return string
     */
    @Override
    public String Info() {
        String info = new String();
        info = info.format("Zasilanie: %f\nCena: %2f\n", zasilanie, cena);
        return info;
    }

    /**
     * Nadpisana metoda clone z interfejsu Cloneable zwracająca sklonowany obiekt klasy Komputer
     * @return sklonowany obiekt klasy Komputer
     * @throws CloneNotSupportedException wyjątek możliwy do zwrócenia przez metodę
     */
    @Override
    public Komputer clone() throws CloneNotSupportedException{
        return (Komputer)super.clone();
    }

    /** 
     * Funkcja zwracająca zasilanie komputera
     * @return zasilanie komputera
     */
    public float getZasilanie() {
        return zasilanie;
    }
    
    /**
     * Funkcja zwracająca cenę komputera
     * @return cena komputera
     */
    public double getCena() {
        return cena;
    }

    /**
     * Funkcja ustawiająca zasilanie komputera
     * @param zasilanie zasilanie komputera
     */
    public void setZasilanie(float zasilanie) {
        this.zasilanie = zasilanie;
    }

    /**
     * Funkcja ustawiająca cenę komputera
     * @param cena cena komputera
     */
    public void setCena(double cena) {
        this.cena = cena;
    }
    
    
    
}
