package pl.javastart.task;

import pl.javastart.task.contract.CardContract;
import pl.javastart.task.contract.MixContract;
import pl.javastart.task.contract.SubscribtionContract;

public class Main {

    public static void main(String[] args) {
        Phone phone1 = new Phone(new MixContract(10));
        phone1.call(5300);
        phone1.printAccountState();

        Phone phone2 = new Phone(new CardContract(200));
        phone2.call(1000);
        phone2.printAccountState();

        Phone phone3 = new Phone(new SubscribtionContract());
        phone3.sendSms();
        phone3.sendSms();
        phone3.sendSms();
        phone3.sendSms();
        phone3.call(100);
        phone3.call(20000);
        phone3.call(11100);
        phone3.call(1300);
        phone3.printAccountState();
        
    }
}
