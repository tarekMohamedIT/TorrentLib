package core.trackers;

import interfaces.ITracker;

public abstract class TrackerLink implements ITracker {

    String infoHash;
    String peerID;
    int port;
    String uploaded;
    String downloaded;
    String left;
    boolean isCompact;

    @Override
    public String assembleTrackerLink() {
        return null;
    }
}
