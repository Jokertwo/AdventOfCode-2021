package org.jokertwo.adventofcode.task.impl.task11;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import org.jokertwo.adventofcode.common.FileReader;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class DumboOctopus extends AbstractDumboOctopus {

    public DumboOctopus(FileReader fileReader) {
        super(fileReader);
    }


    @Override
    public boolean solve() {
        List<String> lines;
        try {
            lines = readFile();
        } catch (IOException e) {
            log.error("Unable to read from file: {}", FILE, e);
            return false;
        }
        int[][] matrix = convertToMatrix(lines);
        int totalFlash = 0;
        for (int i = 0; i < 100; i++) {
            Stack<Index> toBeFlashed = new Stack<>();
            increase(matrix, toBeFlashed);
            while (!toBeFlashed.empty()) {
                totalFlash++;
                processIndex(toBeFlashed, matrix);
            }
        }
        result = totalFlash;
        return true;
    }


    @Override
    public String getName() {
        return "Task 11a";
    }


    @Override
    public int getOrder() {
        return 210;
    }
}
