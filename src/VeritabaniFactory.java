public class VeritabaniFactory implements IVeritabaniFactory{

    @Override
    public ICihazBilgiSistemi factoryMethod(String str) {
        CihazBilgiSistemi cihazBilgiSistemi;
        if(str.equals(("MySql"))) {
            cihazBilgiSistemi =  new CihazBilgiSistemi(new MySqlSurucu());
        }
        else
            throw new RuntimeException("Geçerli bir veritabanı değil.");
        return cihazBilgiSistemi;
    }

}
