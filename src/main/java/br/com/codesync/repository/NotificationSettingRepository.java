package br.com.codesync.repository;

import br.com.codesync.model.entity.NotificationSetting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotificationSettingRepository extends JpaRepository<NotificationSetting, UUID> {
}
