package com.galvanize.guild.repository;

import com.galvanize.guild.entities.Guild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuildRepository extends JpaRepository<Guild, Long> {
    List<Guild> findByGuildType (String type);
}
