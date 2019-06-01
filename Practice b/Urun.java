package lab4b;
public class Urun{
    private String id;
    private String ad;
    private int adet;
    
    public Urun(String id,String ad, int adet){
        this.id=id;
        this.ad=ad; 
        this.adet=adet;
    }
    
    public void setAdet(int adet) {
        this.adet = adet;
    }
    
    public String getId(){
        return this.id;
    }
    
    public int getAdet() {
        return adet;
    }
    
    public void adetGuncelle(int a){
        this.setAdet(this.getAdet() + a);    
    }
    
    @Override
    public String toString(){
        return "[ID: "+id+", AD: "+ad+", ADET:"+adet+" ]";
    }
}
