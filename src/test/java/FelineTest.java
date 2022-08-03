import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import java.util.List;

@RunWith(Parameterized.class)
public class FelineTest {
    private final int expectedCountKittens;
    private final int actualCountKittens;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    Feline feline;

    public FelineTest(int expectedCountKittens, int actualCountKittens) {
        this.expectedCountKittens = expectedCountKittens;
        this.actualCountKittens = actualCountKittens;
    }

    @Parameterized.Parameters
    public static Object[][] getCountKittens()
    {
        return new Object[][] {
                {5, 5},
                {0, 0}
        };
    }

    @Test
    public void getFamilyReturnCorrectValue() {

    String expectedFamily = "Кошачьи";
    String actualSoundCat = feline.getFamily();

    assertEquals("Family is incorrect", expectedFamily, actualSoundCat);
    }


    @Test
    public void getKittensCallWithEmptyValue(){

        int expectedKittens = 1;
        int actualKittens = feline.getKittens();

        assertEquals("Kittens must be 1", expectedKittens, actualKittens);
    }

    @Test
    public void getKittensCallWithIntegerValue(){

        int actualKittens = feline.getKittens(actualCountKittens);

        assertEquals("Kittens must be integer", expectedCountKittens, actualKittens);
    }


    @Test
    public void EatMeatReturnListObject() throws Exception{
        List<String> list = List.of("Животные", "Птицы", "Рыба");
        Mockito.doReturn(list).when(feline).getFood(Mockito.anyString());
        assertEquals(list, feline.eatMeat());
    }


}
