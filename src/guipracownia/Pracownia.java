package guipracownia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 * <i>Klasa Pracownia implementująca interfejsy Cloneable, Serializable</i>
 * @author <p>Marlena Domalewska</p>
 */
public class Pracownia implements Cloneable, Serializable{
    /**
     * Pole klasy Pracownia zawierające liczbę aktualnie zajętych stanowisk
     */
    private int liczbaStanowisk;
    /**
     * Pole klasy Pracownia zawierające limit stanowisk
     */
    private int limitStanowisk;
    /** 
     * Pole klasy Pracownia zawierające listę stanowisk złożoną z obiektów klasy Desktop
     */

    private LinkedList<Desktop> stanowiska;

    /**
     * Konstruktor parametryczny klasy Pracownia
     * @param limitStanowisk limit stanowisk
     * @param _stanowiska lista stanowisk
     */
    public Pracownia(LinkedList<Desktop> _stanowiska,int limitStanowisk) 
    {
        this.limitStanowisk = limitStanowisk;
        this.liczbaStanowisk = 0;
        this.stanowiska = new LinkedList<Desktop>(_stanowiska);

        
    }
    /**
     * Drugi konstruktor parametryczny klasy Pracownia
     * @param limitStanowisk limit stanowisk
     */
    public Pracownia(int limitStanowisk)
    {
        this.limitStanowisk=limitStanowisk;
        this.liczbaStanowisk=0;
        this.stanowiska = new LinkedList<Desktop>();
        for(int i=0; i<limitStanowisk; i++)
        {
            this.stanowiska.add(new Desktop());

        }

    }

    /**
     * Konstruktor domniemany klasy Pracownia
     */
    public Pracownia() 
    {
        this.liczbaStanowisk = 0;
        this.limitStanowisk = 0;
        this.stanowiska = new LinkedList<Desktop>();
        for(int i=0; i<limitStanowisk; i++)
        {

            this.stanowiska.add(new Desktop());
        }
        
    }
    /**
     * Konstruktor kopiujący klasy Pracownia
     * @param source kopiowany obiekt klasy Pracownia
     */
    public Pracownia(Pracownia source)
    {
        this.liczbaStanowisk = source.liczbaStanowisk;
        this.limitStanowisk = source.limitStanowisk;
        this.stanowiska = new LinkedList<Desktop>(source.stanowiska);

    }
    /**
     * Metoda dodająca stanowisko do pracowni
     * @param stanowisko dodawane stanowisko
     */
    void dodajStanowisko(Desktop stanowisko)
    {
        if(liczbaStanowisk < limitStanowisk)
        {
            this.stanowiska.add(liczbaStanowisk, stanowisko);
            this.stanowiska.remove(limitStanowisk);
            liczbaStanowisk++;
        }


    }
 
    /**
     * Przeciążona metoda usuwająca stanowisko do pracowni
     * @param index numer usuwanego stanowiska
     */
    void usunStanowisko(int index)
    {
        if(this.liczbaStanowisk>0)
        {
            this.stanowiska.remove(index);
            this.stanowiska.add(new Desktop());
            this.liczbaStanowisk--;
        }

        
    }
    /**
     * Metoda wyświetlająca listę aktualnie zajętych stanowisk
     */
    void listaStanowisk()
    {
        Iterator<Desktop> iter = stanowiska.iterator();
        int i=0;
        while(iter.hasNext()){
            i++;
            System.out.println("Stanowisko nr: "+(i+1)+"\n"+iter.next().Info()+"\n");
        }
   
    }
    /**
     * Nadpisana metoda clone interfejsu Cloneable zwracająca sklonowany obiekt klasy Pracownia
     * @return sklonowany obiekt klasy Pracownia
     * @throws CloneNotSupportedException wyjątek możliwy do zwrócenia przez metodę
     */
    @Override
    public Pracownia clone() throws CloneNotSupportedException
    {
        Pracownia cloned = (Pracownia)super.clone();
        cloned.stanowiska = (LinkedList<Desktop>) this.stanowiska.clone();

        return cloned;
    }
    /**
     * Metoda zapisująca aktualny stan obiektu klasy Pracownia do pliku 
     * @param plik plik do którego zapisywany jest stan
     * @throws FileNotFoundException wyjątek możliwy do zwrócenia przez metodę
     */
    public void zapisz(String plik) throws FileNotFoundException
    {
//        String zapis= "Limit stanowisk: "+limitStanowisk + "\nLiczba stanowisk: "+liczbaStanowisk+"\n";
//        for(int i=0; i<liczbaStanowisk;i++){
//            zapis += "\nStanowisko nr " + (i+1)+ ": \n"+this.stanowiska[i].Info();
//        }
//        
        String zapis = limitStanowisk +"\n" + liczbaStanowisk +"\n";
        Iterator<Desktop> iter = stanowiska.iterator();
        while(iter.hasNext())
        {
            Desktop stan = iter.next();
            zapis+= stan.getZasilanie() +"\n" + stan.getCena()+"\n";
            zapis+= stan.getMonitorRozdzielczosc() +"\n"+ stan.getProducent()+"\n";
        }
 
       PrintWriter outText = new PrintWriter(plik);
       try
       {
            outText.println(zapis);
            outText.close();
       }
       catch(Exception e){
           System.out.println(e.toString());
       }

    }
     /**
     * Metoda wczytująca i wyświetlająca aktualny stan obiektu klasy Pracownia do pliku 
     * @param plik plik z którego odczytywany jest stan
     */
    public void wczytaj(String plik)
    {
        String line;
         FileInputStream fin = null;
        
        try
        {
            //utwrozenie strumienia
            fin = new FileInputStream(plik); //strumien z pliku
            
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        
        //utworzenie strumienia do czytania z pliku
        BufferedReader cin = new BufferedReader(new InputStreamReader(fin));
        
        try
        {
            int i = 0,j=0, k=0; //zmienna pomocnicza
            Desktop stan = new Desktop();
            while((line = cin.readLine())!=null)
            {
                //petla czyta po kolei linie z pliku dopoki sie nie skonczy
                if(i==0)
                {
                    this.limitStanowisk = Integer.parseInt(line);
                    i++;
                    this.stanowiska = new LinkedList<Desktop>();

                }
                else if(i==1)
                {
                    this.liczbaStanowisk = Integer.parseInt(line);
                    i++;
                }
                else if(i>1 && k<this.liczbaStanowisk)
                {
                    
                    switch(j)
                    {
                        
                        case 0:
                            stan = new Desktop();
                            stan.setZasilanie(Float.parseFloat(line));
                            j++;
                            break;
                        case 1:
                            stan.setCena(Double.parseDouble(line));
                            j++;
                            break;
                        case 2:
                            stan.setMonitorRozdzielczosc(Integer.parseInt(line));
                            j++;
                            break;
                        case 3:
                            stan.setProducent(line);
                            j=0;
                            k++;
                            this.stanowiska.add(stan);
                            break;
                                    
                            
                    }
                    
                    
                }
                else if(k<limitStanowisk)
                {
                    for(int x=liczbaStanowisk; x<limitStanowisk; x++)
                    {
                        this.stanowiska.add(new Desktop());
                    }
                }


                
                //System.out.println(line);
            }
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        
    }
    /**
     * Metoda serializująca obiekt klasy Pracownia do pliku
     * @param plik plik w którym zostanie zapisany zserializowany obiekt klasy Pracownia
     */
    public void zapiszSerial(String plik)
    {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try
        {
            fileOut = new FileOutputStream(plik);
            out = new ObjectOutputStream(fileOut);
        }
        catch(IOException e)
        {
            System.out.println(e.toString());
            System.exit(-1);
        }
        
        try 
        {
         
         out.writeObject(this);
         out.close();
         fileOut.close();

        } 
        catch (IOException i)
        {
         System.out.println(i.toString());
        }
    }
    /**
     * Metoda deserializująca obiekt klasy Pracownia z pliku
     * @param plik plik z którego zostanie zdeserializowany obiekt klasy Pracownia
     * 
     */
    public void wczytajSerial(String plik) 
    {
        Pracownia p = null;
        FileInputStream fileIn = null;
        ObjectInputStream in = null;
        try
        {
            fileIn = new FileInputStream(plik);
            in = new ObjectInputStream(fileIn);
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e.toString());
        } 
        catch (IOException ex) 
        {
            System.out.println(ex.toString());
        }
        
        try 
        {
            p = (Pracownia) in.readObject();
            in.close();
            fileIn.close();
        } 
        catch (IOException i) 
        {
            System.out.println(i.toString());

        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println(c.toString());

        }
        
        this.liczbaStanowisk = p.liczbaStanowisk;
        this.limitStanowisk = p.limitStanowisk;
        this.stanowiska = new LinkedList<Desktop>(p.stanowiska);

        
        
    }

    /**
     * Funkcja zwracająca liczbe stanowisk
     * @return liczba stanowisk
     */
    public int getLiczbaStanowisk() 
    {
        return liczbaStanowisk;
    }

    /**
     * Funkcja ustawiająca liczbę stanowisk
     * @param liczbaStanowisk liczba stanowisk
     */
    public void setLiczbaStanowisk(int liczbaStanowisk)
    {
        this.liczbaStanowisk = liczbaStanowisk;
    }

    /**
     * Funkcja zwracająca limit stanowisk
     * @return limit stanowisk
     */
    public int getLimitStanowisk()
    {
        return limitStanowisk;
    }

    /**
     * Funkcja ustawiająca limit stanowisk
     * @param limitStanowisk limit stanowisk
     */
    public void setLimitStanowisk(int limitStanowisk) 
    {
        this.limitStanowisk = limitStanowisk;
    }
    
    public Desktop getStanowisko(int index)
    {
        return stanowiska.get(index);
    }
    

}
