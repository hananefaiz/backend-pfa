package com.arrgano.controller;


import com.arrgano.dto.GroupRequest;
import com.arrgano.model.WomenGroup;
import com.arrgano.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    public ResponseEntity<WomenGroup> createGroup(@RequestBody GroupRequest request) {
        return ResponseEntity.ok(groupService.createGroup(request));
    }

    @GetMapping
    public ResponseEntity<List<WomenGroup>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<WomenGroup>> getGroupsByLocation(@PathVariable String location) {
        return ResponseEntity.ok(groupService.getGroupsByLocation(location));
    }
}
