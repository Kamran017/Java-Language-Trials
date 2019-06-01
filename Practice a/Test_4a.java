package lab4a;
public class Test_4a {
    public static void main(String[] args) {
        // TODO code application logic here
        YurtYonetim yurtYonetim=new YurtYonetim(3);
        Ogrenci ogr1=new Ogrenci("1", "Ahmet", "ÖZ", 1000);
        Ogrenci ogr2=new Ogrenci("2","Ahmet","BOZ",1500);
        Ogrenci ogr3=new Ogrenci("3", "Ayşe", "TEZ", 2000);
        Ogrenci ogr4=new Ogrenci("4", "Ali", "OZTURK", 1500);
        Ogrenci ogr5=new Ogrenci("5", "Mehmet", "ÖZ", 1000);

        try{
            yurtYonetim.OgrenciEkle(ogr1);
            yurtYonetim.OgrenciEkle(ogr2);
            yurtYonetim.OgrenciEkle(ogr3);
            yurtYonetim.OgrenciEkle(ogr4); // kapasite dolu istisna  
        }
        catch(KapasiteDoluIstisna kp){System.err.println(kp.toString());}
        catch(AyniIDliOgrenciIstisna aid){System.err.println(aid.toString());}

        yurtYonetim.listeyazdir(); // 1, 2, 3 yazacak
        yurtYonetim.bordOde("2",1500);
        try{
            yurtYonetim.OgrenciCikar("2");//listeden çıkar
            yurtYonetim.OgrenciCikar("1");//istisna olacak
        }catch(BorcuOlanOgrenciAyrilamazIstisna br){System.err.println(br.toString());}
        
        yurtYonetim.bordOde("1", 1000);
        try{
            yurtYonetim.OgrenciCikar("1");
        }catch(BorcuOlanOgrenciAyrilamazIstisna br){System.err.println(br.toString());}
        
        yurtYonetim.borcArttir(1000);
        yurtYonetim.listeyazdir(); // 3 yazacak
        
        try{
            yurtYonetim.OgrenciEkle(ogr5);// 5 eklenecek
        }
        catch(KapasiteDoluIstisna kp){System.err.println(kp.toString());}
        catch(AyniIDliOgrenciIstisna aid){System.err.println(aid.toString());}
        
        try{
            yurtYonetim.OgrenciEkle(ogr3); // ID istisna olacak
        }
        catch(KapasiteDoluIstisna kp){System.err.println(kp.toString());}
        catch(AyniIDliOgrenciIstisna aid){System.err.println(aid.toString());}   

        yurtYonetim.listeyazdir();
    }   
}
