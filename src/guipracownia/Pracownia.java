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
     * Pole klasy Pracownia zawierające tablicę stanowisk złożoną z obiektów klasy Desktop
     */
    private Desktop[] stanowiska;

    /**
     * Konstruktor parametryczny klasy Pracownia
     * @param limitStanowisk limit stanowisk
     * @param _stanowiska tablica stanowisk
     */
    public Pracownia(Desktop[] _stanowiska,int limitStanowisk) 
    {
        this.limitStanowisk = limitStanowisk;
        this.liczbaStanowisk = 0;
        this.stanowiska = new Desktop[limitStanowisk];
        for(int i=0; i<_stanowiska.length; i++)
        {
            this.stanowiska[i] = new Desktop(_stanowiska[i]);
            liczbaStanowisk++;
        }
        for(int i = liczbaStanowisk; i<limitStanowisk; i++){
            this.stanowiska[i] = new Desktop();
        }
        
    }
    /**
     * Drugi konstruktor parametryczny klasy Pracownia
     * @param limitStanowisk limit stanowisk
     */
    public Pracownia(int limitStanowisk)
    {
        this.limitStanowisk=limitStanowisk;
        this.liczbaStanowisk=0;
        this.stanowiska = new Desktop[limitStanowisk];
        for(int i=0; i<limitStanowisk; i++)
        {
            this.stanowiska[i] = new Desktop();
        }
    }

    /**
     * Konstruktor domniemany klasy Pracownia
     */
    public Pracownia() 
    {
        this.liczbaStanowisk = 0;
        this.limitStanowisk = 0;
        for(int i=0; i<limitStanowisk; i++)
        {
            this.stanowiska[i] = new Desktop();
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
        this.stanowiska = new Desktop[source.limitStanowisk];
        for(int i=0; i<source.stanowiska.length; i++)
        {
            this.stanowiska[i] = new Desktop(source.stanowiska[i]);
        }
        for(int i = source.liczbaStanowisk; i<source.limitStanowisk; i++)
        {
            this.stanowiska[i] = new Desktop();
        }
    }
    /**
     * Metoda dodająca stanowisko do pracowni
     * @param stanowisko dodawane stanowisko
     */
    void dodajStanowisko(Desktop stanowisko)
    {
        for(int i=0; i<limitStanowisk; i++)
        {
            if(stanowiska[i].equals(new Desktop()))
            {
                stanowiska[i] = new Desktop(stanowisko);
                liczbaStanowisk++;
                break;
            }
        }
    }
     /**
     * Metoda usuwająca stanowisko do pracowni
     * @param stanowisko usuwane stanowisko
     */
    void usunStanowisko(Desktop stanowisko)
    {
        for(int i=0; i<liczbaStanowisk; i++)
        {
            if(stanowiska[i].equals(stanowisko))
            {
                this.stanowiska[i] = new Desktop();
                this.liczbaStanowisk--;
                
                for(int j= i; j+1<limitStanowisk;j++)
                {
                    if(this.stanowiska[j+1]!= null)
                    {
                        this.stanowiska[j] = new Desktop(stanowiska[j+1]);
                        this.stanowiska[j+1]= new Desktop();
                    }
                }
                break;
            }
            
        }
        
    }
    /**
     * Przeciążona metoda usuwająca stanowisko do pracowni
     * @param index numer usuwanego stanowiska
     */
    void usunStanowisko(int index)
    {

        stanowiska[index] = new Desktop();
        this.liczbaStanowisk--;
            for(int j= index; j+1<limitStanowisk;j++)
            {
                if(this.stanowiska[j+1]!= null)
                {
                    this.stanowiska[j] = new Desktop(stanowiska[j+1]);
                    this.stanowiska[j+1]= new Desktop();
                }
            }
        
    }
    /**
     * Metoda wyświetlająca listę aktualnie zajętych stanowisk
     */
    void listaStanowisk()
    {
        for(int i = 0; i<liczbaStanowisk; i++)
        {
            System.out.println("Stanowisko nr: "+(i+1)+"\n"+stanowiska[i].Info()+"\n");
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
        for(int i=0; i<limitStanowisk;i++)
        {
            cloned.stanowiska[i] = this.stanowiska[i].clone();
        }
        
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
        
        for(int i=0; i<liczbaStanowisk;i++)
        {
            
            zapis+= this.stanowiska[i].getZasilanie() +"\n" + this.stanowiska[i].getCena()+"\n";
            
            zapis+= this.stanowiska[i].getMonitorRozdzielczosc() +"\n"+ this.stanowiska[i].getProducent()+"\n";
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
            while((line = cin.readLine())!=null)
            {
                //petla czyta po kolei linie z pliku dopoki sie nie skonczy
                if(i==0)
                {
                    this.limitStanowisk = Integer.parseInt(line);
                    i++;
                    this.stanowiska = new Desktop[limitStanowisk];
                    for(int n=0;n<this.limitStanowisk;n++)
                    {
                        this.stanowiska[n] = new Desktop();
                    }
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
                            
                            this.stanowiska[k].setZasilanie(Float.parseFloat(line));
                            j++;
                            break;
                        case 1:
                            this.stanowiska[k].setCena(Double.parseDouble(line));
                            j++;
                            break;
                        case 2:
                            this.stanowiska[k].setMonitorRozdzielczosc(Integer.parseInt(line));
                            j++;
                            break;
                        case 3:
                            this.stanowiska[k].setProducent(line);
                            j=0;
                            k++;
                            break;
                                    
                            
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
        this.stanowiska = new Desktop[limitStanowisk];
        for(int i = 0; i< limitStanowisk; i++)
        {
            stanowiska[i] = new Desktop(p.stanowiska[i]);
        }
        
        
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
        return stanowiska[index];
    }
    

}
