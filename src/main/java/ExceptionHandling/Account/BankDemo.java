package ExceptionHandling.Account;

public class BankDemo {
    public static void main(String[] args) {


        Bank bank = new Bank();

        try{
            bank.addAccount("musterfrau",500,500);
            bank.addAccount("mustermann",3000,1000);

            System.out.println(bank);

            bank.transfer("musterfrau","mustermann",100);
            bank.transfer("mustermann","musterfrau",750);

            System.out.println(bank);

        }catch (BankException | AccountNotFoundException e){
            e.printStackTrace();
        }
    }
}
