package lab4b;
public class Test_4b {

public static void main(String[] args) {
Sepet sepetim=new Sepet();
Urun u1=new Urun("1", "Kalem", 1);
Urun u2=new Urun("2", "Silgi", 5);
Urun u3=new Urun("3", "Defter",2); 
Urun u4=new Urun("4", "Kitap", 13);
Urun u5=new Urun("5", "Cetvel",5);
Urun u6=new Urun("5", "Pergel",7);// Aynı ID exception vermeli

try{
    sepetim.urunEkle(u1); // sorunsuz ekler
    sepetim.urunEkle(u2); // sorunsuz ekler
    sepetim.urunEkle(u3); // sorunsuz ekler
    sepetim.urunEkle(u4); // 13 tane ürün olamaz eklemeyecek
}
catch(AyniIDliUrunIstisna aid){System.err.println(aid.toString());}
catch(UrunAdetIstisna aid){System.err.println(aid.toString());}   

sepetim.sepetYazdir(); // 1, 2 ve 3 yazılır 
try{
    sepetim.adetGuncelle("3", +5); // Urun adeti 5'i geçtiği için adet=5 olacak
    sepetim.adetGuncelle("2", -5); // Exception verip ürünü silecek
}
catch(UrunAdetIstisna aid){System.err.println(aid.toString());}

sepetim.sepetYazdir(); // 1 ve 3 nolu ürün yazmalı
sepetim.urunCikar("3"); 
try{
    sepetim.urunEkle(u5); // 5 sorunsuz eklenebilecek
    sepetim.urunEkle(u6); // Aynı ID exception verecek
}
catch(AyniIDliUrunIstisna aid){System.err.println(aid.toString());}  
catch(UrunAdetIstisna aid){System.err.println(aid.toString());} 
sepetim.sepetYazdir(); // 1 ve 5 nolu ürünleri yazmalı
}   
}
