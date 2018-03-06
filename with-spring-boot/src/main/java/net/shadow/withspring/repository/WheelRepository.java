package net.shadow.withspring.repository;

import net.shadow.withspring.entity.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelRepository extends JpaRepository<Wheel, Long> {
}
