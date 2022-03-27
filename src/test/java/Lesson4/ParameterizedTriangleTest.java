package Lesson4;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(TimerTestExtension.class)
public class ParameterizedTriangleTest {


    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(3,3,3),3.897114317029974),
                Arguments.of(new Triangle(3,5,3),4.14578098794425),
                Arguments.of(new Triangle(3,3,2),2.8284271247461903));
    }

    @ParameterizedTest(name="Площадь треугольника: позитивный сценаий, периметр треугольника {0}=={1}")
    @MethodSource("triangles")
    void countPerimeterPositive(Triangle triangle,double expectedResult) {
        double area = triangle.countArea(); //Act
        assertEquals(expectedResult,area);//Assert
    }


    public static Stream<Arguments> negativeTriangles() {
        return Stream.of(Arguments.of(new Triangle(0,3,3),"Sides must be positive"),
                Arguments.of(new Triangle(3,0,3),"Sides must be positive"),
                Arguments.of(new Triangle(3,3,0),"Sides must be positive"),
                Arguments.of(new Triangle(3,3,-1),"Sides must be positive"),
                Arguments.of(new Triangle(3,-1,3),"Sides must be positive"),
                Arguments.of(new Triangle(-1,3,3),"Sides must be positive"),
                Arguments.of(new Triangle(6,1,1),"One side can't be greater than sum of others"),
                Arguments.of(new Triangle(1,2,1),"One side can't be greater than sum of others"));

    }

    @ParameterizedTest(name="Площадь треугольника: негативный сценаий (треугольника {0}, ошибка:{1})")
    @MethodSource("negativeTriangles")
    public void countPerimeterNegativeTest(Triangle triangle,String errorText) {
         IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,triangle::countArea);
        assertEquals(errorText,illegalArgumentException.getMessage());
    }




}
