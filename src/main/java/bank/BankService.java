package bank;

import java.util.*;
import java.util.stream.Collectors;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> accounts = new ArrayList<>();
        User user = findByPassport(passport);
        if (!Objects.isNull(user)) {
            accounts = users.get(user);
        }
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public User findByPassport(String passport) {
        return users.keySet().stream().filter(user -> user.getPassport().equals(passport)).findFirst().orElse(null);
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> accounts = new ArrayList<>();
        User user = findByPassport(passport);
        if (!Objects.isNull(user)) {
            accounts = users.get(user);
        }
        return accounts.stream().filter(account -> account.getRequisite().equals(requisite)).findFirst().orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account accountSrc = findByRequisite(srcPassport, srcRequisite);
        Account accountDest = findByRequisite(destPassport, destRequisite);
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
