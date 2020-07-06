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
        } else {
            System.out.println("User not found");
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
        }  else {
            System.out.println("User not found");
        }
        return accounts.stream().filter(account -> account.getRequisite().equals(requisite)).findFirst().orElse(null);
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> accountSrc = Optional.of(findByRequisite(srcPassport, srcRequisite));
        Optional<Account> accountDest = Optional.of(findByRequisite(destPassport, destRequisite));
        boolean rsl = false;
        if (accountSrc.get().getBalance() < amount) {
            accountSrc.get().setBalance(accountSrc.get().getBalance() - amount);
            accountDest.get().setBalance(accountDest.get().getBalance() + amount);
            rsl = true;
        }
        return rsl;
    }
}
