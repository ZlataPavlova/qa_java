import com.example.Feline;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import com.example.Cat;
import org.mockito.Mock;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    Feline feline;

    @Test
    public void getSoundCatReturnCorrectValue(){

        Cat cat = new Cat(feline);

        String expectedSoundCat = "Мяу";
        String actualSoundCat = cat.getSound();

        assertEquals("Sound cat is incorrect", expectedSoundCat, actualSoundCat);
    }

    @Test
    public void getFoodReturnListObject() throws Exception {

        Cat cat = new Cat(feline);
        List<String> list = List.of("Животные", "Птицы", "Рыба");
        Mockito.lenient().when(feline.eatMeat()).thenReturn(list);
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
        assertEquals(cat.getFood(), list);

    }
}
