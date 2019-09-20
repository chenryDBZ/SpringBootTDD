package com.galvanize.guild.service;

import com.galvanize.guild.entities.Guild;
import com.galvanize.guild.repository.GuildRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class GuildServiceTest {
    @Autowired
    GuildRepository guildRepository;
    @Autowired
    GuildService guildService;

    @Test
    public void addGuild() {
        Guild guild = new Guild("Phenix", (long) 77, "PVP");

        guild = guildService.addGuild(guild);

        assertNotNull(guild.getGuildId());
    }

    @Test
    public void deleteGuild() {
        Guild guild = new Guild("Doomed", (long) 77, "PVE");
        guildRepository.save(guild);
        Long guildId = guild.getGuildId();

        boolean deleted = guildService.deleteGuild(guildId);
        assertTrue(deleted);

        Optional<Guild> deletedGuild = guildRepository.findById(guild.getGuildId());
        assertFalse(deletedGuild.isPresent());
    }

    @Test
    public void getAllGuilds() {
        List<Guild> guilds = new ArrayList<>();
        for(int i = 0; i <20; i++){
            guilds.add(new Guild("Potent"+i, (long) 12, "PVP"+2));
        }
        guildRepository.saveAll(guilds);

        List<Guild> sGuild = guildService.getAllGuilds();

        for (Guild guild: sGuild) {
            assertNotNull(guild.getGuildId());
        }
    }

    @Test
    public void getGuildById() {
        Guild guild = new Guild("Fierce", (long) 67, "RP");
        guildRepository.save(guild);

        Guild newGuild = guildService.getGuildById(guild.getGuildId());

        assertNotNull(guild.getGuildId());
    }
}
