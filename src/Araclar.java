public class Araclar {
    private static final int sure=100;

    public static void bekle(int sure){
        try {
            Thread.sleep(sure);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void bekle(){
        try {
            Thread.sleep(sure);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void kapali(){
        System.out.println("---------- S İ S T E M  K A P A L I ----------");
    }
    public static void acilisTesti(){
        System.out.println("Soğutucu açılış testi yapılıyor.");
    }
    public static void algilama(){
        System.out.println("Kullanıcı algılanıyor...");
    }
    public static void servisDisi(){
        System.out.println("Sistem şu anda servis dışı.");
    }
    public static void islemYapiliyor(){
        System.out.println("İşlem yapılıyor. Bekleyiniz...");
    }
}
