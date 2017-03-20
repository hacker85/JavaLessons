package patterns.behavioral;

public class TemplateLesson {
    public static void main(String[] args) {
        Game game = new Pocker();
        game.run();
    }
}

abstract class Game {
    abstract void srartGame();
    abstract void play();
    abstract void endGame();

    void run() {
        srartGame();
        play();
        endGame();
    }
}

class Pocker extends Game {
    @Override
    void srartGame() {
        System.out.println("get card");
    }

    @Override
    void play() {
        System.out.println("play");
    }

    @Override
    void endGame() {
        System.out.println("loose money");
    }
}