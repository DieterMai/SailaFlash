package dev.dietermai.sailaflash.persistence.xml.job;

import java.time.LocalTime;

import dev.dietermai.sailaflash.persistence.xml.file.CardsFile;
import dev.dietermai.sailautil.dispatch.AbstractJob;
import dev.dietermai.sailautil.dispatch.JobResult;

public class SaveJob extends AbstractJob {

	private static volatile LocalTime lastSave;
	
	public static LocalTime getLastSavedTime() {
		return lastSave;
	}
	
	@Override
	public JobResult call() throws Exception {
		CardsFile.cardsFile.save();
		
		JobResult result = new JobResult(true, "Saved model");
		
		LocalTime time = LocalTime.now();
		lastSave = time;
		
		return result;
	}

}
