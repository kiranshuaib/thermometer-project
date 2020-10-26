import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ThermometerTest {
    public static void main(String[] args) throws IOException {

//       instantiating an object of class Thermometer
        Thermometer thermometer = new Thermometer();

        List<String> list;

//        Reading temperatures from csv file
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/temperature.txt"))) {

            list = br.lines().collect(Collectors.toList());

            List<Double> finalList = new ArrayList<>();

//            To convert string array list to double
            list.stream().filter(s -> s.endsWith("C"))
                    .map(s -> s.substring(0, s.length() - 1))
                    .forEach(s -> finalList.add(Double.parseDouble(s.trim())));

//            to convert any fehrenhiet reading to Celcius
            list.stream().filter(s -> s.endsWith("F"))
                    .map(s -> s.substring(0, s.length() - 1))
                    .map(s->thermometer.tempFtoC(Double.parseDouble(s.trim())))
                    .forEach(s->finalList.add(s));


            System.out.println(finalList);

//
            for (int i = 0, finalListSize = finalList.size(); i < finalListSize; i++) {
                // keep the previous isFreezing value
                boolean is_currently_freezing = thermometer.isFreezing();

                // keep the previous isBoiling value
                boolean is_currently_boiling = thermometer.isBoiling();

                // Set the next temp from the list
                thermometer.setTemp(finalList.get(i));


                System.out.println(thermometer.getTemp());
                System.out.println(thermometer.getTempF());

//                checking if freezing threshold reached for current temp reading
                System.out.println(thermometer.has_freezing_threshold_reached());


//                checking if boiling threshold reached for current temp reading
                System.out.println(thermometer.has_boiling_threshold_reached());

//              if current temp is freezing and that previous temperature is not freezing
//                notify the user
                if(thermometer.isFreezing() == true){
                    if(!is_currently_freezing){
                        System.out.println("temperature is freezing");
                    }
                }


////              if current temp is boiling and that previous temperature is not boiling,
////                notify the user
                if(thermometer.isBoiling() == true){
                    if(!is_currently_boiling){
                        System.out.println("temperature is Boiling");
                    }
                }


            }



        }
    }


    }

