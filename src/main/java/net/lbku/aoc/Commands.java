package net.lbku.aoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Objects;

@ShellComponent
public final class Commands {
    private final DayService dayService;

    @Autowired
    public Commands(DayService dayService) {
        this.dayService = Objects.requireNonNull(dayService);
    }

    @ShellMethod(key = "day-1", value = "Prints the output for Day 1")
    public String day1() {
        return dayService.getDay1Output();
    }
}
