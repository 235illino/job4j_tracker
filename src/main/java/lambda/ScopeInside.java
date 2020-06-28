package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            int sum = total;
            total = add(
                    () -> sum + num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }

    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {

        List<Double> diapasonList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            diapasonList.add(func.apply((double) i));
        }
        return diapasonList;
    };

}
