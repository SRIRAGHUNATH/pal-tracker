package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
   public TimeEntry create(TimeEntry timeEntry);

    public TimeEntry find(Long timeEntryId);

    public List list();

    TimeEntry update(Long eq, TimeEntry timeEntry);

    public void delete(Long timeEntryId);

    public boolean contains(Long id);
}
