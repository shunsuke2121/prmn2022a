package ex4;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;

public class ATM {
        private List<Account> accounts;
        public ATM(){
            this.accounts = new ArrayList<>();
        }
        public void resisterAccount(String name,String number){
            var annount = new Account(name,number);
            this.accounts.add(annount);
            System.out.println(name + " さんを口座番号:" + number + " で登録");
        }
        public boolean existAccount(String name, String number){
            for(Account account : accounts){
                if(account.getName().equals(name) && account.getNumber().equals(number)){
                    System.out.println("ある");
                    return true;
                }
            }
            System.out.println("ない");
            return false;
        }
        public void deposit(String number,long money){
        for (Account account : accounts){
            if(account.getNumber().equals(number)){
                account.setBalance(account.getBalance()+money);
                return;
            }
            System.out.println("ない");
            return;
        }
        }
        public long withdraw(String number,long money){
            for (Account account : accounts) {
                if (account.getNumber().equals(number)) {
                    long newbalance = account.getBalance() - money;
                    if (newbalance < 0) {
                        System.out.println("口座番号:" + number + " から " + money + " 円引き出せませんでした。残高:" + account.getBalance() + " 円です。");
                        return 0;
                    } else {
                        account.setBalance(newbalance);
                        System.out.println("口座番号:" + number + " から " + money + " 円引き出しました。残高:" + newbalance + " 円です。");
                        return money;
                    }
                }
            }
                System.out.println("ない");
                return 0;
            }
        }

