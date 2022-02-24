import java.util.Random;

public class LetterPool {

    Random randomLetter = new Random();

    public Character getRandomLetter()
    {
        int newLetterValue = randomLetter.nextInt(26) + 65; //generate a letter with randomized ASCII values
        return (char) newLetterValue;
    }

}
