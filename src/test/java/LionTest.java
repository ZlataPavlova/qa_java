import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.junit.Rule;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


@RunWith(Parameterized.class)
public class LionTest {

    private final String wrongLionSex;
    private final String wrongMessenge;

    public LionTest(String wrongLionSex, String wrongMessenge) {
        this.wrongLionSex = wrongLionSex;
        this.wrongMessenge=wrongMessenge;
    }

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Spy
    Feline feline;
    String sex="Самка";

    @Parameterized.Parameters
    public static Object[][] getMessageForException()
    {
        return new Object[][] {
                {"самец", "Используйте допустимые значения пола животного - самец или самка"},
                {"Самк", "Используйте допустимые значения пола животного - самец или самка"}
        };
    }


    @Test
    public void getKittensReturnOneKittens() throws Exception {

        Lion lion = new Lion(sex, feline);

        Mockito.lenient().when(feline.getKittens()).thenReturn(1);
        assertEquals(feline.getKittens(), lion.getKittens());

    }

    @Test
    public void getFoodReturnListObject() throws Exception{

        Lion lion = new Lion(sex, feline);
        List<String> list = List.of("Животные", "Птицы", "Рыба");
        Mockito.lenient().when(feline.getFood("Хищник")).thenReturn(list);
        assertEquals(list ,lion.getFood() );
    }

    @Test
    public void callConstructorLionSexFemaleReturnFalse() throws Exception{

        Lion lion = new Lion("Самка", feline);
        boolean expectedHasMane = false;
        assertEquals("Female have not mane ", expectedHasMane, lion.doesHaveMane());

    }

    @Test
    public void callConstructorLionMaleReturnTrue() throws Exception{

        Lion lion = new Lion("Самец", feline);
        boolean expectedHasMane = true;
        assertEquals("Male should have mane ", expectedHasMane, lion.doesHaveMane());

    }

    @Rule public ExpectedException thrown = ExpectedException.none();
    @Test
    public void lionConstructorWithExceptionWrongSex() throws Exception{

        thrown.expect(Exception.class);
        thrown.expectMessage(wrongMessenge);
        Lion lion = new Lion(wrongLionSex, feline);
    }

}
