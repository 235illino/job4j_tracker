package collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("ssss@gmail.com", "Семенов Семен Семенович");
        map.put("tttt@gmail.com", "Тихонов Тихон Тихонович");
        map.put("iiiiii@gmail.com", "Иванов Ив Иваныч");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
