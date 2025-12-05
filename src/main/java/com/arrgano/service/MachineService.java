package com.arrgano.service;

import com.arrgano.model.Machine;
import com.arrgano.repository.MachineRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MachineService {
    private final MachineRepository machineRepository;

    public MachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    public List<Machine> getAllMachines() {
        return machineRepository.findAll();
    }

    public Machine addMachine(String name, String type, String status, double performance) {
        Machine machine = new Machine();
        machine.setName(name);
        machine.setType(type);
        machine.setStatus(status);
        machine.setPerformance(performance);
        return machineRepository.save(machine);
    }

    public void updateMachinePerformance(String id, double performance) {
        machineRepository.findById(id).ifPresent(machine -> {
            machine.setPerformance(performance);
            machineRepository.save(machine);
        });
    }
}
