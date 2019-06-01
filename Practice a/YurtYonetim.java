package lab4a;
import java.util.ArrayList;
public class YurtYonetim {

    private final ArrayList<Ogrenci> mevcutOgrenciler;
    private int MAX;

    public YurtYonetim(int MAX){
        mevcutOgrenciler=new ArrayList<>();
        this.MAX=MAX;
    }

    public boolean OgrenciEkle(Ogrenci ogrenci) throws KapasiteDoluIstisna, AyniIDliOgrenciIstisna{
        if(mevcutOgrenciler.size()==MAX)
            throw new KapasiteDoluIstisna("Yurt kapasitesi doldu");
        else if (mevcutOgrenciBul(ogrenci.getId())!=null)
            throw new AyniIDliOgrenciIstisna("Bu id ile öğrenci kaydı yapılmış");
        else {
            mevcutOgrenciler.add(ogrenci);
            System.out.println(ogrenci.getId()+" nolu öğrenci eklendi");
        }
        return true;
    }
    public boolean OgrenciCikar(String id)throws BorcuOlanOgrenciAyrilamazIstisna{
        Ogrenci ogr=mevcutOgrenciBul(id);
        if(ogr!=null){
            if(!ogr.borcKontrol())
                throw new BorcuOlanOgrenciAyrilamazIstisna("Borcu Olan Öğrenci yurttan ayrilamaz");
            else
                mevcutOgrenciler.remove(ogr);
        return true;
        }
        return false;
    }

    public Ogrenci mevcutOgrenciBul(String id) {
        for (Ogrenci ogrenci : mevcutOgrenciler) {
            if (ogrenci.getId().compareTo(id) == 0)
                return ogrenci;
        }
        return null;
    }

    public void borcArttir(double miktar){
        for(Ogrenci ogrenci:mevcutOgrenciler)
            ogrenci.borcEkle(miktar);
    }
    public void bordOde(String id,double miktar){
        Ogrenci ogr=mevcutOgrenciBul(id);
        if(ogr!=null)
            ogr.borcOde(miktar);
    }

    public void listeyazdir() {
        System.out.println("OGRENCİ LISTESI");
        if (mevcutOgrenciler.isEmpty())
            System.out.println("liste boş.");
        else{
            for (Ogrenci ogrenci : mevcutOgrenciler)
                System.out.println(ogrenci);
            System.out.println("----------------------------");
        }
    }
}