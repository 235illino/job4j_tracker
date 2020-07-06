package bank;

import java.util.*;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        List<Account> accounts = new ArrayList<>();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            accounts = users.get(user.get());
        }
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = Optional.empty();
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = Optional.of(user);
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> accounts = new ArrayList<>();
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            accounts = users.get(user.get());
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
