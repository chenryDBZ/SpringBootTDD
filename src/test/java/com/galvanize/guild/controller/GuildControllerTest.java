package com.galvanize.guild.controller;

import com.galvanize.guild.entities.Guild;
import com.galvanize.guild.repository.GuildRepository;
import com.galvanize.guild.service.GuildService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@Transactional
public class GuildControllerTest {

    @Autowired
    MockMvc mvc;
    @Autowired
    GuildRepository guildRepository;
    @Autowired
    GuildService guildService;

    private List<Guild> guilds = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 10; i++) {
            guilds.add(new Guild("Potent" + i, (long) 12, "RP" + i));
        }
        guildRepository.saveAll(guilds);
    }

    @Test
    public void addGuild() throws Exception {
        mvc.perform(post("/guilds")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"guildname\": \"GUILDNAME\", \"guildsize\": \"GUILDSIZE\", \"guildtype\": \"GUILDTYPE\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("guildId").exists());
    }

    @Test
    public void getAllGuilds() throws Exception {
        mvc.perform(get("/guilds/all"))
                .andExpect(status().isOk());
    }

    @Test
    public void getGuildById() throws Exception {
        mvc.perform(get("/guilds/4"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"guildId\":4,\"guildName\":\"Potent3\",\"guildSize\":12,\"guildType\":\"RP3\"}"));
    }

    @Test
    public void getGuildByType() throws Exception {
        mvc.perform(get("/guilds/type/RP5"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"guildId\":6,\"guildName\":\"Potent5\",\"guildSize\":12,\"guildType\":\"RP5\"}"));
    }
    @Test
    public void updateGuild() throws Exception {

    }
}
