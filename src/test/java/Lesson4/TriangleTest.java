package Lesson4;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Disabled("Перренесены в параметрезирован тесты")
public class TriangleTest {

    @Disabled("Перренесены в параметрезирован тесты")
    @Test
    @DisplayName("Площадь треугольника 3, 3, 3 = 3.897114317029974")
    public void countAreaSuccessfulTest() {
        Triangle triangle = new Triangle(3,3,3); //Arrange
        double area =  triangle.countArea(); //Act
        assertEquals(3.897114317029974,area);//Assert
    }

    @Disabled("Перренесены в параметрезирован тесты")
    @Test
    @DisplayName("Площадь треугольника 6, 3, 3 = 0")
    public void countAreaIsNullTriangleFailedTest() {
        Triangle triangle = new Triangle(6,3,3); //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,triangle::countArea);
        assertEquals("One side can't be greater than sum of others",illegalArgumentException.getMessage());
    }

    @Disabled("Перренесены в параметрезирован тесты")
    @Test
    @DisplayName("Площадь треугольника -1, 3, 3 ")
    public void countAreaIsNegativeTriangleFailedTest() {
        Triangle triangle = new Triangle(-1,3,3); //Arrange
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,triangle::countArea);
        assertEquals("Sides must be positive",illegalArgumentException.getMessage());
    }


}
