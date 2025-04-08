package fi.haagahelia.wafflehaus.service;

import fi.haagahelia.wafflehaus.model.MenuItem;
import fi.haagahelia.wafflehaus.repository.MenuItemRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Service layer for handling menu item logic.
 * Responsible for retrieving, creating, and deleting menu items.
 * Annotated with @Service to mark it as a Spring-managed component,
 * allowing it to be injected into controllers and other components.
 */

@Service
public class MenuService {

    @Autowired
    private MenuItemRepository menuRepo;

    public List<MenuItem> getAll() {
        return menuRepo.findAll();
    }
    public MenuItem create(MenuItem item) {
        return menuRepo.save(item);
    }
    public void delete(Long id) {
        menuRepo.deleteById(id);
    }
}
