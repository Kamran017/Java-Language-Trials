package lab4b;
import java.util.ArrayList;

public class Sepet {
private ArrayList<Urun> mevcutOgrenciler;

public Sepet(){
    mevcutOgrenciler=new ArrayList<Urun>();
}

public boolean urunEkle(Urun urun) throws  AyniIDliUrunIstisna, UrunAdetIstisna{
    if (mevcutUrunBul(urun.getId())!=null) {
        throw new AyniIDliUrunIstisna(urun.getId()+" id ile urun kaydı var");
    }
    else if(urun.getAdet()>5){
        throw new UrunAdetIstisna("Urun Adeti En Fazla 5 Olmalı,"+urun.getId()+" ID'li urun eklenmedi");
    } 
    else {
        mevcutOgrenciler.add(urun);
        System.out.println(urun+" sepete eklendi.");
    }
    return true;
}

public boolean urunCikar(String id){
    Urun ogr=mevcutUrunBul(id);
    if(ogr!=null){
        mevcutOgrenciler.remove(ogr);
        System.out.println(id+" nolu ürün çıkarıldı");
        return true;
    }
    return false;
}

public Urun mevcutUrunBul(String id){
    for (Urun ogrenci : mevcutOgrenciler) {
        if (ogrenci.getId().compareTo(id) == 0) {
            return ogrenci;
        }
    }
    return null;
}

public void adetGuncelle(String id,int adet) throws UrunAdetIstisna{
    Urun ogr=mevcutUrunBul(id);
    if(ogr.getAdet()+adet<=0){
        urunCikar(ogr.getId());
        throw new UrunAdetIstisna("Urun Adeti En Az 1 Olmalı,"+id+" ID'li Urun Sepetten Cıkarıldı");
    }
    else if(ogr.getAdet()+adet>5){
        ogr.setAdet(5);
        System.out.println("Urun Adeti En Fazla 5 Olabilir, Urun Sayısı 5 Yapıldı");
    }
    else ogr.adetGuncelle(adet);    
}

public void sepetYazdir() {
    System.out.println("URUN LISTESI");
    if (mevcutOgrenciler.isEmpty())
        System.out.println("liste boş.");
    else{
        for (Urun urun : mevcutOgrenciler) 
            System.out.println(urun);
    System.out.println("----------------------------");
    }   
}        
}
