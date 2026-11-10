package com.example.springbd3big.user.permission.controller;

import com.example.springbd3big.user.model.Permission;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissions/names")
@Tag(name = "Permission catalog", description = "All permissions that can be granted. Requires permission:read.")
public class PermissionCatalogController {

    @GetMapping
    @Operation(summary = "Get permission names", description = "Required permission: permission:read", security = @SecurityRequirement(name = "bearerAuth"))
    public List<Permission> getPermissionNames() {
        return List.of(Permission.values());
    }
}
