package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.List.*;

public class InMemoryTimeEntryRepository  implements TimeEntryRepository {
    private final HashMap<Long, TimeEntry> repo = new HashMap<>();
    private Long privateId = 0L;

    public TimeEntry create(TimeEntry entry) {
        entry.setId(++privateId);
        repo.put(entry.getId(),entry);
        return entry;
    }

    public boolean contains(Long id){
        return repo.containsKey(id);
    }

    public TimeEntry find(Long id) {
        return repo.get(id);
    }

    public List<TimeEntry> list() {
        List list = new ArrayList(repo.values());
        return list;
    }

    public TimeEntry update(Long id, TimeEntry entry) {
        System.out.println("Hello "+repo);
        if(repo.containsKey(id)){
            entry.setId((id));
            repo.replace(id,entry);
        }
        System.out.println(id+"  Hello "+repo);
        return repo.get(id);
    }

    public void delete(Long id) {
        repo.remove(id);
    }
}
