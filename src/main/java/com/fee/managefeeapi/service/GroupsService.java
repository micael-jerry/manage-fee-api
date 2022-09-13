package com.fee.managefeeapi.service;

import com.fee.managefeeapi.model.Groups;
import com.fee.managefeeapi.repository.GroupsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class GroupsService {
    private GroupsRepository groupRepository;

    @Transactional
    public List<Groups> saveAll(List<Groups> groupList) {
        return groupRepository.saveAll(groupList);
    }

    public List<Groups> getAll(Integer page, Integer size) {
        if (page != null && size != null) {
            return groupRepository.findAll(PageRequest.of(page, size)).toList();
        }
        return groupRepository.findAll();
    }

    public Groups getById(int id) {
        return groupRepository.findById(id).get();
    }

    public void deleteById(int id) {
        groupRepository.deleteById(id);
    }

    public void deleteAll(List<Integer> idList) {
        groupRepository.deleteAllByIdInBatch(idList);
    }

    public Groups putById(int id, Groups group) {
        Groups oldGroup = groupRepository.findById(id).get();
        if (group.getName() != null) {
            oldGroup.setName(group.getName());
        }
        if (group.getDescription() != null) {
            oldGroup.setDescription(group.getDescription());
        }
        return groupRepository.save(oldGroup);
    }
}
