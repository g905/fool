package ru.g905.fool;

/**
 *
 * @author g905
 */
class Game {

    GameLogic gl = new GameLogic();

    public void start() throws Exception {
        gl.start();
    }

    public void init() {
        gl.init();
    }
}
