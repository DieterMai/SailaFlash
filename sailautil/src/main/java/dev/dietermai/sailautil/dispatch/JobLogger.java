package dev.dietermai.sailautil.dispatch;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

import dev.dietermai.sailautil.dispatch.JobInfo.LifeCycleState;
import dev.dietermai.sailautil.dispatch.JobInfo.ResultState;

public class JobLogger {

	private final int maxSize = 100;
	private Consumer<String> loggingMethod = System.out::println;

	private final Queue<JobInfo> queue = new LinkedList<>();

	public void add(JobInfo jobInfo) {
		queue.add(jobInfo);
		if (queue.size() > maxSize) {
			queue.poll();
		}
	}
	
	public void logStart(JobInfo info) {
		loggingMethod.accept("Start with: "+info);
	}
	
	public void logEnd(JobInfo info) {
		loggingMethod.accept("Done with:  "+info);
	}
	

	/** Not Thread save. if dump() and add() are invoked at the same the, the result of dump my be not correct. */
	public void dump() {
		Queue<JobInfo> tempQueue = new LinkedList<>(queue);
		tempQueue.forEach(this::log);
	}

	private void log(JobInfo info) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("%1$-20s", info.getStart())).append(" ");
		sb.append(String.format("%1$-20s", info.getEnd())).append(" ");
		sb.append(String.format("%1$-15s", info.getElapsed())).append(" ");
		sb.append(String.format("%1$-5s", info.getLifeCycleState())).append(" ");
		sb.append(String.format("%1$-10s", info.getResultState())).append(" ");
		sb.append(String.format("%1$-20s", info.getName())).append(" ");

		if (info.getLifeCycleState() == LifeCycleState.done) {
			if (info.getResultState() == ResultState.success) {
				sb.append(String.format("%1$-20s", info.getJobResult()));
			} else if (info.getResultState() == ResultState.error) {
				sb.append(String.format("%1$-20s", info.getE()));
			}
		}
		System.out.println(sb.toString());
	}
}
