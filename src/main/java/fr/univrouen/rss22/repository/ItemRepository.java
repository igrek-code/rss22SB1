package fr.univrouen.rss22.repository;

import fr.univrouen.rss22.entities.Item;
import fr.univrouen.rss22.entities.ItemResume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<ItemResume> findAllResumeBy();
}
