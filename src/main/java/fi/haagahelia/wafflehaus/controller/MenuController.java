package fi.haagahelia.wafflehaus.controller;

import fi.haagahelia.wafflehaus.model.MenuCategory;
import fi.haagahelia.wafflehaus.model.MenuItem; //waffle item model
import fi.haagahelia.wafflehaus.service.MenuService; //business logic

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; //inject service to controller
import org.springframework.http.ResponseEntity; // HTTP responses
import org.springframework.security.access.prepost.PreAuthorize; //secure controller method for admin
import org.springframework.web.bind.annotation.*; // @GetMapping, @PostMapping, etc. @RequestBody, @PathVariable
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

    // Public endpoint for get all menu items, if has category as param, get category and show it!
    @GetMapping
    public ResponseEntity<List<MenuItem>> getAllItems(@RequestParam(required = false) MenuCategory category) {
        if (category != null){
            return ResponseEntity.ok(menuService.getByCategory(category));
        }
        return ResponseEntity.ok(menuService.getAll());
    }

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
