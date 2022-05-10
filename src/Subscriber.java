public class Subscriber implements  IObserver{
    String name;
    public Subscriber(String name){
        this.name = name;
    }
    @Override
    public void update(String mesaj) {
        System.out.println(name+" kullanıcısına gelen mesaj -> "+mesaj);
    }
}
