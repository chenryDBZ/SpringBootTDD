package com.galvanize.guild.service;

import com.galvanize.guild.entities.Guild;
import com.galvanize.guild.repository.GuildRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuildService {
    @Autowired
    GuildRepository guildRepository;

    public Guild addGuild(Guild guild) {
        return guildRepository.save(guild);
    }

    public List<Guild> getAllGuilds() {
        return guildRepository.findAll();
    }

    public Guild getGuildById(Long guildId) {
        return guildRepository.findById(guildId).get();
    }

    public List<Guild> getGuildByType(String param){
        return guildRepository.findByGuildType(param);
    }

    public boolean deleteGuild(Long guildId){
        Optional<Guild> g = guildRepository.findById(guildId);
        if (g.isPresent()){
            guildRepository.delete(g.get());
            return true;
        }else{
            return false;
        }
    }

    public Guild updateGuild(Guild guild) {
       Optional<Guild> t = guildRepository.findById(guild.getGuildId());
        if (t.isPresent()){
           return guildRepository.save(guild);
        }else{
            return null; // Exception
        }
    }
}
