import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class TestUlamki {
    @Test
    public void test(){
        double[] licznik = {3, 1, 5, 3, -2, 0};
        double[] mianownik = {10, 2, 1, 1, 4, 2};
        double[] wynik = {-2, 4};
        //Assert.assertEquals(wynik, Main.minimalny(licznik, mianownik));
        //Assert.assertEquals();
        //Assert.assertEquals(1, Main.ileNieskracalnych(licznik, mianownik));
        Assert.assertEquals(1, Main.nwd(1, 2));
        Assert.assertEquals(3, Main.nwd(3, 9));
        Assert.assertEquals(2, Main.nwd(-2, 4));
    }
}
