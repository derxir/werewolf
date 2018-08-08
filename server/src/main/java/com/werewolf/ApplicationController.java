package com.werewolf;

/**
 * Created by justin on 7/28/18.
 */

import com.werewolf.model.Game;
import com.werewolf.model.GameManager;
import com.werewolf.model.request.NewGameRequest;
import com.werewolf.model.response.NewGameResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
public class ApplicationController {

    Logger logger = LoggerFactory.getLogger(ApplicationController.class);

    @RequestMapping(path = "/greeting", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping(path = "/initGame", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public NewGameResponse initGame(@RequestParam(name = "command", required = true) String command,@RequestBody NewGameRequest request) {
        Game game = new Game.Builder()
                .wolf(request.getWolfQuantity())
                .villager(request.getVillagerQuantity())
                .build();
        int roomId = GameManager.getInstance().registerNewGame(game);
        logger.info(String.format("New room(%d) created.",roomId));
        NewGameResponse res = new NewGameResponse();
        res.setRoomId(roomId);
        return res;
    }

}