package guipracownia;

import java.io.Serializable;
import java.util.Objects;
/**
 * <i>Klasa Desktop dziedzicząca z klasy komputer, implementująca interfejsy Cloneable, Serializable</i>
 * @author <p>Marlena Domalewska</p>
 */

public class Desktop extends Komputer implements Cloneable, Serializable{
    /**
     * Pole klasy Desktop zawierające obiekt klasy Monitor należący do stanowiska
     */
    protected Monitor monitor;
    /**
     * Pole klasy Desktop zawierające informację o producencie
     */
    protected String producent;
    /**
     * Konstruktor domniemany klasy Desktop
     */
    public Desktop(){
        this.monitor = new Monitor();
        producent = "nieznany";
        
    }
    /**
     * Konstruktor parametryczny klasy Desktop
     * @param monitor obiekt klasy Monitor 
     * @param producent nazwa producenta
     * @param zasilanie zasilanie komputera
     * @param cena cena komputera
     */
    public Desktop(float zasilanie, double cena, Monitor monitor, String producent) {
        super(zasilanie, cena);
        this.monitor = new Monitor(monitor);
        this.producent = producent;
    }
    /**
     * Konstruktor kopiujący klasy Desktop
     * @param source kopiowany obiekt klasy Desktop
     */
    public Desktop(Desktop source){
        super((Komputer)source);
        this.monitor = new Monitor(source.monitor);
        this.producent = source.producent;
    }
    /**
     * Nadpisana metoda klasy abstrakcyjnej Urzadzenie zwracająca ciąg znaków z informacjami o stanowisku
     * @return string
     */
    @Override
    public String Info(){
        String s = new String();
        s = super.Info() + this.monitor.Info() + "Producent: " + this.producent +"\n";
        return s;
    }

    /**
     * Nadpisana metoda clone interfejsu Cloneable zwracająca sklonowany obiekt klasy Desktop
     * @return sklonowany obiekt klasy Desktop
     * @throws CloneNotSupportedException wyjątek możliwy do zwrócenia przez metodę
     */
    @Override
    public Desktop clone() throws CloneNotSupportedException{
        Desktop cloned = (Desktop)super.clone();
        cloned.monitor = this.monitor.clone();
        
        return cloned;
    }
    /**
     * Nadpisana metoda hashCode zwracająca hash obiektu klasy Desktop
     * @return hash obiektu klasy Desktop
     */
    @Override
    public int hashCode(){
        return Objects.hash(this);
    }

    /**
     * Nadpisana metoda equals sprawdzająca, czy dwa obiekty tej samej klasy są sobie równe
     * @param obj porównywany obiekt
     * @return wartość bool potwierdzająca że obiekty są równe lub nie
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Desktop other = (Desktop) obj;
        if (!Objects.equals(this.producent, other.producent)) {
            return false;
        }
        if (!Objects.equals(this.monitor, other.monitor)) {
            return false;
        }
        return true;
    }

    /**
     * Funkcja zwracająca rozdzielczość monitora
     * @return rozdzielczość monitora
     */
    
    public int getMonitorRozdzielczosc() {
        return this.monitor.getRozdzielczosc();
    }

    /** 
     * Funkcja zwracająca producenta
     * @return producent komputera
     */
    public String getProducent() {
        return producent;
    }

    /**
     * Funkcja ustawiająca rozdzielczość monitora desktopu
     * @param rozdzielczosc rozdzielczość monitora
     */
    public void setMonitorRozdzielczosc(int rozdzielczosc) {
        this.monitor.setRozdzielczosc(rozdzielczosc);
    }

    /**
     * Funkcja ustawiająca producenta desktopu
     * @param producent 
     */
    public void setProducent(String producent) {
        this.producent = producent;
    }
    
    
    
    
}
