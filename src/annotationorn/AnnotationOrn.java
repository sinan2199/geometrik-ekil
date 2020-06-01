
package annotationorn;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface GeoBilgi {
    public String sekilismi();
    public int kenarSayisi();
}
@GeoBilgi (sekilismi = "Düzgün sekizgen", kenarSayisi = 8)//geometrik şekilin bilgileri girildi

class GeometrikSekil {//
    public int icAci(int kenar){
        return (180 * (kenar - 2)) / kenar;
    }
    public int kosegenSayisi(int kenar) {
        return (kenar * (kenar - 3)) / 2;
    }
}
    class AnnotationOrn {
    public static void main(String[] args) {
        GeometrikSekil g=new GeometrikSekil();
        GeoBilgi annotation = g.getClass().getAnnotation(GeoBilgi.class);//annotation bilgilerimizi oluşturduğumuz nesne içerisine aldık
        int aci=g.icAci(annotation.kenarSayisi());//kenar sayısını annotation içerisinden aldırarak geometrik şeklimizin iç açısını bulduk
        int kosegen=g.kosegenSayisi(annotation.kenarSayisi());//yine kenar sayısını annotationdan alarak köşegen sayısını bulduk
        System.out.println(annotation.sekilismi()+":");
        System.out.println("Bir iç açısı = "+ aci);
        System.out.println("İçerisinden geçen toplam köşegen sayısı = "+ kosegen);
    }
    
}
