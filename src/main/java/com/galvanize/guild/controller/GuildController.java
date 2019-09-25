package com.galvanize.guild.controller;

import com.galvanize.guild.entities.Guild;
import com.galvanize.guild.service.GuildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guilds")
public class GuildController {

    @Autowired
    GuildService guildService;

    @PostMapping
    public Guild addGuild(@RequestBody Guild guild){
        return guildService.addGuild(guild);
    }

    @GetMapping("/all")
    public List<Guild> getAllGuilds(){
        return guildService.getAllGuilds();
    }

    @GetMapping("/{id}")
    public Guild getGuildById(@PathVariable Long id){
        return guildService.getGuildById(id);
    }

    @GetMapping("/type/{guildType}")
    public List<Guild> getGuildByType(@PathVariable String guildType){
        return guildService.getGuildByType(guildType);
    }
}
