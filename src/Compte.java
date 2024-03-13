import java.math.BigInteger;

public class Compte {
    private String titular;
    private String numCompte;

    public Compte() {
        this.titular = "";
        this.numCompte = "";
    }

    public boolean compruebaIBAN(String IBAN) {
        String IBANsinES = IBAN.substring(2);
        String IBansinNumControl = IBANsinES.substring(2);
        BigInteger numIBAN2 , num98, num97; //Declaramos la variable BigInteger
        BigInteger numControlBig;
        numIBAN2 = new BigInteger(IBansinNumControl + "142800"); //Pasamos el string a BigInteger
        num98 = new BigInteger("98"); //Pasamos el string a BigInteger
        num97 = new BigInteger("97"); //Pasamos el string a BigInteger
        numControlBig = num98.subtract(numIBAN2.mod(num97));
        //Substrac es la resta, mod es el modulo
        String numControl = String.valueOf(numControlBig);
        String numControlpasado = IBANsinES.substring(0, 2);

        if (numControl != null && numControl.equals(numControlpasado)) {
            return true;
        } else {
            return false;
        }
    }

    public String generaIBAN(String entitat, String oficina, String dc, String compte) {
        String numIBAN = "";
        if (entitat.length() == 4 && oficina.length() == 4 && dc.length() == 2 && compte.length() == 10) {
            numIBAN = entitat.concat(oficina).concat(dc).concat(compte);
        } else {
            System.out.println("Numero incorrecto.");
        }
         numIBAN = numIBAN.concat("142800");
        BigInteger numIBAN2 , num98, num97; //Declaramos la variable BigInteger
        BigInteger numControlBig;
        numIBAN2 = new BigInteger(numIBAN); //Pasamos el string a BigInteger
        num98 = new BigInteger("98"); //Pasamos el string a BigInteger
        num97 = new BigInteger("97"); //Pasamos el string a BigInteger

        numControlBig = num98.subtract(numIBAN2.mod(num97)); //Substrac es la resta, mod es el modulo
        String numControl = String.valueOf(numControlBig);

        return "ES".concat(numControl).concat(entitat).concat(oficina).concat(dc).concat(compte);
    }
}
