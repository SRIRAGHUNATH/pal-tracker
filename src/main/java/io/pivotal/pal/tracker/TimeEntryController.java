package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }


    @PostMapping
    public ResponseEntity create(@RequestBody TimeEntry timeEntryToCreate) {

        TimeEntry created = timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity(created, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity read(@PathVariable Long id)
    {
                 TimeEntry entry = timeEntryRepository.find(id);
        ResponseEntity t = null;
        if(entry != null){
            t = new ResponseEntity(entry, HttpStatus.OK);
        }else{
            t = new ResponseEntity(entry, HttpStatus.NOT_FOUND);
        }
            return t;

    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {

        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable Long id,@RequestBody TimeEntry toUpdate) {
        toUpdate = timeEntryRepository.update(id,toUpdate);
        ResponseEntity t = null;
        if(toUpdate != null){
            t = new ResponseEntity(toUpdate,HttpStatus.OK);
        }else{
            t = new ResponseEntity(null,HttpStatus.NOT_FOUND);
        }
        return t;

    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        timeEntryRepository.delete(id);

        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
