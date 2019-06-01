package lab4a;

import java.io.Serializable;

public class Ogrenci implements Serializable{
    private String id;
    private String ad;
    private String soyad;
    private double borc;
    
    public Ogrenci(String id,String ad,String soyad,double borc){
        this.id=id;
        this.ad=ad;
        this.soyad=soyad;
        this.borc=borc;     
    }
    public String getId(){
        return this.id;
    }
    
    public void borcEkle(double miktar){
        this.borc+=miktar;
    }
    public void borcOde(double miktar){
        this.borc-=miktar;
    }
    
    public boolean borcKontrol(){
        return borc==0;
    }
    
    @Override
    public String toString(){
        return "[ID: "+id+", AD: "+ad+", SOYAD: "+soyad+", BORÇ: "+borc+" ]";
    }
}
