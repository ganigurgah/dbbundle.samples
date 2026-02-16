package com.valora.test.dbbundlecontrol.repository;

import com.valora.dbbundle.repository.MessageRepository;
import com.valora.test.dbbundlecontrol.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageJpaRepository extends JpaRepository<Message, Long>, MessageRepository {

    @Override
    @Query("SELECT m FROM Message m WHERE m.localeCode = :localeCode")
    List<Message> findByLocaleCode(@Param("localeCode") String localeCode);

    @Override
    @Query("SELECT m FROM Message m WHERE m.msgKey = :msgKey AND m.localeCode = :localeCode")
    Message findByMsgKeyAndLocaleCode(
            @Param("msgKey") String msgKey,
            @Param("localeCode") String localeCode);
}
