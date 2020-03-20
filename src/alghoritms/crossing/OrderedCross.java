package alghoritms.crossing;

import parser.Coordinate;
import parser.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class OrderedCross implements CrossingAlghoritm {

    public Coordinates cross(Coordinates firstParent, Coordinates secondParent) {
        int indexFirstElement= (int)(Math.random() * (firstParent.getCoordinatesArray().size()-1));
        int indexSecondElement= (int)(Math.random() * (firstParent.getCoordinatesArray().size()-1));

        if (indexFirstElement > indexSecondElement) {
            int temp = indexFirstElement;
            indexFirstElement = indexSecondElement;
            indexSecondElement = temp;
        }

        try {
            Coordinates copyFirst = firstParent.clone();
            Coordinates copySecond = secondParent.clone();
            List<Coordinate> subList = copyFirst.getCoordinatesArray().subList(indexFirstElement, indexSecondElement);
            copySecond.getCoordinatesArray().removeAll(subList);

//            for(int i = 0; i < indexFirstElement; i++) {
////                subList.add(i, copySecond.getCoordinatesArray().get(i));
//
//                if (copySecond.getCoordinatesArray().size() != 0 && copySecond.getCoordinatesArray().get(0).getX() == firstParent.getCoordinatesArray().get(i).getX() && copySecond.getCoordinatesArray().get(0).getY() == firstParent.getCoordinatesArray().get(i).getY()) {
//                    subList.add(i, copySecond.getCoordinatesArray().get(i));
//                    copySecond.getCoordinatesArray().remove(0);
//                } else {
//                    break;
//                }
//            }

//            subList.addAll(subList);


            copySecond.getCoordinatesArray().removeAll(subList);
            subList.addAll(copySecond.getCoordinatesArray());


            ArrayList<Coordinate> doZwrotu = new ArrayList<Coordinate>(subList);
            Coordinates crossCoordinates = new Coordinates(doZwrotu, firstParent.getFileType());
            return  crossCoordinates;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return null;
    }
}