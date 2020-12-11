package dev.dietermai.sailautil.dispatch;

import java.util.concurrent.ScheduledFuture;

public interface IJobAccess<T> {
	ScheduledFuture<T> getFuture();
	JobInfo getInfo();
}
