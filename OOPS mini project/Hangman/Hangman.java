import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hangman {
    private static final List<String> words = Arrays.asList(
        "The Shawshank Redemption", "The Godfather", "The Dark Knight", "Pulp Fiction", "Forrest Gump",
        "The Lord of the Rings: The Return of the King", "Inception", "Fight Club", "The Matrix", "Goodfellas",
        "The Empire Strikes Back", "The Lord of the Rings: The Fellowship of the Ring", "The Silence of the Lambs",
        "Saving Private Ryan", "The Green Mile", "Interstellar", "The Prestige", "The Departed", "The Lion King",
        "Back to the Future", "Avatar",  "Titanic", "Jurassic Park", "Schindler's List",
        "Whiplash", "The Dark Knight Rises", "Blade Runner", 
        "Jaws", "Alien", "A Clockwork Orange", "Django Unchained", "Raiders of the Lost Ark", "The Sixth Sense",
        "The Incredibles", "The Social Network", 
         "Ghostbusters", "Mean Girls", "The Princess Bride",
        "Moulin Rouge!", "The Wizard of Oz", "12 Years a Slave", "Moonlight", "La La Land", "Birdman",
        "Spotlight", "The Revenant", "Get Out", "Dunkirk", "The King's Speech", "Ford v Ferrari", "Parasite",
        "Once Upon a Time in Hollywood", "Dune", "No Time to Die", 
        "The Matrix Resurrections", "Transformers",
        "Pacific Rim", "Kingsman: The Secret Service", "John Wick", "Die Hard", "RoboCop", "Mad Max: Fury Road",
        "Superbad", "Step Brothers", "The Hangover", "Bridesmaids", "The 40-Year-Old Virgin", "Juno", "Little Miss Sunshine",
        "Crazy, Stupid, Love", "Love, Simon", "The Kissing Booth", 
        "The Edge of Seventeen", "The Last Summer", "To All the Boys I've Loved Before", "A Star is Born",
        "The Princess Diaries", "10 Things I Hate About You", "Clueless",
        "Legally Blonde", "The Wedding Planner", 
        "27 Dresses", "A Cinderella Story", "How to Lose a Guy in 10 Days", "50 First Dates", "Sweet Home Alabama",
        "The Notebook", "The Vow", "Dear John", "The Lucky One", "The Last Song", "Safe Haven",
         "The Choice",  "The Fault in Our Stars", "A Walk to Remember", "The Perfect Date",
        "After", "After We Collided", "The Half of It","The Time Traveler's Wife", "A Knight's Tale",
        "Crazy Rich Asians", "The Artist", "Knives Out","The Farewell", "About Time", "Big Hero Six",
        "Ready Player One",
        "Fast Times at Ridgemont High", "The Craft", "Bring It On", "Freaky Friday", "The Sisterhood of the Traveling Pants",
        "The Princess and the Frog", "When We First Met",


        // Marvel Series
        "Iron Man", "The Incredible Hulk", "Thor", "Captain America: The First Avenger", "The Avengers", 
        "Iron Man 2", "Thor: The Dark World", "Captain America: The Winter Soldier", "Guardians of the Galaxy",
        "Ant-Man", "Captain America: Civil War", "Doctor Strange", "Spider-Man: Homecoming", "Thor: Ragnarok",
        "Black Panther", "Avengers: Infinity War", "Ant-Man and The Wasp", "Captain Marvel", "Avengers: Endgame",
        "Spider-Man: Far From Home", "Black Widow", "Shang-Chi and the Legend of the Ten Rings", "Eternals",

        // X-Men Series
        "X-Men", "X2: X-Men United", "X-Men: The Last Stand", "X-Men Origins: Wolverine", "The Wolverine",
        "X-Men: First Class", "X-Men: Days of Future Past", "Deadpool", "Deadpool 2", "Dark Phoenix",
        "The New Mutants", "Logan",

        // DC Series
        "Batman Begins", "The Dark Knight", "The Dark Knight Rises", "Man of Steel", "Batman v Superman: Dawn of Justice",
        "Wonder Woman", "Justice League", "Aquaman", "Shazam!", "Birds of Prey", "Wonder Woman 1984", 
        "Zack Snyder's Justice League", "The Suicide Squad", "Black Adam"
    );

    private static int maxTries = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer = getRandomWord();
        StringBuilder currentGuess = new StringBuilder();
        maxTries=answer.length()/2;
        for (int i = 0; i < answer.length(); i++) {
            char ch = answer.charAt(i);
            if (Character.isLetter(ch)) {
                currentGuess.append('_'); 
            } else {
                currentGuess.append(ch); 
            }
        }

        int triesLeft = maxTries;
        List<Character> guessedLetters = new ArrayList<>();

        System.out.println("Welcome to Hangman!");
        System.out.println("You have " + maxTries + " incorrect guesses before you lose.");

        while (triesLeft > 0 && currentGuess.toString().contains("_")) {
            System.out.println("\nCurrent guess: " + currentGuess);
            System.out.println("Guessed letters: " + guessedLetters);
            System.out.print("Enter a letter: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);

            if (guessedLetters.contains(guess)) {
                System.out.println("You've already guessed that letter. Try again.");
                continue;
            }

            guessedLetters.add(guess);

            if (answer.toLowerCase().indexOf(guess) >= 0) {
                for (int i = 0; i < answer.length(); i++) {
                    if (answer.toLowerCase().charAt(i) == guess) {
                        currentGuess.setCharAt(i, answer.charAt(i)); 
                    }
                }
                System.out.println("Good guess!");
            } else {
                triesLeft--;
                System.out.println("Incorrect guess. You have " + triesLeft + " tries left.");
            }
        }

        if (currentGuess.toString().equals(answer)) {
            System.out.println("\nCongratulations! You've guessed the word: " + answer);
        } else {
            System.out.println("\nGame over! The word was: " + answer);
        }

        scanner.close();
    }

    private static String getRandomWord() {
        int randomIndex = (int) (Math.random() * words.size());
        return words.get(randomIndex);
    }
}