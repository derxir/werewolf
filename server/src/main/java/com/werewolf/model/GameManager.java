package com.werewolf.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GameManager {

    private Map<Integer, Game> gameBook;

    private GameManager() {
        gameBook = new ConcurrentHashMap<>();
    }

    private static class Inner {
        private static final GameManager INSTANCE = new GameManager();
    }

    /**
     * thread safe Singleton lazy Instantiation
     * @return
     */
    public static GameManager getInstance() {
        return Inner.INSTANCE;
    }

    public int registerNewGame(Game game) {
        int roomId;
        do {
            roomId = getNewRoomId();
        } while (gameBook.keySet().contains(roomId));
        gameBook.put(roomId, game);
        return roomId;
    }


    private int getNewRoomId() {
        return (int) (Math.random() * 1000000);
    }
}
