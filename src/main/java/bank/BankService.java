package bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> accounts = new ArrayList<>();
        User user = findByPassport(passport);
        if (Objects.isNull(user)) {
            accounts = users.get(user);
        }
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
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

    public Account findByRequisite(String passport, String requisite) throws NullPointerException {
        Account accountFind = null;
        List<Account> accounts = new ArrayList<>();
        User user = findByPassport(passport);
        if (Objects.isNull(user)) {
            accounts = users.get(user);
        }
        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                accountFind = account;
                break;
            }
        }
        return accountFind;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String dеstRequisite, double amount) {
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, dеstRequisite);
        boolean rsl = false;
        if (!(Objects.isNull(accountSrc) || Objects.isNull(accountDest)
                || accountSrc.getBalance() < amount)) {
            accountSrc.setBalance(accountSrc.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
