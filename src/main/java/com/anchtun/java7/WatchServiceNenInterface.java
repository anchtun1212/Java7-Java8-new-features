package com.anchtun.java7;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * A watch service that watches registered objects for changes and events. For example a file manager may
 * use a watch service to monitor a directory for changes so that it can update its display of the list of
 * files when files are created or deleted.
 * A Watchable object is registered with a watch service by invoking its register method,
 * returning a WatchKey to represent the registration. When an event for an object is detected the key is signalled,
 * and if not currently signalled, it is queued to the watch service so that it can be retrieved by consumers
 * that invoke the poll or take methods to retrieve keys and process events. Once the events have been processed
 * the consumer invokes the key's reset method to reset the key which allows the key to be signalled
 * and re-queued with further events.
 * Registration with a watch service is cancelled by invoking the key's cancel method.
 * A key that is queued at the time that it is cancelled remains in the queue until it is retrieved.
 * Depending on the object, a key may be cancelled automatically. For example, suppose a directory is watched
 * and the watch service detects that it has been deleted or its file system is no longer accessible.
 * When a key is cancelled in this manner it is signalled and queued, if not currently signalled.
 * To ensure that the consumer is notified the return value from the reset method indicates if the key is valid.
 * A watch service is safe for use by multiple concurrent consumers. To ensure that only one consumer processes
 * the events for a particular object at any time then care should be taken to ensure that the key's reset method
 * is only invoked after its events have been processed. The close method may be invoked at any time to close
 * the service causing any threads waiting to retrieve keys, to throw ClosedWatchServiceException.
 */
public class WatchServiceNenInterface {

	public static void main(String[] args) throws IOException, InterruptedException {
		directoryWatchService();
	}

	private static void directoryWatchService() throws IOException, InterruptedException {
		WatchService watchService = FileSystems.getDefault().newWatchService();
		Path path = Paths.get(System.getProperty("user.home"));
		path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY,
				StandardWatchEventKinds.ENTRY_DELETE);
		boolean poll = true;
		WatchKey key = watchService.take();
		while (poll) {
			for (WatchEvent<?> event : key.pollEvents()) {
				System.out.println("Event kind: " + event.kind() + "- for the file" + event.context());
			}
			poll = key.reset();
		}
	}
}
