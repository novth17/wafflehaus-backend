package fi.haagahelia.wafflehaus.controller;

import fi.haagahelia.wafflehaus.model.MenuItem; //waffle item model
import fi.haagahelia.wafflehaus.repository.MenuItemRepository;
import fi.haagahelia.wafflehaus.service.MenuService; //business logic
import org.springframework.beans.factory.annotation.Autowired; //inject service to controller
import org.springframework.http.ResponseEntity; // HTTP responses
import org.springframework.security.access.prepost.PreAuthorize; //secure controller method for admin
import org.springframework.web.bind.annotation.*; // @GetMapping, @PostMapping, etc. @RequestBody, @PathVariable

import java.util.List;

/**
 * REST controller for menu-related API endpoints.
 * Provides endpoints to get, add, and delete menu items.
 * Access to some endpoints is restricted to admin users.
 */

@RestController 
@RequestMapping("/api/menu") //for both get & post & delete
public class MenuController {

    @Autowired
    private MenuService menuService;
    private MenuItemRepository menuItemRepository;

     // Allow everyone to view individual menu items by ID
    @GetMapping("/{id}")
    public ResponseEntity<MenuItem> getItemByID(@PathVariable Long id) {
        return menuService.getById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
        }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MenuItem> create(@RequestBody MenuItem item) {
        return ResponseEntity.ok(menuService.create(item));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        menuService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
