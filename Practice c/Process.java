package lab4c;
public class Process{
private String id;
private String ad;
private int kosmaSuresi;

public Process(String id,String ad, int Sure){
    this.id=id;
    this.ad=ad; 
    this.kosmaSuresi=Sure;
}

public void setSure(int Sure) {
    this.kosmaSuresi = Sure;
}

public String getId(){
    return this.id;
}

public int getkosmaSuresi() {
    return kosmaSuresi;
}

public void kosmaSuresiGuncelle(int a){
    this.kosmaSuresi-=a;    
}

@Override
public String toString(){
    return "[ID: "+id+", AD: "+ad+", KOSMA SURESİ:"+kosmaSuresi+" ]";
}
}
