package com.galvanize.guild.entities;

import org.springframework.core.SpringVersion;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Guild {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guildId;

    private String guildName;
    private Long guildSize;
    private String guildType;

    public Guild(String guildName, Long guildSize, String guildType) {
        this.guildName = guildName;
        this.guildSize = guildSize;
        this.guildType = guildType;
    }

    public Guild() {
    }

    public Long getGuildId() {
        return guildId;
    }

    public void setGuildId(Long guildId) {
        this.guildId = guildId;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public Long getGuildSize() {
        return guildSize;
    }

    public void setGuildSize(Long guildSize) {
        this.guildSize = guildSize;
    }

    public String getGuildType() {
        return guildType;
    }

    public void setGuilType(String guilType) {
        this.guildType = guilType;
    }
}
