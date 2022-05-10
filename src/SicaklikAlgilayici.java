import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici{
    int sicaklik = 0;
    @Override
    public int sicaklikOku() {
        Random random = new Random();
        sicaklik = random.nextInt(-20,45);
        return sicaklik;
    }
}


/*double[] sicakliklar = new double[]{-20,-19,-18,-17,-16,-15,-14,-13,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,
                0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35};
        Random random = new Random();
        int i = random.nextInt(55);
        double sicaklik = sicakliklar[i];
        return sicaklik;*/
