package pairmatching.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public List<String> readNames(String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String input;
        List<String> names = new ArrayList<>();
        while ((input = bufferedReader.readLine()) != null) {
            names.add(input);
        }
        return names;
    }
}
