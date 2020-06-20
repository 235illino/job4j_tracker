package bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);


    }

    public User findByPassport(String passport) {
        User userFind = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                userFind = user;
                break;
            }
        }
        return userFind;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account accountFind = null;
        List<Account> accounts = users.get(findByPassport(passport));
        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                accountFind = account;
            }
        }
        return accountFind;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        boolean rsl = true;

        if (Objects.isNull(findByRequisite(srcPassport, srcRequisite)) || Objects.isNull(findByRequisite(destPassport, dеstRequisite))
                || findByRequisite(srcPassport, srcRequisite).getBalance() < amount) {
            rsl = false;
        }
        return rsl;
    }
}
