package by.vlad.task1.main;

import by.vlad.task1.creator.Creator;
import by.vlad.task1.creator.impl.CreatorImpl;
import by.vlad.task1.entity.CustomArray;
import by.vlad.task1.entity.CustomArrayStatistic;
import by.vlad.task1.entity.Warehouse;
import by.vlad.task1.entity.comparator.ArrayFirstItemComparator;
import by.vlad.task1.exception.ReaderException;
import by.vlad.task1.observer.impl.CustomArrayObserverImpl;
import by.vlad.task1.parser.CustomParser;
import by.vlad.task1.parser.impl.CustomParserImpl;
import by.vlad.task1.reader.TextFileReader;
import by.vlad.task1.reader.impl.TextFileReaderImpl;
import by.vlad.task1.repository.Repository;
import by.vlad.task1.repository.Specification;
import by.vlad.task1.repository.impl.ArrayLengthSpecification;
import by.vlad.task1.service.CustomArrayMath;
import by.vlad.task1.service.impl.CustomArrayMathImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Task1Part2Main {
    public static void main(String[] args) {
        TextFileReader textFileReader = new TextFileReaderImpl();
        List<String> strings = null;
        try {
            strings = textFileReader.readArraysFromFile("src\\main\\resources\\arrays.txt");
        } catch (ReaderException e) {
            e.printStackTrace();
        }

        CustomParser customParser = new CustomParserImpl();

        Map<Integer, List<Integer>> map = customParser.parseStringsList(strings);

        Repository repository = Repository.getInstance();
        Warehouse warehouse = Warehouse.getInstance();

        Creator creator = new CreatorImpl();
        CustomArrayMath customArrayMath = new CustomArrayMathImpl();
        CustomArrayObserverImpl customArrayObserver = new CustomArrayObserverImpl();
        CustomArrayStatistic parameter;
        CustomArray customArray;

        for (List<Integer> integerList : map.values()) {

            customArray = creator.createArrayFromList(integerList);

            customArray.attach(customArrayObserver);

            parameter = new CustomArrayStatistic(customArrayMath.minNumber(customArray),
                    customArrayMath.maxNumber(customArray),
                    customArrayMath.sumStream(customArray));

            warehouse.put(customArray.getId(), parameter);
            repository.add(customArray);
        }

        //System.out.println(repository.get(2).toString());
       // System.out.println(warehouse.get(3));

        int[] array = new int[]{93, 4, 3, 9, 78};

        repository.get(2).setArray(array);

       // System.out.println(repository.get(2).toString());
       // System.out.println(warehouse.get(3));

        Specification specification = new ArrayLengthSpecification(3, 8);

        List<CustomArray> customArrayList = repository.query(specification);

        for (CustomArray c : customArrayList) {
            System.out.println(c.toString());
        }

        Comparator<CustomArray> customArrayComparator = new ArrayFirstItemComparator();

        customArrayList = repository.sort(customArrayComparator);

        for (CustomArray c : customArrayList) {
            System.out.println(c.toString());
        }

    }
}
