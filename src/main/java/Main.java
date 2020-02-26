import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] argc)throws Exception{
        ArrayList<Ulamek> ulamki = new ArrayList<Ulamek>();
        ulamki = fromTxtToTab1();
        //double[] mianownik = fromTxtToTab2();
        ArrayList<Integer> minimalny = minimalny(ulamki);
        System.out.println(minimalny.get(0)+"/"+minimalny.get(1));
        int ile = ileNieskracalnych(ulamki);
        System.out.println(ile);
        int sumaLicznikow = sumujLiczniki(ulamki);
        System.out.println(sumaLicznikow);
        int licznikAB = wyznaczLicznikab(ulamki);
        System.out.println(licznikAB);
    }
    public static ArrayList<Ulamek> fromTxtToTab1()throws Exception{
        Scanner scanner = new Scanner(new File("C:\\Users\\spinarak\\Desktop\\dane\\65\\dane_ulamki.txt"));
        ArrayList<Ulamek> ulamki = new ArrayList<Ulamek>();
        while(scanner.hasNextDouble()){
            ulamki.add(new Ulamek(scanner.nextInt(), scanner.nextInt()));
            //System.out.println(licznik[i]);
            //mianownik[i] = scanner.nextInt();
            //System.out.println(mianownik[i]);
        }
        return ulamki;
    }
    /*public static double[] fromTxtToTab2()throws Exception{
        Scanner scanner = new Scanner(new File("C:\\Users\\spinarak\\Desktop\\dane\\65\\dane_ulamki.txt"));
        double[] mianownik = new double[1000];
        for(int i=0; i<1000; i++){
            scanner.nextDouble();
            mianownik[i] = scanner.nextDouble();
            System.out.println(mianownik[i]);
        }
        return mianownik;
    }*/
    public static ArrayList<Integer> minimalny(ArrayList<Ulamek> ulamki){
        //double minimalny[] = new double[2];
        ArrayList<Integer> minimalny = new ArrayList<Integer>();
        minimalny.add(0, ulamki.get(0).getLicznik());
        minimalny.add(1, ulamki.get(0).getMianownik());
        //System.out.print(licznik[0]/mianownik[0]);
        for(int i = 0; i<ulamki.size(); i++){
            if(ulamki.get(i).getWartosc() < (double)minimalny.get(0)/(double)minimalny.get(1)){
                minimalny.add(0, ulamki.get(i).getLicznik());
                minimalny.add(1, ulamki.get(i).getMianownik());
            }
            else if((double)ulamki.get(i).getLicznik()/ulamki.get(i).getMianownik() == (double)minimalny.get(0)/minimalny.get(1)){
                if(ulamki.get(i).getMianownik() < minimalny.get(1)){
                    minimalny.add(0, ulamki.get(i).getLicznik());
                    minimalny.add(1, ulamki.get(i).getMianownik());
                }
            }
        }
        return minimalny;
    }
    public static int nwd(int licznik, int mianownik){
        if(licznik<0)
            licznik=-licznik;
        if(mianownik<0)
            mianownik=-mianownik;
        if (mianownik==0)
            return licznik;
        return nwd(mianownik,licznik%mianownik);
    }
    public static int ileNieskracalnych(ArrayList<Ulamek> ulamki){
        int ile = 0;
        for(int i=0;i<ulamki.size();i++){
            if (nwd(ulamki.get(i).getLicznik(),ulamki.get(i).getMianownik())==1)
                ile++;
        }
        return ile;
    }
    public static int sumujLiczniki(ArrayList<Ulamek> ulamki){
        int sumaLicznikow = 0;
        for(int i=0; i<ulamki.size(); i++){
            sumaLicznikow = sumaLicznikow + ulamki.get(i).getLicznik()/nwd(ulamki.get(i).getLicznik(), ulamki.get(i).getMianownik());
        }
        return sumaLicznikow;
    }
    public static int wyznaczLicznikab(ArrayList<Ulamek> ulamki){
        int licznikB = 0;
        int mianownikB = 2*2*3*3*5*5*7*7*13;
        for(int i=0; i<ulamki.size(); i++){
            licznikB += ulamki.get(i).getLicznik() * mianownikB/ulamki.get(i).getMianownik();
        }
        return licznikB;
    }
}
