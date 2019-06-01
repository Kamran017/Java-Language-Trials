package lab4c;
public class Test_4c {
    public static void main(String[] args) {
    Bellek bellek=new Bellek(4);
    Process u1=new Process("1", "Word", 1);
    Process u2=new Process("2", "Excel", 5);
    Process u3=new Process("3", "GCC",2); 
    Process u4=new Process("4", "Flash", 8);
    Process u5=new Process("5", "PyCharm",5);
    Process u6=new Process("5", "Paint",7);// Aynı ID exception vermeli
   
    try{
        bellek.processYukle(u1); // sorunsuz ekler
        bellek.processYukle(u2); // sorunsuz ekler
        bellek.processYukle(u3); // sorunsuz ekler
        bellek.processYukle(u4); // sorunsuz ekler
    }
    catch(AyniIDliProcessIstisna aid){System.err.println(aid.toString());} 
    catch(BellekDoluIstisna aid) {System.err.println(aid.toString());} 
        
    bellek.bellekYazdir(); // 1, 2, 3 ve 4  yazılır 
 
    bellek.processIsle("3", 5); //bellekten çıkar
    bellek.processIsle("2", 1); //bellekten çıkmaz
    bellek.bellekYazdir(); // 1 ve 4 nolu process yazmalı
    
    try{
        bellek.processCikar("4");   //bellekten çıkamaz
    }catch(ProcessBitmediIstisna ex){System.err.println(ex.toString());}
    
    try{
        bellek.processYukle(u5); // 5 sorunsuz eklenebilecek
        bellek.processYukle(u6); // Aynı ID exception verecek
    }
    catch(AyniIDliProcessIstisna ex){System.err.println(ex.toString());} 
    catch (BellekDoluIstisna ex) {System.err.println(ex.toString());}   

    bellek.bellekYazdir(); // 1, 4 ve 5 nolu ürünleri yazmalı
    }   
}
