package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {

        return list -> list != null && list.stream().allMatch(s -> s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0)));

    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evenValues = new ArrayList<>();

            for (Integer value : list) {
                if (value % 2 == 0) {
                    evenValues.add(value);
                }
            }

            list.addAll(evenValues);
        };


    }

    public Supplier<List<String>> filterCollection(List<String> values) {

        return () -> values.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0))) 
                .filter(s -> s.endsWith("."))
                .filter(s -> s.split("\\s+").length > 3)
                .collect(Collectors.toList());




    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        Map<String ,Integer> hehe = new HashMap<>();
        return x -> {

            for (String i : x) {

                hehe.put(i, i.length());

            }

            return hehe;
        };

    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (x , y ) -> {

            List<Integer> hehe = new ArrayList<>();
            hehe.addAll(x);
            hehe.addAll(y);
            return hehe;
        };
    }
}
