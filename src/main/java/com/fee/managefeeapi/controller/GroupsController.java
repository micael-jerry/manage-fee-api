package com.fee.managefeeapi.controller;

import com.fee.managefeeapi.model.Groups;
import com.fee.managefeeapi.service.GroupsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/group")
public class GroupsController {
    private GroupsService groupService;

    @GetMapping(value = "")
    public List<Groups> getAllGroups(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size
    ) {
        return groupService.getAll(page, size);
    }

    @PostMapping(value = "")
    public List<Groups> saveAllGroups(@RequestBody List<Groups> groupList) {
        return groupService.saveAll(groupList);
    }

    @DeleteMapping(value = "")
    public void deleteAllById(@RequestBody List<Integer> idList) {
        groupService.deleteAll(idList);
    }

    @GetMapping(value = "/{id}")
    public Groups getGroupById(@PathVariable int id) {
        return groupService.getById(id);
    }

    @PutMapping(value = "/{id}")
    public Groups putGroupById(
            @PathVariable int id,
            @RequestBody Groups group
    ) {
        return groupService.putById(id, group);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteGroupById(@PathVariable int id) {
        groupService.deleteById(id);
    }
}
