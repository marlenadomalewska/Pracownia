package guipracownia;

import java.io.Serializable;
import java.util.Objects;

/**
 * <i>Klasa Monitor implementująca interfejsy Cloneable, Serializable</i>
 * @author <p>Marlena Domalewska</p>
 */

public class Monitor implements Cloneable, Serializable{
    /**
     * Pole klasy Monitor zawierające wartośc rozdzielczości
     */
    private int rozdzielczosc;
    /**
     * Konstruktor domniemany klasy Monitor
     */
    public Monitor(){
        this.rozdzielczosc = 0;
    }

    /**
     * Konstruktor parametryczny klasy Monitor
     * @param rozdzielczosc rozdzielczość monitora
     */
    public Monitor(int rozdzielczosc) {
        this.rozdzielczosc = rozdzielczosc;
    }
    /**
     * Konstruktor kopiujący klasy Monitor
     * @param source kopiowany obiekt klasy Monitor
     */
    public Monitor(Monitor source){
        this.rozdzielczosc = source.rozdzielczosc;
    }
    /**
     * Metoda zwracająca ciąg znaków zawierający informacje o obiekcie klasy Monitor
     * @return string
     */
    String Info(){
        String s = new String();
        s = "Rozdzielczosc monitora: " + rozdzielczosc +"\n";
        return s;
    }

  
   /**
    * Nadpisana metoda clone interfejsu Cloneable klonująca obiekt klasy Monitor
    * @return sklonowany obiekt klasy Monitor
    * @throws CloneNotSupportedException wyjątek możliwy do zwrócenia przez metodę
    */
    @Override
    public Monitor clone() throws CloneNotSupportedException{
        return (Monitor)super.clone();
    }
    /**
     * Nadpisana metoda hashCode zwracająca hash obiektu klasy Monitor
     * @return hash obiektu klasy Monitor
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
        final Monitor other = (Monitor) obj;
        if (this.rozdzielczosc != other.rozdzielczosc) {
            return false;
        }
        return true;
    }

    /**
     * funkcja zwracająca rozdzielczość monitora
     * @return rozdzielczość monitora
     */
    public int getRozdzielczosc() {
        return rozdzielczosc;
    }

    /**
     * Funkcja ustawiająca rozdzielczość monitora
     * @param rozdzielczosc rozdzielczość monitora
     */
    public void setRozdzielczosc(int rozdzielczosc) {
        this.rozdzielczosc = rozdzielczosc;
    }
    
    
    
    

}
