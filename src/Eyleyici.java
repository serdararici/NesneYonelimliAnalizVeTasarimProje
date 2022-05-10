import java.util.Scanner;

public class Eyleyici implements IEyleyici {

    @Override
    public void sogutucuAc(ISicaklikAlgilayici sicaklikAlgilayici, int sicaklik, ITusTakimi tusTakimii, IEkran ekran) {
        System.out.println("Şu anda sıcaklık: " + sicaklik);
        System.out.print("Kaç derece soğutmak istiyorsunuz? -> ");
        //Scanner scanner = new Scanner(System.in);
        int sogutmaMiktari = tusTakimii.veriAl();//Integer.parseInt(scanner.next());
        //SicaklikAlgilayici sicaklikAlgilayici = new SicaklikAlgilayici();
        //int yeniSicaklik = sicaklikAlgilayici.sicaklikOku() - sogutmaMiktari;
        System.out.println("***************Soğutucu açıldı.***************");
        //AgArayuzu agArayuzu = new AgArayuzu();
        //int yeniSicaklik = sicaklikAlgilayici.sicaklikOku() - sogutmaMiktari;
        int yeniSicaklik = sicaklik - sogutmaMiktari;
        System.out.println("Yeni sıcaklık " + yeniSicaklik + " C° olacaktır.");

    }

    @Override
    public void sogutucuKapat() {
        System.out.println("**********Soğutucu kapatıldı.***********");
        System.out.println("Sıcaklık başlangıç değerine dönüyor.");
    }
}
