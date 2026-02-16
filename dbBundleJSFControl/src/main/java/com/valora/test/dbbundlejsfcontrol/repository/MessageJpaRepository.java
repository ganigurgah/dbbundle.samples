package com.valora.test.dbbundlejsfcontrol.repository;

import com.valora.dbbundle.model.MessageEntity;
import com.valora.dbbundle.repository.MessageRepository;
import com.valora.test.dbbundlejsfcontrol.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageJpaRepository extends JpaRepository<Message, Integer>, MessageRepository {
    @Override
    @Query("SELECT m FROM Message m WHERE m.localeCode = :localeCode")
    List<Message> findByLocaleCode(@Param("localeCode") String localeCode);

    @Override
    @Query("SELECT m FROM Message m WHERE m.msgKey = :msgKey AND m.localeCode = :localeCode")
    MessageEntity findByMsgKeyAndLocaleCode(
            @Param("msgKey") String msgKey,
            @Param("localeCode") String localeCode);
}
