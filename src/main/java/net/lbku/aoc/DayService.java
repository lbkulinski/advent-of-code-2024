package net.lbku.aoc;

import com.google.common.collect.TreeMultiset;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@Service
public final class DayService {
    public String getDay1Output() throws Exception {
        Path path = Path.of("src/main/resources/input/day1.txt");

        TreeMultiset<Integer> numbers = TreeMultiset.create();

        Map<Integer, Integer> numbersToCounts = new HashMap<>();

        Files.readAllLines(path)
             .stream()
             .map(line -> line.split("\\s+"))
             .forEach(tokens -> {
                 if (tokens.length != 2) {
                     throw new IllegalStateException("A line does not contain two tokens");
                 }

                 int left = Integer.parseInt(tokens[0]);

                 numbers.add(left);

                 int right = Integer.parseInt(tokens[1]);

                 numbersToCounts.compute(right, (key, value) -> (value == null) ? 1 : value + 1);
             });

        int sum = 0;

        for (int number : numbers) {
            int frequency = numbersToCounts.getOrDefault(number, 0);

            int product = Math.multiplyExact(number, frequency);

            sum = Math.addExact(sum, product);
        }

        return String.valueOf(sum);
    }
}
