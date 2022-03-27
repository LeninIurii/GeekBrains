package Lesson4;


import lombok.AllArgsConstructor;
import lombok.Data;

import static java.lang.Math.sqrt;

@Data
@AllArgsConstructor
public class Triangle {
private int a;
private int b;
private int c;

    public double countArea() {
        checkSidesPositive();
        checkOneSideIsSmaller();
        double a1 = (double) a;
        double b1 = (double) b;
        double c1 = (double) c;
        double p = (a1 + b1 + c1)/2;
        double s=p*((p-a1)*(p-b1)*(p-c1));
        return sqrt(s);

    }

    private void checkSidesPositive() {
    if(a<=0 || b<=0 ||c<=0){
        throw new IllegalArgumentException("Sides must be positive");
    }
}

    private void checkOneSideIsSmaller() {
    if(a + b <= c || b + c <= a|| c + a <= b) {
        throw new IllegalArgumentException("One side can't be greater than sum of others");
    }
}

}
