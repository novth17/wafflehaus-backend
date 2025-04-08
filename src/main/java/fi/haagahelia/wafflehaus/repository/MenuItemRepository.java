package fi.haagahelia.wafflehaus.repository;
import fi.haagahelia.wafflehaus.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for accessing and managing MenuItem entities in the database.
 * Extends JpaRepository to provide standard CRUD operations, pagination, and sorting.
 * Commonly used methods:
 * - findAll()         – Get all menu items
 * - findById(Long id) – Get a menu item by its ID
 * - save(MenuItem)    – Save or update a menu item
 * - deleteById(Long)  – Delete a menu item by ID
 * - existsById(Long)  – Check if a menu item exists
 */

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
