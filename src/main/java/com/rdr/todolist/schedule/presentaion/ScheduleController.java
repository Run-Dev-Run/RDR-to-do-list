package com.rdr.todolist.schedule.presentaion;

import com.rdr.todolist.schedule.application.ScheduleService;
import com.rdr.todolist.schedule.dto.bundle.ScheduleCreateBundle;
import com.rdr.todolist.schedule.dto.bundle.ScheduleUpdateBundle;
import com.rdr.todolist.schedule.dto.request.ScheduleCreateRequest;
import com.rdr.todolist.schedule.dto.request.ScheduleUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/schedule")
@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/save")
    public String save(@RequestBody ScheduleCreateRequest request) {
        ScheduleCreateBundle bundle = ScheduleCreateBundle.convertFrom(request);
        scheduleService.create(bundle);
        return HttpStatus.CREATED.toString();
    }

    @GetMapping("/find")
    public ResponseEntity<?> find() {
        return new ResponseEntity<>(scheduleService.find(), HttpStatus.FOUND);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.find(id), HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id, @RequestBody ScheduleUpdateRequest request) {
        ScheduleUpdateBundle bundle = ScheduleUpdateBundle.convertFrom(id, request);
        scheduleService.update(bundle);
        return HttpStatus.OK.toString();
    }

    @PutMapping("/change/{id}")
    public String changeStatus(@PathVariable Long id) {
        scheduleService.changeStatus(id);
        return HttpStatus.OK.toString();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        scheduleService.delete(id);
        return HttpStatus.OK.toString();
    }
}
