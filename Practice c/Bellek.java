package lab4c;
import java.util.ArrayList;

public class Bellek {
    private ArrayList<Process> processler;
    private int MAX;

    public Bellek(int MAX){
        processler=new ArrayList<Process>();
        this.MAX=MAX;
    }

    public boolean processYukle(Process p) throws  BellekDoluIstisna,AyniIDliProcessIstisna{
        if(this.processler.size()>MAX)
            throw new BellekDoluIstisna("Bellek Dolu, Process Eklenemedi");
        else if(processBul(p.getId())!=null)
            throw new AyniIDliProcessIstisna(p.getId()+" ID'li process beklekte zaten var");
        else 
            processler.add(p);
            System.out.println(p+" bellege yuklendi.");
        return true;
    }
    public boolean processCikar(String id) throws ProcessBitmediIstisna{
        Process ogr=processBul(id);
        if(ogr!=null){
            if(ogr.getkosmaSuresi()>0)
                throw new ProcessBitmediIstisna(ogr.getId()+" ID'li process henüz tamamlanmadı");
            else{
                processler.remove(ogr);
                System.out.println(id+" nolu process tamamlandığı için çıkarıldı");
                return true;
            }
        }
        System.out.println("Process Bellekte Değil");
        return false;
    }
    
    public Process processBul(String id){
        for (Process ogrenci : processler) {
            if (ogrenci.getId().compareTo(id) == 0) 
                return ogrenci;   
        }
        return null;
    }

    public void processIsle(String id,int sure){
        Process ogr=processBul(id);
        ogr.kosmaSuresiGuncelle(sure);
        if(ogr.getkosmaSuresi()<=0)
            try {
                processCikar(id);
        } catch (ProcessBitmediIstisna ex) {System.err.println(ex.toString()); }
    }
     
    public void bellekYazdir() {
        System.out.println("PROCESS LISTESI");
        if (processler.isEmpty()) 
            System.out.println("LISTE BOS");
        else{
            for (Process p : processler) 
                System.out.println(p);
        System.out.println("----------------------------");
        }  
    }        
}
